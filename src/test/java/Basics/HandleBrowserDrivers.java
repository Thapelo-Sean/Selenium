package Basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBrowserDrivers {
    public static void main(String[] args)
    {
        try
        {
            WebDriverManager.chromedriver().setup();
            ChromeDriver driver = new ChromeDriver();
            driver.get("https://google.com");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
