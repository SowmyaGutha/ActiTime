package Generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GenericMethods {

	public static WebDriver driver;

	public WebDriver getDriver() {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\sg830q\\Sudheer\\sample\\ActiTime\\Exe\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		return driver;
	}
	public void openBrowser(String Browser) {
		Browser = GenericMethods.getProperties().getProperty("browser");
		try {
			if (Browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "D:/Actitime/ActitimeProject/geckodriver.exe");
				driver = new FirefoxDriver();
				System.out.println("FireFox Browser is Launched");
			} else if (Browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
				driver = new ChromeDriver();
				System.out.println("Chrome Browser is Launched");
			} else if (Browser.equalsIgnoreCase("IE")) {
				driver = new InternetExplorerDriver();
				System.out.println("IE Browser is Launched");
			} else {
				System.out.println("Issue with Browser");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static Properties getProperties() {
		InputStream input = BaseClass.class.getClassLoader().getResourceAsStream("xpath.properties");
		Properties pop = new Properties();
		try {
			pop.load(input);
			return pop;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void applicationLaunch() {
		try {
			driver.manage().window().maximize();
			driver.get(GenericMethods.getProperties().getProperty("url"));
			// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void browserClose() {
		try {
			driver.close();
			//driver.quit();
			System.out.println("Browser is Closed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

		public void browserWait() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
