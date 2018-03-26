package Generic;

import java.awt.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Actitime.LoginPage;

public class ExcelWrite {

	@Test
	public void test_write() {

		FileInputStream fis = null;
		try {
			fis = new FileInputStream("E:/Login Details.xls");
		} catch (FileNotFoundException e) {
			Reporter.log("File Not Found", true);
		}
		Workbook wb = null;
		try {
			wb = WorkbookFactory.create(fis);
		} catch (InvalidFormatException e) {
			Reporter.log("File Format is not supportable", true);
		} catch (IOException e) {
			Reporter.log("IOException", true);
		}
		Sheet s = wb.getSheet("Sheet1");
//		new LoginPage(driver).Login("iiluser", "iiluser");
//		new Result_Page(driver).basicSearch("cell Biology");
//		List<WebElement> allsub = driver.findElements(By.xpath("//ol[@class='result-list']/li//h3"));
		/*int count = allsub.size();
		System.out.println(count);
		for (int i = 0; i < count; i++) {
			String subjects = allsub.get(i).getText();
			if (subjects.length() > 0) {
				s.createRow(i).createCell(0).setCellValue(subjects);
			} else {
				s.createRow(i).createCell(0).setCellValue("******");
			}
		}
		FileOutputStream fos = new FileOutputStream("E:/Login Details.xls");
		wb.write(fos);*/

	}
}
