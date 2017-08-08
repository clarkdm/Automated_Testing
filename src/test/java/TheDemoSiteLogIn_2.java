import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.base.Function;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;


import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;


import static java.util.concurrent.TimeUnit.SECONDS;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by dmclark on 08/08/17.
 */
public class TheDemoSiteLogIn_2 {


    private WebDriver webDriver;
    private Add_a_User add_a_user;
    private LodInPage lodInPage;
    private FluentWait<WebDriver> wait;

    private ExtentReports report;
    private ExtentTest test;
    private String reportFilePath = "user.html";
    private ScreenShot screenShot;

//    @BeforeClass
//    public static void bClass() {
//        System.out.println("BeforeClass");
//    }

    //    @AfterClass
//    public static void aClass() {
//        System.out.println("AfterClass");
//    }


    @Before
    public void bTest() {
        System.out.println("Before");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        add_a_user = PageFactory.initElements(webDriver, Add_a_User.class);
        lodInPage = PageFactory.initElements(webDriver, LodInPage.class);


        wait = new FluentWait<WebDriver>(webDriver)
                .withTimeout(30, SECONDS)
                .pollingEvery(5, SECONDS)
                .ignoring(NoSuchElementException.class);


        report = new ExtentReports();
        ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(reportFilePath);
        extentHtmlReporter.config().setReportName("ReportName");
        extentHtmlReporter.config().setDocumentTitle("DocumentTitle");
        report.attachReporter(extentHtmlReporter);
        test = report.createTest("TestName");
        screenShot = new ScreenShot();


    }

    @After
    public void aTest() {
        System.out.println("After");
        webDriver.quit();
        report.flush();

    }


    @Test
    public void test1() throws InterruptedException {


        webDriver.navigate().to("http://thedemosite.co.uk/addauser.php");
        //TimeUnit.SECONDS.sleep(1);

        add_a_user.set_password("testsqw");
//        TimeUnit.SECONDS.sleep(1);

        add_a_user.set_username("testsqw");
        //TimeUnit.SECONDS.sleep(1);
        add_a_user.set_submit();
        //TimeUnit.SECONDS.sleep(10);
//        TimeUnit.SECONDS.sleep(1);
        //add_a_user.set_Login();
        //TimeUnit.SECONDS.sleep(10);
        // TimeUnit.SECONDS.sleep(1);
        webDriver.navigate().to("http://thedemosite.co.uk/login.php");
        //TimeUnit.SECONDS.sleep(1);
        lodInPage.set_username("testsqw");
        lodInPage.set_password("testsqw");
        lodInPage.set_submit();
//        TimeUnit.SECONDS.sleep(1);

        String r = wait.until(new Function<WebDriver, String>() {
            public String apply(WebDriver webDriver) {
                return lodInPage.get_login();
            }
        });
        System.out.println(r);
        assertEquals("**Failed Login**", r, "**Successful Login**");

        assertEquals("**Failed Login**", wait.until(webDriver -> lodInPage.get_login()), "**Successful Login**");


        try {
            test.log(Status.INFO, "Info level : "+test.addScreenCaptureFromPath(ScreenShot.take(webDriver, "screenShotName")));
            test.fail("Failed ");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
//    @Test
//    public void test1() throws InterruptedException {
//        System.out.println("Testa");
//        webDriver.navigate().to("http://thedemosite.co.uk");
//
//        TimeUnit.SECONDS.sleep(1);
//        webDriver.findElement(By.cssSelector("body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(6)")).click();
//        TimeUnit.SECONDS.sleep(1);
//
//        webDriver.findElement(By.name("username")).sendKeys("Tests");
//
//        webDriver.findElement(By.name("password")).sendKeys("Tests");
//
//
//        TimeUnit.SECONDS.sleep(2);
//        webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]")).click();
//        TimeUnit.SECONDS.sleep(2);
//
//        webDriver.findElement(By.cssSelector("body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(7)")).click();
//        TimeUnit.SECONDS.sleep(2);
//
//
//        webDriver.findElement(By.cssSelector("input:nth-child(1)")).sendKeys("Tests");
//        TimeUnit.SECONDS.sleep(2);
//        webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]")).sendKeys("Tests");
//        TimeUnit.SECONDS.sleep(2);
//        webDriver.findElement(By.cssSelector("form tr tr:nth-child(3) input")).click();
//
//        TimeUnit.SECONDS.sleep(2);
//
//        System.out.println(webDriver.findElement(By.cssSelector("big b")).getText());
//        assertEquals(webDriver.findElement(By.cssSelector("big b")).getText(), "**Successful Login**");
//
//        TimeUnit.SECONDS.sleep(3);
//    }
}
