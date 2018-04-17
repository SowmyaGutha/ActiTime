package TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Generic.GenericMethods;

public class UploadFile {
	public static String URL = "http://demo.guru99.com/test/upload/";
	public static WebDriver driver;
	public static void main(String[] args) {
		try {
		GenericMethods  g = new GenericMethods();
		driver = g.getDriver();
		g.browserInitiate(URL);
		g.browserWait();
		driver.findElement(By.id("uploadfile_0")).sendKeys("C:\\Users\\sg830q\\Sudheer\\sample\\ActiTime\\sowmya.txt");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.name("send")).click();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
