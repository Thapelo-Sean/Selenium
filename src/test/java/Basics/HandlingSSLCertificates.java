package Basics;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HandlingSSLCertificates {

    public static ExtentReports extent;
    public static ExtentSparkReporter spark;

    @BeforeTest
    public void report()
    {
        extent = new ExtentReports();
        spark = new ExtentSparkReporter("./Report/SSLReport.html");
        extent.attachReporter(spark);
    }

    @Test
    public static void test1() throws InterruptedException {
        try
        {
            WebDriverManager.chromedriver().setup();
            ChromeOptions handlingSSL = new ChromeOptions();
            handlingSSL.setAcceptInsecureCerts(true);
            WebDriver driver = new ChromeDriver(handlingSSL);
            driver.get("https://expired.badssl.com/");
            System.out.println("The page title is " + driver.getTitle());
            Thread.sleep(1500);
            extent.createTest("SSL_Certificate")
                    .log(Status.PASS, "Navigated to website by accepting insecure certificate")
                    .assignAuthor("Thapelo Matji");
            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public static void test2() throws InterruptedException {
        try
        {
            WebDriverManager.chromedriver().setup();
            ChromeOptions handlingSSL2 = new ChromeOptions();
            handlingSSL2.setAcceptInsecureCerts(false);
            WebDriver driver = new ChromeDriver(handlingSSL2);
            driver.get("https://expired.badssl.com/");
            System.out.println("The title of the page is " + driver.getTitle());
            extent.createTest("SSL_Certificate")
                    .log(Status.WARNING,"SSL certificate error")
                    .assignAuthor("Thapelo Matji");
            Thread.sleep(1500);
            driver.quit();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @AfterTest
    public void endReport()
    {
        extent.flush();
    }
}