package POM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class homePage {
	
	WebDriver driver;
	
	public homePage(WebDriver driver)

	{
		this.driver = driver;
	}
	
	//find elements using @FindBy annotation
	
	//@FindBy(how = How.PARTIAL_LINK_TEXT, using = "See more") WebElement myAccountButton; //x3ajldb
	//@FindBy(how = How.CLASS_NAME, using = "xu06os2 x1ok221b") WebElement logOutButton; //xu06os2 x1ok221b
	
	public void myAccountButton() throws InterruptedException 
	{
		driver.navigate().to("https://www.facebook.com/thapelo.sean.35");
		//myAccountButton.click();
		Thread.sleep(2000);
		System.out.println("Page navigated to my account.");
	}
	
	public void logOutButton() 
	{
		driver.navigate().back();
		//logOutButton.click();
		System.out.println("Page navigated back to facebook homepage.");
	}
}