package Basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class FirstTest {
		private WebDriver driver;

		@BeforeTest
		public void launchBrowser() 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();			
			driver.get("https://ww.google.com");
		}
	@Test
	public void verifyHomePageTitle ()
	{
		driver.manage().window().maximize();
		String expectedTitle = "Google";
		String actualTitle = driver.getTitle();
		System.out.println("Title of the page is: " + driver.getTitle());
		Assert.assertEquals(expectedTitle, actualTitle);
	}

	@AfterTest
	public void terminateBrowser()
	{
			driver.quit();
	}
}
