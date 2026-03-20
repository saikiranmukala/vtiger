package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import genericUtility.ExcelUtility;

public class WritingDataToExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

//		FileInputStream fis = new FileInputStream("C:\\Users\\QSP\\Desktop\\E4-Selenium\\TestData.xlsx");
//		Workbook wb = WorkbookFactory.create(fis);
//		wb.getSheet("Fish").getRow(2).createCell(3).setCellValue("Octopus");
//		FileOutputStream fos = new FileOutputStream("C:\\Users\\QSP\\Desktop\\E4-Selenium\\TestData.xlsx");
//		wb.write(fos);
		ExcelUtility eUtil = new ExcelUtility();
		eUtil.writeDataToExcel("Animal", 3, 2, "Sheep");
		eUtil.writeDataToExcel("City", 2, 3, "Mumbai");
	}

}
