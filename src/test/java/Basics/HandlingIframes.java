package Basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HandlingIframes {

    public static void main(String [] arg0)
    {
        try
        {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get(" https://demoqa.com/frames ");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
            int numberOfFrames = iframes.size();
            System.out.println("Iframes present is this webpage are" + iframes);
            System.out.println("Total number of iframes are " + numberOfFrames);

            //switching to iframes

            driver.switchTo().frame("frame1").getTitle(); //by id
            System.out.println("The title of the iframe is " + driver.switchTo().frame("frame1").getTitle());
            System.out.println("Main Frame is " +  driver.switchTo().defaultContent().getTitle());
            driver.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Execution completed");
    }
}