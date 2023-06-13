package HandlingWindows;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class linkingWindows {

	public static void main(String[] args) throws InterruptedException {
		try
		{
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();

			driver.get("https://demoqa.com/browser-windows");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			String parentWindowHandle = driver.getWindowHandle();
			System.out.println("Parent Window Handle is: " + parentWindowHandle);
			WebElement childWindowElement = driver.findElement(By.id("windowButton"));

			int x;
			for(x = 0; x < 3; x++)
			{
				childWindowElement.click();
				Thread.sleep(2000);
			}

			Set<String> windowHandles = driver.getWindowHandles();

			for(String handle: windowHandles)
			{
				driver.switchTo().window(handle);
				System.out.println("Child window handle is: " + handle);  //first window will the parent
				driver.get("http://google.com");
				driver.close();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}