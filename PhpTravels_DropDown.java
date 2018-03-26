package TestCase;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Generic.GenericMethods;

public class PhpTravels_DropDown {

	public static String URL = "https://info.perfectomobile.com/selenium-automation-essential-guide.html?";
	public static WebDriver driver;

	public static void main(String[] args) {
		try {
			GenericMethods g = new GenericMethods();
			driver=g.getDriver();
			g.browserInitiate(URL);
			g.browserWait();
			driver.findElement(By.xpath(".//*[@id='FirstName']")).sendKeys("sowmya");
			driver.findElement(By.id("LastName")).sendKeys("bm");
			driver.findElement(By.id("Email")).sendKeys("abc@gmail.com");
			driver.findElement(By.id("Company")).sendKeys("sowmya");
			WebElement element = driver.findElement(By.id("Mobile_Testing_Role__c"));
			WebElement element1 = driver.findElement(By.id("Country"));
			Select select = new Select(element);
			Select select1 = new Select(element1);
			select.selectByVisibleText("Testing / QA");
			select1.selectByVisibleText("India");
			

			//driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
