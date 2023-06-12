package HandlingWindows;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class testMultipleWindows {
	
	@Test
	public void testWindows() throws InterruptedException 
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Katan\\OneDrive\\Desktop\\MyAutomation\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://naukri.com/");
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		String parentWindowHandle = driver.getWindowHandle();
		System.out.println("Parent window handle is: " + parentWindowHandle);
		
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> itr = windowHandles.iterator();
				
		while(itr.hasNext()) 
		{
			String childWindowHandle = itr.next();
			
			if(!parentWindowHandle.equals(childWindowHandle)) 
			{
				driver.switchTo().window(childWindowHandle);
				System.out.println(driver.switchTo().window(childWindowHandle).getTitle());
				driver.close();
			}
		}
		
		driver.switchTo().window(parentWindowHandle);
		System.out.println("End of execution");
	}
}