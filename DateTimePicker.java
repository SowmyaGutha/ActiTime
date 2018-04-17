package TestCase;

import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Generic.GenericMethods;

public class DateTimePicker {
	// public static String URL = "http://demo.guru99.com/test/";
	public static String URL = "https://demos.telerik.com/kendo-ui/datetimepicker/index";
	public static WebDriver driver;
	String dateTime = "03/26/1990 05:30 AM";
	GenericMethods g = new GenericMethods();

	@BeforeTest
	public void setURL() {
		driver = g.getDriver();
		g.browserInitiate(URL);
		g.browserWait();

	}

	// @Test
	public void dateTimePickerInput() {
		WebElement datebox = driver.findElement(By.xpath("//input[@name='bdaytime']"));
		datebox.sendKeys("03261990");
		datebox.sendKeys(Keys.TAB);
		datebox.sendKeys("0530PM");
		g.browserWait();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		g.browserWait();
	}

	@Test
	public void dateTimePickerIcon() throws InterruptedException {
		WebElement selectDate = driver.findElement(By.xpath("//span[@aria-controls='datetimepicker_dateview']"));
		selectDate.click();
		WebElement nextLink = driver.findElement(By.xpath("//div[@id='datetimepicker_dateview']//div[@class='k-header']//a[contains(@class,'k-nav-next')]"));
		WebElement midLink = driver.findElement(By.xpath("//div[@id='datetimepicker_dateview']//div[@class='k-header']//a[contains(@class,'k-nav-fast')]"));
		WebElement previousLink = driver.findElement(By.xpath("//div[@id='datetimepicker_dateview']//div[@class='k-header']//a[contains(@class,'k-nav-prev')]"));
		String date_dd_MM_yyyy[] = (dateTime.split(" ")[0]).split("/");
		int yearDiff = Integer.parseInt(date_dd_MM_yyyy[2]) - Calendar.getInstance().get(Calendar.YEAR);
		midLink.click();
		if (yearDiff != 0) {
			if (yearDiff > 0) {
				for (int i = 0; i < yearDiff; i++) {
					Thread.sleep(5000);
				//	System.out.println("Year Diff->" + i);
					nextLink.click();
				}
			}
			else if (yearDiff < 0) {
				for (int i = 0; i < (yearDiff * (-1)); i++) {
					//System.out.println("Year Diff->" + i);
					Thread.sleep(5000);
					previousLink.click();
				}
			}
		}
		Thread.sleep(1000);
		List<WebElement> list_AllMonthToBook = driver.findElements(By.xpath("//div[@id='datetimepicker_dateview']//table//tbody//td//a"));
		for(WebElement option : list_AllMonthToBook)
		{
			System.out.println(option.getText());
		}
		
		//list_AllMonthToBook.get(Integer.parseInt(date_dd_MM_yyyy[1]) - 1).click();

		Thread.sleep(1000);

	}

//	@AfterTest
	public void closeBrowser() {
		g.browserClose();

	}
}
