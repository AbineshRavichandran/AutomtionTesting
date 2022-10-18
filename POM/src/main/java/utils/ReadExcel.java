package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public String[][] ExcelData(String sheetName) throws IOException {

		// Step1: Setup the workbook path
		XSSFWorkbook wb = new XSSFWorkbook("./data/" + sheetName + ".xlsx");

		// Step2: Get into the Worksheet
		XSSFSheet ws = wb.getSheet("Sheet1");

		int lastRowNum = ws.getLastRowNum();

		short lastCellNum = ws.getRow(0).getLastCellNum();

		String[][] data = new String[lastRowNum][lastCellNum];

		for (int i = 1; i <= lastRowNum; i++) {

			for (int j = 0; j < lastCellNum; j++) {

				// Step3: Get into the ROW
				String CellValue = ws.getRow(i).getCell(j).getStringCellValue();

				data[i - 1][j] = CellValue;

			}

		}

		wb.close();

		return data;

	}

}
