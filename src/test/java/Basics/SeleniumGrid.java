package Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;


public class SeleniumGrid {
    public static WebDriver driver;
    public static String nodeUrl;
    public static void main(String[] args) {

        try {
            nodeUrl = "http://10.0.0.130:5555";
            ChromeOptions chromeOptions = new ChromeOptions();
            //chromeOptions.setCapability("browserName", "chrome");
            chromeOptions.setCapability("platformName", "Windows10");
            driver = new RemoteWebDriver(new URL(nodeUrl), chromeOptions);

            driver.get("https://google.com");
            driver.manage().window().maximize();
        } catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
   }
}