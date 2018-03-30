package Generic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericMethods {

	WebDriver driver;
	public WebDriverWait myWait;

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

	public void webDriverWait() {
		myWait = new WebDriverWait(driver, 10);
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pwd")));
		driver.findElement(By.id("pwd")).sendKeys("password");
	}

	public void isEnabledFunction() {
		WebElement username_textbox = driver.findElement(By.id("username"));
		if (username_textbox.isEnabled()) {
			username_textbox.sendKeys("username");
		}
	}

	public void isSelectedFunction() {
		WebElement username_textbox = driver.findElement(By.id("username"));
		if (username_textbox.isSelected()) {
			username_textbox.click();
		}
	}

	public void wait_Until_Alertbox_Displayed() {
		if (myWait.until(ExpectedConditions.alertIsPresent()) != null) {
			System.out.println("Alert Present");
		}
	}

	public void element_ToBe_Clickable() {
		WebElement username_textbox = driver.findElement(By.id("username"));
		myWait.until(ExpectedConditions.elementToBeClickable(username_textbox));
	}

	public void frameToBeAvailableAndSwitchToIt() {
		myWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("Frameid")));
	}

}
