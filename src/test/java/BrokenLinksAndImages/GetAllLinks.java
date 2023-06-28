package BrokenLinksAndImages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GetAllLinks {
    public static WebDriver driver;

    //Get all links
    public static void main(String[] args)
    {
        try{
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("https://demoqa.com/links");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            String url = "";
            List<WebElement> allUrls = driver.findElements(By.tagName("a"));
            System.out.println("Number of URL's in the page are " + allUrls.size());

            Iterator <WebElement> iterator = allUrls.listIterator();
            while (iterator.hasNext())
            {
                url = iterator.next().getText();
                System.out.println(url);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.close();
    }
}