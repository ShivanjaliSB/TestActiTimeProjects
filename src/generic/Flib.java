package generic;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Flib {

	//generic reusable method to read the data
		public String readExcelData(String excelPath,String sheetName,int rowCount,int cellCount) throws EncryptedDocumentException, IOException
		{
			FileInputStream fis=new FileInputStream(excelPath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			Row row = sh.getRow(rowCount);
			Cell cell = row.getCell(cellCount);
			String data = cell.getStringCellValue();
		
			return data;
		}
		
		//generic reusable method to count row
		public int getRowCount(String excelPath, String sheetName) throws EncryptedDocumentException, IOException {
			FileInputStream fis=new FileInputStream(excelPath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			int rc = sh.getLastRowNum();
			
			return rc;
		}
		
		//generic reusable method to write data
		
		
		public void writeExceData(String excelPath,String sheetName,int rowCount,int cellCount,String data) throws EncryptedDocumentException, IOException
		{
			FileInputStream fis=new FileInputStream(excelPath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			Row row = sh.getRow(rowCount);
			
			Cell cell = row.createCell(cellCount);
			cell.setCellValue(data);
			
			FileOutputStream fos=new FileOutputStream(excelPath);
			wb.write(fos);
		}
		
		
		//generic reuable method for rowcount
		public void readRowCount(String excelPath,String sheetName) throws EncryptedDocumentException, IOException
		{
			FileInputStream fis=new FileInputStream(excelPath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			int rc = sh.getLastRowNum();
			System.out.println(rc);
		}
		
		//generic reusable method for properties file
		
		public String readPropertyFile(String excelPath,String key) throws IOException
		{
			FileInputStream fis=new FileInputStream(excelPath);
			
			Properties prop = new Properties();
			prop.load(fis);
			
			String value = prop.getProperty(key);
			return value;
			
		}

}
