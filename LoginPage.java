package Actitime;

import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginPage {

	public static WebDriver driver;

	
	public void login()  {
	driver.findElement(By.id("username")).sendKeys("user");
	driver.findElement(By.name("pwd")).sendKeys("user");
	driver.findElement(By.xpath("//a[@id='loginButton']")).click();
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String title= driver.getTitle();
	if(title.contains("actiTIME"))
	{
		System.out.println("Actitime Login is successful");
	}
	else
	{
		System.out.println("Actitime Login is not successful");
	}
	
	}
	
	public void logout() {	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//a[@id='logoutLink']")).click();		
		String title= driver.getTitle();
		if(title.contains("actiTIME - Login"))
		{
			System.out.println("Logout Successful");
		}
		else
		{
			System.out.println("Logout not Successful");
		}
		}
	
	
	
	public void login(String username, String password)  {
		
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.name("pwd")).sendKeys(password);
		driver.findElement(By.xpath("//a[@id='loginButton']")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String title= driver.getTitle();
		if(title.contains("actiTIME"))
		{
			System.out.println("Actitime Login is successful");
		}
		else
		{
			System.out.println("Actitime Login is not successful");
		}
		
		}

	
}
