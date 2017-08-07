import jdk.nashorn.internal.runtime.PropertyHashMap;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.util.concurrent.TimeUnit;


//import static jdk.nashorn.internal.runtime.PropertyHashMap.findElement;


/**
 * Created by dmclark on 07/08/17.
 */
public class Test_1 {

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

    }

    @After
    public void aTest() {
        System.out.println("After");
        webDriver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        System.out.println("Testa");
        webDriver.navigate().to("http://www.QA.com");
        webDriver.manage().window().maximize();
        TimeUnit.SECONDS.sleep(1);
        webDriver.findElement(By.cssSelector("#menu > div.navigation-links-hugescreen.visible-f > ul > li:nth-child(2) > div > a > span")).click();
        TimeUnit.SECONDS.sleep(1);

        webDriver.findElement(By.cssSelector("#menu > div.navigation-links-hugescreen.visible-f > ul > li.navigation-list-item.search > a")).click();
        TimeUnit.SECONDS.sleep(1);

        webDriver.findElement(By.cssSelector("#select2-chosen-2")).click();
        TimeUnit.SECONDS.sleep(1);
        webDriver.findElement(By.cssSelector("#s2id_autogen2_search")).sendKeys("test",Keys.RETURN);


        TimeUnit.SECONDS.sleep(3);
    }


}
