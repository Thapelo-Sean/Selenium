package Default;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class dragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Katan\\OneDrive\\Desktop\\MyAutomation\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.id("APjFqb")).sendKeys("JQuery droppable");
		Thread.sleep(500);
		driver.findElement(By.name("btnK")).click();
		driver.findElement(By.partialLinkText("Droppable | jQuery UI")).click();
		driver.switchTo().frame(0);
		
		Actions action = new Actions(driver);
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		action.dragAndDrop(drag, drop).build().perform();
		Thread.sleep(1000);
		driver.quit();
	}
}