package BrokenLinksAndImages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Iterator;
import java.util.List;


public class getAllLinks {

    //Get all links
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Katan\\OneDrive\\Desktop\\MyAutomation\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/links");

        String url = "";
        List<WebElement> allUrls = driver.findElements(By.tagName("a"));
        System.out.println("Number of URL's in the page are " + allUrls.size());

        Iterator <WebElement> iterator = allUrls.listIterator();
        while (iterator.hasNext())
        {
                url = iterator.next().getText();
                System.out.println(url);
                driver.quit();
        }
    }
}