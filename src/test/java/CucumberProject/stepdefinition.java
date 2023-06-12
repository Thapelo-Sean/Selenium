package CucumberProject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepdefinition {
	
	@Given("Open chrome and start the application")
	public void open_Chrome_and_launch_the_application ()  throws Throwable
	{
		System.out.println("This step launch google chrome and opens the application");
	}
	
	@When("Enter the username and password")
	public void enter_username_and_password() throws Throwable
	{
		System.out.println("This step enters the username and password");
	}
	
	@Then("Reset the credentials")
	public void reset_credentials() throws Throwable
	{
		System.out.println("This steps clicks on the reset button");
	}
}