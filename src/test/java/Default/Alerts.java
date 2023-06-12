package Default;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Katan\\OneDrive\\Desktop\\MyAutomation\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//https://chercher.tech/practice/practice-pop-ups-selenium-webdriver
		
		driver.get("https://chercher.tech/practice/practice-pop-ups-selenium-webdriver");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20 ,TimeUnit.SECONDS);
		String title = driver.getTitle();
		String url = driver.getCurrentUrl();
		
		//alert pop up
		Thread.sleep(1000);
		driver.findElement(By.name("alert")).click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		String alertText = alert.getText();
		alert.accept();
		
		//confirmation pop up
		
		Thread.sleep(1000);
		driver.findElement(By.name("confirmation")).click();
		Thread.sleep(1000);
		driver.switchTo().alert();
		Thread.sleep(1000);
		String confirmText = alert.getText();
		alert.accept();
		
		//Prompt pop up
		
		Thread.sleep(1000);
		driver.findElement(By.name("prompt")).click();
		String promptText = driver.switchTo().alert().getText();
		
		Robot robot = new Robot();
		Thread.sleep(1000);
		robot.mouseMove(785, 208);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(1000);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(1000);
		System.out.println(title + "\n" + url +"\n"+"\n" + alertText + "\n" + confirmText + "\n" + promptText);
		driver.quit();
	}
}