package Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class locators {

	public static void main(String[] args) throws InterruptedException {
		
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Katan\\OneDrive\\Desktop\\MyAutomation\\Selenium\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://www.google.com");
			driver.manage().window().maximize();
			driver.findElement(By.cssSelector("#APjFqb")).sendKeys("Selenium");		//locate element by css selector
			Thread.sleep(300);
			driver.findElement(By.tagName("textarea")).submit();  		//locate element by tag name.
			Thread.sleep(300);
			driver.findElement(By.className("VuuXrf")).click();
			Thread.sleep(300);
			driver.findElement(By.xpath("//a[@id='navbarDropdown']")).click();  //locate element by xpath.
			Thread.sleep(300);
			driver.findElement(By.linkText("About Selenium")).click(); //locate element by link text.
			Thread.sleep(300);
			driver.navigate().to("https://www.selenium.dev");
			Thread.sleep(300);
			driver.findElement(By.className("nav-link")).click();	//locate element by class name.
			Thread.sleep(300);
			driver.findElement(By.linkText("Events")).click();
			Thread.sleep(300);
			driver.findElement(By.cssSelector("#Layer_1")).click();		//locate element by css selector.
			Thread.sleep(300);
			driver.findElement(By.partialLinkText("Down")).click();//locate element by partial link text.
			Thread.sleep(500);
			driver.findElement(By.linkText("Documentation")).click();
			Thread.sleep(1000);
			driver.navigate().back();
			Thread.sleep(500);
			driver.navigate().back();
			Thread.sleep(500);
			driver.navigate().back();
			Thread.sleep(500);
			driver.navigate().back();
			Thread.sleep(500);
			driver.navigate().back();
			Thread.sleep(500);
			driver.quit();
	}
}