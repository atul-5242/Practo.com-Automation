package com.parameter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	private static final String EXCEL_PATH = System.getProperty("user.dir") + "//src//test//resources//Exceldata//Data.xlsx";
	 
    /**
     * Reads a sheet where Column A (index 0) is the key and Column B (index 1) is the value.
     * Returns Map<key, value>.
     */
    public static Map<String, String> readKeyValueSheet(String sheetName) {
        Map<String, String> map = new HashMap<>();
        DataFormatter formatter = new DataFormatter();
 
        try (FileInputStream fis = new FileInputStream(EXCEL_PATH);
             Workbook workbook = WorkbookFactory.create(fis)) {
 
            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) return map;
 
            for (Row row : sheet) {
                if (row == null) continue;
 
                Cell keyCell = row.getCell(0); // Column A
                Cell valCell = row.getCell(1); // Column B
 
                String key = keyCell == null ? "" : formatter.formatCellValue(keyCell).trim();
                String value = valCell == null ? "" : formatter.formatCellValue(valCell).trim();
 
                if (!key.isEmpty()) {
                    map.put(key, value);
                }
            }
        } catch (IOException e) {
            // In production, prefer a logger. For now, print and return what we have.
            e.printStackTrace();
        }
        return map;
    }
    public static String getValueByKey(String sheetName, String key) {
        Map<String, String> kv = readKeyValueSheet(sheetName);
        return kv.getOrDefault(key, "");
    }
	
	
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
