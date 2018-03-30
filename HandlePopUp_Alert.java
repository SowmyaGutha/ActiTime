package TestCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Generic.GenericMethods;

public class HandlePopUp_Alert {
	public static String URL = "http://jsbin.com/usidix/1";
	public static WebDriver driver;
	public static void main(String[] args) {
		GenericMethods g = new GenericMethods();
		driver = g.getDriver();
		g.browserInitiate(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		g.browserWait();
		driver.findElement(By.xpath("html/body/input")).click();
		driver.switchTo().alert();
		String text=driver.switchTo().alert().getText();
		System.out.println("Text present on alert box is : " + text);
		g.browserWait();
		driver.switchTo().alert().accept();
		g.browserWait();
		driver.close();
	}

}
