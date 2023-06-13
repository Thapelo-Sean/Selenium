package CucumberProject;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class steps {
	
	public WebDriver driver;
	
	@SuppressWarnings("deprecation")
	@Given("Open google chrome and launch the application")
	public void Open_google_chrome_and_launch_the_application() 
	{
		System.out.println("This step opens google chrome and launches the application");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://facebook.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@When("I enter a valid username and valid password")
	public void I_enter_a_valid_username_and_valid_password() throws InterruptedException 
	{
		System.out.println("This step enters valid username and valid password");
		
		driver.findElement(By.id("email")).sendKeys("MyFacebookAccount@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("myFacebookPassword123");
		driver.findElement(By.name("login")).click();
		Thread.sleep(3000);
	}
	
	@Then("The user should be able to log in successfully")
	public void The_user_should_be_able_to_log_in_successfully() 
	{
		System.out.println("This step logs in successfully");
		driver.close();
	}
}