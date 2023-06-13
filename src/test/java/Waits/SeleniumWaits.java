package Waits;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;
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
		try
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.get("https://www.facebook.com");

		} catch (Exception e) {
			e.printStackTrace();
		}

		try
		{
			WebElement firstname = driver.findElement(By.xpath("//*[@id=\"email\"]"));
			WebElement password = driver.findElement(By.id("pass"));
			WebElement forgotAccount  = driver.findElement(By.linkText("Forgotten password?"));

			sendKeys(driver, firstname, Duration.ofSeconds(30),"Peter");
			sendKeys(driver, password, Duration.ofSeconds(30), "Parker");
			clickOn(driver, forgotAccount, Duration.ofSeconds(30));
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		try
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://demoqa.com/dynamic-properties");
			driver.findElement(By.id("visibleAfter")).click();
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}