package com.sloth.codegen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.dialect.OracleDialect;
import com.jfinal.plugin.activerecord.generator.ColumnMeta;
import com.jfinal.plugin.activerecord.generator.MetaBuilder;
import com.jfinal.plugin.activerecord.generator.TableMeta;

public class SlothMetaBuilder extends MetaBuilder {
	private List<String> tables;

	public List<TableMeta> build() {
		try {
			conn = dataSource.getConnection();
			dbMeta = conn.getMetaData();

			List<TableMeta> ret = new ArrayList<TableMeta>();
			buildTableNames(ret);
			for (TableMeta tableMeta : ret) {
				buildPrimaryKey(tableMeta);
				buildColumnMetas(tableMeta);
			}
			removeNoPrimaryKeyTable(ret);
			return ret;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

	@Override
	protected void buildColumnMetas(TableMeta tableMeta) throws SQLException {
		super.buildColumnMetas(tableMeta);
		for (ColumnMeta m : tableMeta.columnMetas) {
			m.isPrimaryKey = String.valueOf(m.name.equals(tableMeta.primaryKey));
		}
	}

	// 移除没有主键的 table
	protected void removeNoPrimaryKeyTable(List<TableMeta> ret) {
		for (java.util.Iterator<TableMeta> it = ret.iterator(); it.hasNext();) {
			TableMeta tm = it.next();
			if (StrKit.isBlank(tm.primaryKey)) {
				it.remove();
				System.err.println("表【" + tm.name + "】没有主键，无法生成！");
			}
		}
	}

	protected void buildTableNames(List<TableMeta> ret) throws SQLException {
		ResultSet rs = getTablesResultSet();
		while (rs.next()) {
			String tableName = rs.getString("TABLE_NAME");
			if (excludedTables.contains(tableName)) {
				continue;
			}
			if (isSkipTable(tableName)) {
				continue;
			}
			if (filterPredicate != null && filterPredicate.test(tableName)) {
				continue;
			}
			TableMeta tableMeta = new TableMeta();
			tableMeta.name = tableName;
			tableMeta.remarks = rs.getString("REMARKS");
			tableMeta.modelName = buildModelName(tableName);
			tableMeta.baseModelName = buildBaseModelName(tableMeta.modelName);
			ret.add(tableMeta);
		}
		rs.close();
	}

	protected String buildModelName(String tableName) {
		// 移除表名前缀仅用于生成 modelName、baseModelName，而 tableMeta.name 表名自身不能受影响
		if (removedTableNamePrefixes != null) {
			for (String prefix : removedTableNamePrefixes) {
				if (tableName.startsWith(prefix)) {
					tableName = tableName.replaceFirst(prefix, "");
					break;
				}
			}
		}
		
		// 将 oralce 大写的 tableName 转成小写，再生成 modelName
		if (dialect instanceof OracleDialect) {
			tableName = tableName.toLowerCase();
		}
		
		return StrKit.firstCharToUpperCase(StrKit.toCamelCase(tableName.toLowerCase()));
	}

	public SlothMetaBuilder(DataSource dataSource) {
		super(dataSource);
		this.tables = new ArrayList<>();
	}

	public SlothMetaBuilder(DataSource dataSource, String... tables) {
		this(dataSource);
		Collections.addAll(this.tables, tables);
	}

	@Override
	protected boolean isSkipTable(String tableName) {// 判断是否跳过表
		for (String tmp : tables) {
			if (tmp.equalsIgnoreCase(tableName)) {
				return false;
			}
		}
		return true;
	}

	@Override
	protected String buildAttrName(String colName) {// 属性名
		colName = colName.toLowerCase();
		return super.buildAttrName(colName);
	}
}