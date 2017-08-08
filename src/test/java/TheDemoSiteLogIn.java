import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static junit.framework.TestCase.assertEquals;


/**
 * Created by dmclark on 07/08/17.
 */
public class TheDemoSiteLogIn {

    private WebDriver webDriver;

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
    }

    @After
    public void aTest() {
        System.out.println("After");
        webDriver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        System.out.println("Testa");
        webDriver.navigate().to("http://thedemosite.co.uk");

        TimeUnit.SECONDS.sleep(1);
        webDriver.findElement(By.cssSelector("body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(6)")).click();
        TimeUnit.SECONDS.sleep(1);

        webDriver.findElement(By.name("username")).sendKeys("Tests");

        webDriver.findElement(By.name("password")).sendKeys("Tests");


        TimeUnit.SECONDS.sleep(2);
        webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]")).click();
        TimeUnit.SECONDS.sleep(2);

        webDriver.findElement(By.cssSelector("body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(7)")).click();
        TimeUnit.SECONDS.sleep(2);


        webDriver.findElement(By.cssSelector("input:nth-child(1)")).sendKeys("Tests");
        TimeUnit.SECONDS.sleep(2);
        webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]")).sendKeys("Tests");
        TimeUnit.SECONDS.sleep(2);
        webDriver.findElement(By.cssSelector("form tr tr:nth-child(3) input")).click();

        TimeUnit.SECONDS.sleep(2);

        System.out.println(webDriver.findElement(By.cssSelector("big b")).getText());
        assertEquals(webDriver.findElement(By.cssSelector("big b")).getText(), "**Successful Login**");

        TimeUnit.SECONDS.sleep(3);
    }


}
