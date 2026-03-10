package com.parameter;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public static String getCellData(String sheetname, int colNum, int rowNum) {
		Workbook workbook = null;
		try {
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir")+"//src//test//resources//porpertiesData.xlsx");
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
 
		try {
			if (rowNum <= 0)
				return "";
 
			int sheetIndex = workbook.getSheetIndex(sheetname);
 
			if (sheetIndex == -1)
				return "";
 
			Sheet sheet = workbook.getSheetAt(sheetIndex);
			Row row = sheet.getRow(rowNum - 1);
			if (row == null)
				return "";
			Cell cell = row.getCell(colNum - 1);
			if (cell == null)
				return "";
 
			if (cell.getCellType() == CellType.STRING)
				return cell.getStringCellValue();
			else if (cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA) {
				String cellText = String.valueOf(cell.getNumericCellValue());
				return cellText;
			} else if (cell.getCellType() == CellType.BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());
 
		} catch (Exception e) {
			e.printStackTrace();
			return "row " + rowNum + " or column " + colNum + " does not exist  in xls";
		}
	}
}
