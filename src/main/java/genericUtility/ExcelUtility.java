package genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This is an utility class which works with Excel file
 * @author QSP
 * @version 25-09-26
 */
public class ExcelUtility {

	/**
	 * This is a generic method to fetch single cell data from Excel file
	 * @param sheetName
	 * @param rowIndex
	 * @param cellIndex
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getSingleDataFromExcelFile(String sheetName, int rowIndex, int cellIndex) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IPathUtility.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Cell c = wb.getSheet(sheetName).getRow(rowIndex).getCell(cellIndex);
		DataFormatter df = new DataFormatter();
		String value = df.formatCellValue(c);
		return value;
	}

	/**
	 * this is a generic method to fetch multiple data from Excel file
	 * @param sheetName
	 * @param startRowIndex
	 * @param startCellIndex
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public List<String> getMultipleDataFromExcelFile(String sheetName, int startRowIndex, int startCellIndex) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IPathUtility.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		DataFormatter df = new DataFormatter();
		List<String> a1 = new ArrayList<String>();
		for(int i=startRowIndex;i<=sh.getLastRowNum();i++)
		{
			try
			{
				Row r = sh.getRow(i);
				for(int j=startCellIndex;j<r.getLastCellNum();j++)
				{
					Cell c = r.getCell(j);
					String value = df.formatCellValue(c);
					a1.add(value);
				}
			}catch(NullPointerException e)
			{         }
		}
		return a1;
	}
	
	/**
	 * This is a generic method to write data to Excel file
	 * @param sheetName
	 * @param rowIndex
	 * @param cellIndex
	 * @param cellValue
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataToExcel(String sheetName, int rowIndex, int cellIndex, String cellValue) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IPathUtility.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row r;
		try
		{
			r = sh.getRow(rowIndex);
		}catch(NullPointerException e)
		{
			r = wb.createSheet(sheetName).createRow(rowIndex);
		}
		try
		{
			r.createCell(cellIndex).setCellValue(cellValue);
		}catch(NullPointerException e)
		{
			sh.createRow(rowIndex).createCell(cellIndex).setCellValue(cellValue);
		}
		FileOutputStream fos = new FileOutputStream(IPathUtility.excelPath);
		wb.write(fos);
	}
}
