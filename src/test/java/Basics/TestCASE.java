package Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCASE {
		@Test
		public void verifyHomePageTitle () 
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Katan\\OneDrive\\Desktop\\MyAutomation\\Selenium\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://www.google.com");
			driver.manage().window().maximize();
			String expectedTitle = "Google";
			String actualTitle = driver.getTitle();
			Assert.assertEquals(expectedTitle, actualTitle);
			driver.quit();
		}
		
		public WebDriver driver;
		
		
		@BeforeTest
		public void launchBrowser() 
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Katan\\OneDrive\\Desktop\\MyAutomation\\SeleniumProject1\\chromedriver.exe");
			driver = new ChromeDriver();			
			driver.get("https://ww.google.com");
		}
		
		@Test
		public void verifyPageTitle() 
		{
			String expectedTitle = "Google";
			String actualTitle = driver.getTitle();
			Assert.assertEquals(expectedTitle, actualTitle);
		}
		
		@AfterTest
		public void terminateBrowser() 
		{
			driver.quit();
		}
}
