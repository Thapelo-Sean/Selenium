package BrokenLinksAndImages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class findingBrokenImages {

    public static WebDriver driver;

    public static void main(String [] args)
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://demoqa.com/broken");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        List<WebElement> images = driver.findElements(By.tagName("img"));
        int imagesSize = images.size();
        System.out.println("Total number of images present are " + imagesSize);
        String imageUrl;

        int i;
        for(i = 0; i < imagesSize; i++) {
            WebElement imageElement = images.get(i);
            imageUrl = imageElement.getAttribute("src");
            verifyLinks(imageUrl);

            try {
                boolean imageDisplayed = (Boolean) ((JavascriptExecutor) driver).executeScript("return (typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0);", imageElement);

                if (imageDisplayed) {
                    System.out.println("Display is Okay");
                } else {
                    System.out.println("Display is Broken");
                }
            } catch (Exception e) {
                System.out.println("Error occurred");
            }
        }
    }

    public static void verifyLinks(String imageUrl)
    {
        try
        {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000);
            connection.connect();

            if(connection.getResponseCode() >= 400)
            {
                System.out.println("HTTP STATUS - " + connection.getResponseCode() + " " + connection.getResponseMessage() + "is a broken image");
            }
            else
            {
                System.out.println("HTTP STATUS - " + connection.getResponseCode() + " " + connection.getResponseMessage());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            e.getMessage();
        }
    }
}