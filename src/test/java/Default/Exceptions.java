package Default;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Exceptions {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Katan\\OneDrive\\Desktop\\MyAutomation\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		String keys = "Handling Exceptions in selenium";

		try
		{
			driver.findElement(By.id("APjFqbs")).sendKeys(keys); //FakeId
			System.out.println("Element found");
		}catch (Exception e)
		{
			System.out.println("Could not locate element");
		}
		finally {
			System.out.println("This block is always executed");
		}
		System.out.println("Flow of execution not interrupted");
		driver.quit();
	}

	@Test
	public void staleException()
	{
		driver= new ChromeDriver();
		driver.get("https://google.com");
		driver.manage().window().maximize();

		WebElement el1 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/textarea"));
		driver.navigate().refresh();
		el1.sendKeys("Testing 123");
		driver.close();
	}

	@Test
	public void handleStaleException()
	{
		//Open Browser
		driver = new ChromeDriver();
		driver.get("https://google.com");
		WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/textarea"));
		driver.navigate().refresh();

		try
		{
			element.sendKeys("Testing string");

		} catch (StaleElementReferenceException e) {
			WebElement element2 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/textarea"));
			element2.sendKeys("Testing string from the catch block");
			String str = element2.getAttribute("value");
			System.out.println("The string entered from catch block is --> " + str);
		}
	}
}