package Basics;

import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionClass {

	public static void main(String[] args) throws InterruptedException  {
		try{
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();

			driver.get("https://www.google.com");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			Actions builder = new Actions(driver);

			WebElement inputSearch = driver.findElement(By.id("APjFqb"));
			builder.moveToElement(inputSearch).build().perform();
			WebElement search = driver.findElement(By.name("q"));
			builder.moveToElement(search).build().perform();

			Action seriesOfActions;

			seriesOfActions = builder
					.click(inputSearch)
					.sendKeys(inputSearch , "Selenium")
					.keyDown(search, Keys.ENTER)
					.build();
			seriesOfActions.perform();

		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
	}
}