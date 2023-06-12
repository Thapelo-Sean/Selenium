package TestNG_DataProvider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testDDT {
	
	@SuppressWarnings("deprecation")
	@Test(dataProvider = "testData")
	public void testChrome(String username, String password) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Katan\\OneDrive\\Desktop\\MyAutomation\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
	}
	
	
	@DataProvider(name = "testData")
	public Object[][] testDataFeed()
	{
		Object[][] facebookData = new Object[2][2];
		
		//row1
		facebookData[0][0] = "Thapelo Matji";
		facebookData[0][1] = "MyPasswordTm!1";
		
		//row2
		facebookData[1][0] = "Shawn Linderg";
		facebookData[1][1] = "MyPAsswrpdSL!2";
		
		return facebookData;
	}
}
