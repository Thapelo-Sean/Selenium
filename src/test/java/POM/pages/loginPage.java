package POM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class loginPage {

	WebDriver driver;
	
	public loginPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	
	//using @FindBy to locate elements
	//id=email
	//id=pass
	//name=login
	
	@FindBy(id = "email") WebElement emailTextBox;
	@FindBy(how = How.ID, using = "pass") WebElement passwordTextBox;
	@FindBy(how = How.NAME, using = "login") WebElement loginButton;
	
	public void setEmail(String stringEmail) 
	{
		emailTextBox.sendKeys(stringEmail);
		System.out.println("Email entered...");
	}
	
	public void setPassword (String StringPassword) 
	{
		passwordTextBox.sendKeys(StringPassword);
		System.out.println("Password entered...");
		
	}
	
	public void clickButton() 
	{
		loginButton.click();
		System.out.println("Login button pressed...");
	}
}