package HandlingWindows;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class handlingChildWindows {

	public static void main(String[] args) throws InterruptedException {
		try
		{
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();

			driver.get("https://demoqa.com/browser-windows");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			String parentWindowHandle = driver.getWindowHandle();
			System.out.println("Parent window handle is: " + parentWindowHandle);
			WebElement childElementWindow = driver.findElement(By.id("windowButton"));

			int x;
			for (x = 0; x < 3; x++)
			{
				childElementWindow.click();
				Thread.sleep(500);
			}

			Set<String> windowHandles = driver.getWindowHandles();
			String lastWindowHandle = "";

			for (String handle : windowHandles)
			{
				driver.switchTo().window(handle);
				Thread.sleep(1000);
				driver.get("http://google.com");
				lastWindowHandle= handle;
			}

			driver.switchTo().window(parentWindowHandle);
			driver.findElement(By.name("q")).sendKeys("Parent Window will close in 3 seconds ");
			Thread.sleep(3000);
			driver.close();

			driver.switchTo().window(lastWindowHandle);
			driver.navigate().to("https://demoqa.com");
			Thread.sleep(1000);
			driver.close();
			System.out.println("End of execution");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}