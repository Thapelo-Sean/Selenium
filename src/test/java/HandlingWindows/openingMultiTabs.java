package HandlingWindows;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class openingMultiTabs {

	public static void main(String[] args) throws InterruptedException {
		try
		{
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();

			driver.get("https://www.google.com");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			driver.findElement(By.id("APjFqb")).sendKeys("Demoqa");
			Thread.sleep(500);
			driver.findElement(By.name("btnK")).click();
			driver.findElement(By.partialLinkText("DEMOQA")).click();
			driver.navigate().to("https://demoqa.com/alertsWindows");
			driver.navigate().to("https://demoqa.com/browser-windows");

			WebElement newTab = driver.findElement(By.id("tabButton"));

			int i;
			for (i = 0; i < 3; i++)
			{
				newTab.click();
				Thread.sleep(2000);
				System.out.println("New window opened");
			}
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}