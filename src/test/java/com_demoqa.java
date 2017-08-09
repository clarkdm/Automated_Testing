import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.base.Function;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

import javax.swing.*;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by dmclark on 08/08/17.
 */
public class com_demoqa {


    private WebDriver webDriver;
    private Add_a_User add_a_user;
    private LodInPage lodInPage;
    private FluentWait<WebDriver> wait;
    ExtentTest test;
    static ExtentReports report;


    @BeforeClass
    public static void bClass() {
        System.out.println("BeforeClass");

        String reportFilePath = "user.html";
        report = new ExtentReports();
        ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(reportFilePath);
        extentHtmlReporter.config().setReportName("ReportName");
        extentHtmlReporter.config().setDocumentTitle("DocumentTitle");
        report.attachReporter(extentHtmlReporter);
    }


    @Before
    public void bTest() {
        System.out.println("Before");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        //add_a_user = PageFactory.initElements(webDriver, Add_a_User.class);
        //lodInPage = PageFactory.initElements(webDriver, LodInPage.class);


        wait = new FluentWait<WebDriver>(webDriver)
                .withTimeout(30, SECONDS)
                .pollingEvery(5, SECONDS)
                .ignoring(NoSuchElementException.class);


    }

    @AfterClass
    public static void aClassTest() {
        System.out.println("AfterClass");

        report.flush();

    }

    @After
    public void aTest() {
        System.out.println("After");
//        if(result.getStatus() == ITestResult.FAILURE)
//        {
//            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
//            test.fail(result.getThrowable());
//        }
//        else if(result.getStatus() == ITestResult.SUCCESS)
//        {
//            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
//        }
//        else
//        {
//            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED", ExtentColor.ORANGE));
//            test.skip(result.getThrowable());
//        }
        webDriver.quit();

    }


    @Test
    public void test1() throws InterruptedException {


        test = report.createTest("test_1");


        webDriver.navigate().to("http://demoqa.com");

        webDriver.findElement(By.cssSelector("#menu-item-140")).click();


        Actions bild = new Actions(webDriver);
//        TimeUnit.SECONDS.sleep(1);

        bild.moveToElement(webDriver.findElement(By.cssSelector("#draggable"))).clickAndHold().moveByOffset(50, 30).build().perform();
        bild = new Actions(webDriver);
//        TimeUnit.SECONDS.sleep(5);
        webDriver.findElement(By.cssSelector("#menu-item-141")).click();


//        TimeUnit.SECONDS.sleep(1);
        bild.moveToElement(webDriver.findElement(By.cssSelector("#draggableview"))).clickAndHold().moveToElement(webDriver.findElement(By.cssSelector("#droppableview")),50,50).release().build().perform();
        bild = new Actions(webDriver);

//        TimeUnit.SECONDS.sleep(1);
//        TimeUnit.SECONDS.sleep(5);
        webDriver.findElement(By.cssSelector("#menu-item-143")).click();


//        TimeUnit.SECONDS.sleep(1);

        bild.moveToElement(webDriver.findElement(By.cssSelector("div.ui-resizable-handle.ui-resizable-se.ui-icon.ui-icon-gripsmall-diagonal-se"))).clickAndHold().moveByOffset(121, 49).release().build().perform();
        bild = new Actions(webDriver);

//        TimeUnit.SECONDS.sleep(5);
        webDriver.findElement(By.cssSelector("#menu-item-142")).click();
        webDriver.findElement(By.cssSelector("#ui-id-2")).click();

//        TimeUnit.SECONDS.sleep(1);

        for (int i = 1; i<13; i++) {
            bild.moveToElement(webDriver.findElement(By.cssSelector("#selectable_grid > li:nth-child("+i+")"))).clickAndHold().moveToElement(webDriver.findElement(By.cssSelector("#tabs-2 > div")),1,1).release().build().perform();

//            TimeUnit.SECONDS.sleep(1);
            bild = new Actions(webDriver);
        }
//        TimeUnit.SECONDS.sleep(5);
        webDriver.findElement(By.cssSelector("#menu-item-151")).click();
        webDriver.findElement(By.cssSelector("#ui-id-3")).click();

        TimeUnit.SECONDS.sleep(1);

        for (int i = 1; i<13; i++) {
            bild.moveToElement(webDriver.findElement(By.cssSelector("#selectable_grid > li:nth-child("+i+")"))).clickAndHold().moveToElement(webDriver.findElement(By.cssSelector("#tabs-3 > div")),1,1).release().build().perform();

            TimeUnit.SECONDS.sleep(1);
            bild = new Actions(webDriver);
        }
        TimeUnit.SECONDS.sleep(5);


//        String r = wait.until(new Function<WebDriver, String>() {
//            public String apply(WebDriver webDriver) {
//                return lodInPage.get_login();
//            }
//        });
//        System.out.println(r);
//        assertEquals("**Failed Login**", r, "**Successful Login**");
//
//        assertEquals("**Failed Login**", wait.until(webDriver -> lodInPage.get_login()), "**Successful Login**");
//
//
//        try {
//            test.log(Status.INFO, "Info level : " + test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "screenShotName")));
//            test.fail("Failed ");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }


}
