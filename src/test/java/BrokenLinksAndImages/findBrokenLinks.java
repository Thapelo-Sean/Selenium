package BrokenLinksAndImages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class findBrokenLinks {
    public static WebDriver driver;
    public static ExtentReports report;
    public static ExtentSparkReporter spark;


    public static void main(String [] args) {
        report = new ExtentReports();
        spark = new ExtentSparkReporter("./Report/BrokenLinksReport.html");
        report.attachReporter(spark);

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        try{
            driver.get("https://demoqa.com/broken");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            String actualTitle = "demoqa";

            if(actualTitle.equalsIgnoreCase(driver.getTitle()))
            {
                report.createTest("Navigation to specified Url")
                        .log(Status.PASS, "Navigated to the specified url")
                        .assignAuthor("Thapelo Matji");
            }
            else
            {
                System.out.println("Titles don't match");
                report.createTest("Navigation to specified url")
                        .log(Status.FAIL, "Titles don't match");
                driver.close();
            }

            List <WebElement> links = driver.findElements(By.tagName("a"));
            int linksSize = links.size();
            System.out.println("Number of links present are " + linksSize);
            String url;
            report.createTest("Getting all links")
                    .log(Status.PASS, "Got all links in the url")
                    .assignAuthor("Thapelo Matji");

            int i;
            for(i = 0; i < linksSize; i++)
            {
                WebElement element = links.get(i);
                url = element.getAttribute("href");
                verifyLinks(url);
                System.out.println(i);

                report.createTest("Iteration of links")
                        .log(Status.PASS, "Iterated through all links present")
                        .assignAuthor("Thapelo Matji");
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }

    private static void verifyLinks(String linkUrl) {

        try
        {
            URL verifyUrl = new URL(linkUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) verifyUrl.openConnection();
            httpURLConnection.setConnectTimeout(4000);
            httpURLConnection.connect();
            report.createTest("Opening connection")
                    .log(Status.PASS, "Opened connection for urls")
                    .assignAuthor("Thapelo Matji");

            if(httpURLConnection.getResponseCode() < 400)
            {
                System.out.println(linkUrl + " - " + httpURLConnection.getResponseCode() + " " + httpURLConnection.getResponseMessage());
            }
            else
            {
                System.out.println(linkUrl + " - " + httpURLConnection.getResponseCode() + " is a broken link.");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
            e.getMessage();
        }
        report.flush();
    }
}