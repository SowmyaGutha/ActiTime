package Generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GenericMethods {

	WebDriver driver;

	public WebDriver getDriver() {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\sg830q\\Sudheer\\sample\\ActiTime\\Exe\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		return driver;
	}

	public void browserInitiate(String URL) {
		driver.manage().window().maximize();
		driver.get(URL);
	}

	public void browserClose() {
		driver.close();
	}

	public void browserWait() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
