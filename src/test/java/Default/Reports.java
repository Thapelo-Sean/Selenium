package Default;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Reports {

    public static WebDriver driver;
    public static ExtentReports extent;
    public static ExtentSparkReporter spark;
    public static ExtentTest test;
    public static ExtentTest node;
    public static Throwable throwable;


    @BeforeTest
    public void test()
    {
        extent = new ExtentReports();
        spark = new ExtentSparkReporter("./Report/spark.html");
        extent.attachReporter(spark);
        throwable = new RuntimeException("A runtime exception");
    }

    @Test
    public void startTest()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Katan\\OneDrive\\Desktop\\MyAutomation\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://google.com");

        if(driver.getTitle().equalsIgnoreCase("Google"))
        {
            test = extent.createTest("Navigation Test").assignDevice("Samsung Galaxy S23 Ultra 5G 256GB")
                    .assignAuthor("Thapelo Matji").assignCategory("Tag1")
                    .log(Status.PASS, "Navigated to the specified Url");
            extent.setSystemInfo("Operating System", "Android v13");
            test.addScreenCaptureFromPath("./Report/ScreenshotReport1.png");
            node = test.createNode("Success Node")
                    .pass("pass");
        }
        else 
        {
            test = extent.createTest("Navigation Test").assignCategory("Tag2")
                    .assignAuthor("Thapelo Matji").assignDevice("Apple iPhone 14 plus")
                    .log(Status.FAIL, "Failed to navigate to the specified url");
            extent.setSystemInfo("Operating System", "iOS 16.0");
            node = test.createNode("Failure Node")
                    .fail("fail");
            test.fail(throwable);
            test.fail(MediaEntityBuilder.createScreenCaptureFromPath("./Report" ,"ScreenshotReport.png").build());
          //  test.log(Status.FAIL, throwable);
        }
    }

    @AfterTest
    public static void endTest() throws InterruptedException {
        extent.flush();
        Thread.sleep(500);
        driver.quit();
    }
}