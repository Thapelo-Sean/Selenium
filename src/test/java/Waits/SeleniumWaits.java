package Waits;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SeleniumWaits {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Katan\\OneDrive\\Desktop\\MyAutomation\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com");
		
		WebElement firstname = driver.findElement(By.xpath("//*[@id=\"email\"]"));
		WebElement password = driver.findElement(By.xpath("//*[@id=\"passContainer\"]"));
		WebElement forgotAccount  = driver.findElement(By.xpath("//*[@id=\"u_0_2_7P\"]/div[3]/a"));
		
		sendKeys(driver, firstname, Duration.ofSeconds(30),"Peter");
		sendKeys(driver, password, Duration.ofSeconds(30), "Parker");
		clickOn(driver, forgotAccount, Duration.ofSeconds(30));
	}
	
	public static void clickOn(WebDriver driver1, WebElement element, Duration timeout) {
		new WebDriverWait(driver1, timeout).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		
	}

	public static void sendKeys(WebDriver driver1, WebElement element, Duration i, String value) {
		new WebDriverWait(driver1, i).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}
	@Test
	public void implicitWaitExercise()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Katan\\OneDrive\\Desktop\\MyAutomation\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/dynamic-properties");

		driver.findElement(By.id("visibleAfter")).click();
		driver.close();
	}
}