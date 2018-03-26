package TestCase;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.seleniumhq.jetty7.io.NetworkTrafficListener.Empty;

import Generic.GenericMethods;

public class WindowHandles {

	public static WebDriver driver;
	public static String URL = "https://online.actitime.com/abc7/login.do";
	public static String linkName = "actiTIME";

	public static void main(String[] args) {

		GenericMethods g = new GenericMethods();
		driver = g.getDriver();
		g.browserInitiate(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		g.browserWait();
		List<WebElement> link = driver.findElements(By.xpath("//a"));
		System.out.println("Total number of links present in ActiTIME login page is : " + link.size());
		for (int i = 0; i < link.size(); i++) {
			String linkValue = link.get(i).getText();
			if (linkValue != null && !linkValue.isEmpty() && linkValue.contains(linkName)) {
				g.browserWait();
				String MainWindow = driver.getWindowHandle();
				String mainWindowName = driver.getTitle();
				System.out.println("Main Window Name is : " + mainWindowName
						+ " and its unique window Handles name is :" + MainWindow);
				g.browserWait();
				System.out.println("Clicked on one of the link in the ActiTIME login page");
				link.get(i).click();
				// To handle all new opened window.
				Set<String> s1 = driver.getWindowHandles();
				Iterator<String> i1 = s1.iterator();

				System.out.println(s1 + " " + i1);

				while (i1.hasNext()) {
					String ChildWindow = i1.next();

					if (!MainWindow.equalsIgnoreCase(ChildWindow)) {

						// Switching to Child window
						driver.switchTo().window(ChildWindow);
						String childWindowName = driver.getTitle();
						System.out.println("Child Window Name is : " + childWindowName
								+ " and its unique window Handles name is :" + ChildWindow);
						driver.close();
					}
				}
				// Switching to Parent window i.e Main Window.
				driver.switchTo().window(MainWindow);
			}
		}

	}
}