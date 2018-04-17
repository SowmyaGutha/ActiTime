package TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Generic.GenericMethods;

public class CheckBox {
	public static String SheetName = "Sheet1";
	public static String URL ="https://online.actitime.com/abc7/login.do";
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		GenericMethods g = new GenericMethods();
		g.getDriver();
		g.browserInitiate(URL);
		WebElement checkbox=driver.findElement(By.id("keepLoggedInCheckBox"));
		if(checkbox.isSelected())
		{
			System.out.println(checkbox.isSelected());
		}
		else
		{
			System.out.println(checkbox.isSelected());
		}
		
}
}