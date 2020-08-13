package com.sloth.sys.tag;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;

import com.jfinal.template.Directive;
import com.jfinal.template.Env;
import com.jfinal.template.expr.ast.Assign;
import com.jfinal.template.expr.ast.Expr;
import com.jfinal.template.expr.ast.ExprList;
import com.jfinal.template.io.Writer;
import com.jfinal.template.stat.ParseException;
import com.jfinal.template.stat.Scope;

public class RoleTag extends Directive {
	private List<Expr> exprs;
	private boolean any = true;

	// logical为and或or
	public void setExprList(ExprList exprList) {
		this.exprs = new ArrayList<Expr>();
		for (Expr expr : exprList.getExprArray()) {
			if (expr instanceof Assign) {
				Assign logical = (Assign) expr;
				if (logical.getId().equals("logical")) {
					any = "or".equals(logical.getRight().toString());
				} else {
					throw new ParseException("不支持的属性", stat.getLocation());
				}
			} else {
				exprs.add(expr);
			}
		}
	}

	public void exec(Env env, Scope scope, Writer writer) {
		boolean hasPermission = false;
		if (!any) {
			for (Expr expr : exprs) {
				if (!SecurityUtils.getSubject().hasRole(expr.toString())) {
					hasPermission = false;
					break;
				}
			}
		} else {
			for (Expr expr : exprs) {
				if (SecurityUtils.getSubject().hasRole(expr.toString())) {
					hasPermission = true;
					break;
				}
			}
		}
		if (hasPermission) {
			stat.exec(env, scope, writer);
		}
	}

	public boolean hasEnd() {
		return true; // 返回 true 则该指令拥有 #end 结束标记
	}
}
