package POM.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import POM.pages.homePage;
import POM.pages.loginPage;

public class loginTest extends TestBase {
	
	@Test
	public void init() throws InterruptedException
	{
		//login page
		loginPage login = PageFactory.initElements(driver, loginPage.class);
		login.setEmail("0622093978");
		login.setPassword("larson");
		login.clickButton();

		//home page
		homePage homepage = PageFactory.initElements(driver, homePage.class);
		Thread.sleep(2000);
		homepage.myAccountButton();
		Thread.sleep(2000);
		homepage.logOutButton();
	}
}