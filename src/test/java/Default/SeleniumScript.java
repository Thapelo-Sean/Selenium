package Default;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumScript {

	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Katan\\OneDrive\\Desktop\\MyAutomation\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://google.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getPageSource().length());
		String myCookies = driver.manage().getCookies().toString();
		
		System.out.println(myCookies);
		
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "Google";
		
		if (actualTitle.equalsIgnoreCase(expectedTitle)) 
		{
			System.out.println("Test successful, titles match");
		}
		
		else 
		{
			System.out.println("Test failed, titles do not match");
		}
		
		String cookieValue = driver.manage().getCookieNamed("1P_JAR").getValue(); //value
		System.out.println(cookieValue);
		String cookieExpectedValue = "2023-04-21-15";
		
		if (cookieValue.equalsIgnoreCase(cookieExpectedValue))
		{
			System.out.println("Test successful, cookies match");
		}
		
		else 
		{
			System.out.println("Test failed, cookies don't match");
		}
		
		driver.quit();
	}
}