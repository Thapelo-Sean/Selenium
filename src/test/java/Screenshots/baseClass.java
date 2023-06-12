package Screenshots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class baseClass {
	
	public static WebDriver driver;
	
	public static void initialization() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Katan\\OneDrive\\Desktop\\MyAutomation\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("APjFqb")).sendKeys("Screenshot Success");
		//driver.findElement(By.name("btnK")).click();

	}
	
	public void failed() 
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try 
		{
			FileUtils.copyFile(source, new File("C:\\Users\\Katan\\OneDrive\\Desktop\\MyAutomation\\Selenium\\Screenshots\\ScreenshotFailed.png"));
		}
		
		catch (IOException e)	
		{
			e.printStackTrace();
		}
	}
	
	public void success() 
	{
		File Fsource = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try 
		{
			FileUtils.copyFile(Fsource, new File("C:\\Users\\Katan\\OneDrive\\Desktop\\MyAutomation\\Selenium\\Screenshots\\ScreenshotSuccess.png"));
		}
		
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}