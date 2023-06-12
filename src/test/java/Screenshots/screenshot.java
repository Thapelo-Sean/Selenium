package Screenshots;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class screenshot {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Katan\\OneDrive\\Desktop\\MyAutomation\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.id("APjFqb")).sendKeys("Screenshot");
		Thread.sleep(2000);
		driver.findElement(By.name("btnK")).click();
		
		TakesScreenshot myScreenShot = (TakesScreenshot)driver;
		File source = myScreenShot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./Screenshots/NewScreenshot.png"));
		System.out.println("Screenshot was taken.");
		driver.close();
	}		
}