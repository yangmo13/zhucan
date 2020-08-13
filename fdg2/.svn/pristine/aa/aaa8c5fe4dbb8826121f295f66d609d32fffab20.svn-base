package com.sloth.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;

public class ExcelUtil {
	private static DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static void setCellValue(Sheet sheet, int rowIndex, int cellIndex, String value) {
		Row row = getRow(sheet, rowIndex);
		Cell cell = getCell(row, cellIndex);
		cell.setCellValue(value);
	}

	public static void setCellValue(Sheet sheet, int rowIndex, int cellIndex, String value, CellStyle cellStyle) {
		Row row = getRow(sheet, rowIndex);
		Cell cell = getCell(row, cellIndex);
		cell.setCellValue(value);
		cell.setCellStyle(cellStyle);
	}

	public static Row getRow(Sheet sheet, int rowIndex) {
		Row row = sheet.getRow(rowIndex);
		if (row == null) {
			row = sheet.createRow(rowIndex);
		}
		return row;
	}

	public static Cell getCell(Row row, int cellIndex) {
		Cell cell = row.getCell(cellIndex);
		if (cell == null) {
			cell = row.createCell(cellIndex);
		}
		return cell;
	}

	public static String getStringValue(Row row, int cellIndex) {
		Cell cell = null;
		if (row != null && (cell = row.getCell(cellIndex)) != null) {
			return getStringCellValue(cell);
		} else {
			return null;
		}
	}

	private static String getStringCellValue(Cell cell) {
		String ret;
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_BLANK:
			ret = "";
			break;
		case Cell.CELL_TYPE_BOOLEAN:
			ret = String.valueOf(cell.getBooleanCellValue());
			break;
		case Cell.CELL_TYPE_ERROR:
			ret = null;
			break;
		case Cell.CELL_TYPE_FORMULA:
			Workbook wb = cell.getSheet().getWorkbook();
			CreationHelper crateHelper = wb.getCreationHelper();
			FormulaEvaluator evaluator = crateHelper.createFormulaEvaluator();
			ret = getStringCellValue(evaluator.evaluateInCell(cell));
			break;
		case Cell.CELL_TYPE_NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date theDate = cell.getDateCellValue();
				ret = df.format(theDate);
			} else {
				ret = NumberToTextConverter.toText(cell.getNumericCellValue());
			}
			break;
		case Cell.CELL_TYPE_STRING:
			ret = cell.getRichStringCellValue().getString();
			break;
		default:
			ret = null;
		}
		if (ret != null) {
			ret = ret.trim();
		}
		return ret;
	}

	public static Number getNumericValue(Row row, int cellIndex) {
		Cell cell = null;
		if (row != null && (cell = row.getCell(cellIndex)) != null) {
			return cell.getNumericCellValue();
		} else {
			return null;
		}
	}

	public static Sheet copySheet(String name, Workbook workbook, Sheet sourceSheet) {
		Sheet sheet = workbook.cloneSheet(workbook.getSheetIndex(sourceSheet));
		workbook.setSheetName(workbook.getSheetIndex(sheet), name);
		return sheet;
	}
}