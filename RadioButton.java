package TestCase;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Generic.GenericMethods;

public class RadioButton {
	public static WebDriver driver;
	public static String URL = "http://toolsqa.com/automation-practice-form/?firstname=&lastname=&photo=&continents=Asia&submit=";
	public static String Gender = "6";

	public static void main(String[] args) {

		GenericMethods g = new GenericMethods();
		driver = g.getDriver();
		g.browserInitiate(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		g.browserWait();
		List<WebElement> radioButton = driver.findElements(By.xpath("//input[@type='radio']"));
		for(int i=0; i<radioButton.size();i++)
		{
			String radioValue=radioButton.get(i).getAttribute("value");
			
			if(radioValue.equalsIgnoreCase(Gender))
					{
				radioButton.get(i).click();
					}
		}
		

	}

}
