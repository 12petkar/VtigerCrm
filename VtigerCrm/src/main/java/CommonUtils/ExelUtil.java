package CommonUtils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExelUtil {



	  public String getDataFromExcel(String Sheetname, int Rownum , int cellnum) throws EncryptedDocumentException, IOException {
		  
		  
			FileInputStream fls = new FileInputStream("src\\test\\resources\\Products.xlsx");
			
			Workbook wb = WorkbookFactory.create(fls);
			
			
			Sheet sh = wb.getSheet(Sheetname);
			
			Row rw = sh.getRow(Rownum);
			
			Cell cw = rw.getCell(cellnum);
			
			String value = cw.getStringCellValue();
			
			
		   return value;

		   
		   
	  }   
	  }