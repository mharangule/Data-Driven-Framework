package resources;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	XSSFSheet sheet1;
	XSSFWorkbook workbook;

	public ExcelDataConfig(String excelpath) {
		try {
			File src = new File(excelpath);
			FileInputStream fis = new FileInputStream(src);
			workbook = new XSSFWorkbook(fis);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getData(int sheetnumber, int row, int column) {
		sheet1 = workbook.getSheetAt(sheetnumber);
		String data = sheet1.getRow(row).getCell(column).getStringCellValue();
		return data;
	}

	public int getRowCount(int sheetIndex) {
		int row= workbook.getSheetAt(sheetIndex).getLastRowNum();
		return row+1;
	}
}