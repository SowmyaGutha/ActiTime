package TestCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Generic.GenericMethods;

public class MouseOver {

	public static WebDriver driver;
	public static String URL = "https://www.johnlewis.com/";

	public static void main(String[] args) {
		GenericMethods g = new GenericMethods();
		driver = g.getDriver();
		g.browserInitiate(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		g.browserWait();
		driver.findElement(By.xpath("//div[@class='t130v5-close']")).click();
		g.browserWait();
		WebElement element = driver.findElement(By.xpath(".//*[@id='nn-nav-menu']/ul/li[1]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		g.browserWait();
		driver.findElement(By.xpath(".//*[@id='nn-nav-menu']/ul/li[1]/div/div[1]/ul/li[3]/a")).click();

	}

}
