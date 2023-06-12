package HandlingWindows;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class gettingWindowHandles {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Katan\\OneDrive\\Desktop\\MyAutomation\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.id("APjFqb")).sendKeys("DEMOQA");
		driver.findElement(By.name("btnK")).click();
		driver.findElement(By.partialLinkText("DEMOQA")).click();
		driver.navigate().to("https://demoqa.com/alertsWindows");
		driver.navigate().to("https://demoqa.com/browser-windows");
		
		String parentWindowHandle = driver.getWindowHandle();
		System.out.println("The Parent window handle is : " + parentWindowHandle); //get single window handle
		WebElement childWindowHandle = driver.findElement(By.id("tabButton"));
		
		int x;
		for (x = 0; x < 3; x++) 
		{
			childWindowHandle.click();
			System.out.println("Child window handle is : " + driver.getWindowHandle());
		}
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		for (String handles : windowHandles) 
		{
			System.out.println("All window handles are : " + handles);  //first window will be the parent., last 3 will children.
		}
		
		Thread.sleep(3000);
		driver.quit();
	}
}