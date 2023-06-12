package Default;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebElementCommands {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Katan\\OneDrive\\Desktop\\MyAutomation\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement element = driver.findElement(By.id("APjFqb"));
        boolean status = element.isDisplayed();
        System.out.println(status);

        if(status){
            System.out.println("Element displayed");
            element.sendKeys("ToolsQA");
            element.submit();
        }
        else
        {
            System.out.println("Element not displayed");
            driver.close();
        }
        driver.close();
    }
}