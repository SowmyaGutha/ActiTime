package Generic;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelRead {

	public int getExcelRowCount(String xlpath, String SheetName)
	{
	    try
	    {
	        FileInputStream fis= new FileInputStream(xlpath);
	        Workbook wb= WorkbookFactory.create(fis);
	        Sheet s= wb.getSheet(SheetName);
	        int rc=s.getLastRowNum();
	        return rc;
	    }
	    catch(Exception e)
	    {
	        return -1;
	    }
	}
	     
	public String getExcelCellValue(String xlpath, String SheetName, int row, int cell)
	{
	    try
	    {
	        FileInputStream fis= new FileInputStream(xlpath);
	        Workbook wb= WorkbookFactory.create(fis);
	        Sheet s= wb.getSheet(SheetName);
	        String v=s.getRow(row).getCell(cell).getStringCellValue();
	        return v;
	         
	    }
	    catch(Exception e)
	    {
	        return "";
	    }
	     
	     
	     
	     
	}
	}

