package HandlingWindows;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class handlingMultipleWindows {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Katan\\OneDrive\\Desktop\\MyAutomation\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		String parentWindowHandle = driver.getWindowHandle();
		System.out.println("Parent window handle is: " + parentWindowHandle);
		driver.findElement(By.id("windowButton")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator <String> itr = windowHandles.iterator();
		
		while(itr.hasNext()) 
		{
			String childWindowHandle = itr.next();
			
			if(!parentWindowHandle.equals(childWindowHandle)) 
			{
				driver.switchTo().window(childWindowHandle);
				Thread.sleep(2000);
				driver.get("https://www.google.com");
				driver.manage().window().maximize();
				System.out.println("Child window handle is: " + childWindowHandle);
				Thread.sleep(1000);
				driver.close();	
			}
		}
		
		Thread.sleep(1000);
		driver.quit();
	}
}