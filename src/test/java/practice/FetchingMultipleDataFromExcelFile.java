package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import genericUtility.ExcelUtility;

public class FetchingMultipleDataFromExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

//		FileInputStream fis = new FileInputStream("C:\\Users\\QSP\\Desktop\\E4-Selenium\\TestData.xlsx");
//		Workbook wb = WorkbookFactory.create(fis);
//		Sheet sh = wb.getSheet("Fish");
//		DataFormatter df = new DataFormatter();
//		//		System.out.println(sh.getLastRowNum());
//		for(int i=0;i<=sh.getLastRowNum();i++)
//		{
//			try
//			{
//				Row r = sh.getRow(i);
//				//			System.out.println(r.getLastCellNum());
//				for(int j=0;j<r.getLastCellNum();j++)
//				{
//					Cell c = r.getCell(j);
//					String value = df.formatCellValue(c);
//					System.out.print(value+"   ");
//				}
//				System.out.println();
//			}
//			catch(NullPointerException e)
//			{
//			}
//		}
		ExcelUtility eUtil = new ExcelUtility();
		List<String> a1 = eUtil.getMultipleDataFromExcelFile("Fish", 0, 0);
		System.out.println(a1);
	}

}
