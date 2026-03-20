package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import genericUtility.ExcelUtility;

public class FetchingDataFromExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

//		FileInputStream fis = new FileInputStream("absolute path of Excel file");
//		Workbook wb = WorkbookFactory.create(fis);
//		Cell c = wb.getSheet("Animal").getRow(4).getCell(1);
//		DataFormatter df = new DataFormatter();
//		String value = df.formatCellValue(c);
//		System.out.println(value);
		ExcelUtility eUtil = new ExcelUtility();
		String value = eUtil.getSingleDataFromExcelFile("Animal", 4, 1);
		System.out.println(value);
		String value1 = eUtil.getSingleDataFromExcelFile("Bird", 4, 3);
		System.out.println(value1);
		
	}

}
