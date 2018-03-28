package com.task;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class GoogleSearch extends ApplicationConfiguration {

	public static void test_write() throws IOException, InterruptedException {
		FileInputStream fis = null;
		final String path = "D:/Actitime/selenium_assement/Resources";
		try {
			fis = new FileInputStream(path + "/URL Details.xlsx");
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
		System.out.println(properties.getProperty("Google"));
		String name = driver.findElement(By.xpath(properties.getProperty("Google"))).getAttribute("alt");
		// System.out.println(name);
		if (name.contains("Google")) {
			System.out.println("Google home page is displayed");
		} else {
			System.out.println("Google home page is displayed");
		}
		Thread.sleep(3000);
		// driver.findElement(By.name("q")).sendKeys("name");
		List<String> urls = new ArrayList<>();
		for (int i = 1; i <= 6; i++) {
			System.out.println("Keyword" + i);
			urls.addAll(getLinkElementForinput("Keyword" + i, path));
			driver.findElement(By.name(properties.getProperty("Google_SearchBox"))).clear();
		}

		System.out.println("Element Size: " + urls.size());

		for (int i = 0; i < urls.size(); i++) {
			s.createRow(i).createCell(0).setCellValue(urls.get(i));
		}
		FileOutputStream fos = new FileOutputStream(path + "/URL Details.xlsx");
		wb.write(fos);
		driver.close();
	}

	private static List<String> getLinkElementForinput(final String input, final String path) throws IOException {
		driver.findElement(By.name(properties.getProperty("Google_SearchBox"))).sendKeys(properties.getProperty(input));
		driver.findElement(By.name(properties.getProperty("Google_SearchBox"))).sendKeys(Keys.RETURN);
		createScreenShot(path);
		List<WebElement> linkElements = driver.findElements(By.xpath("//div[@id='search']//cite"));
		List<String> urls = new ArrayList<>();
		for (int i = 0; i < linkElements.size(); i++) {
			System.out.println(linkElements.get(i).getText());
			String subjects = linkElements.get(i).getText();

			if (subjects.length() > 0) {
				urls.add(subjects);
			} else {
				urls.add("******");
			}
		}
		return urls;
	}
}
