package TestCase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Generic.GenericMethods;

public class DownloadFile {

	public static String URL = "http://demo.guru99.com/test/yahoo.html";
	public static String wgetpath = "C:\\Users\\sg830q\\Sudheer\\sample\\ActiTime\\Exe\\Wget\\wget.exe";
	public static WebDriver driver;

	public static void main(String[] args) {

		GenericMethods g = new GenericMethods();
		driver = g.getDriver();
		g.browserInitiate(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		g.browserWait();
		WebElement downloadButton = driver.findElement(By.id("messenger-download"));
		String sourceLocation = downloadButton.getAttribute("href");
		String wget_command = "cmd /c C:\\\\Users\\\\sg830q\\\\Sudheer\\\\sample\\\\ActiTime\\\\Exe\\\\Wget\\\\wget.exe -P C: --no-check-certificate " + sourceLocation;

		try {
			Process exec = Runtime.getRuntime().exec(wget_command);
			int exitVal = exec.waitFor();
			System.out.println("Exit value: " + exitVal);
		} catch (InterruptedException | IOException ex) {
			System.out.println(ex.toString());
		}
		driver.close();
	}
}
