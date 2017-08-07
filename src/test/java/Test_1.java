import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


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
webDriver=new ChromeDriver();

    }

    @After
    public void aTest() {
        System.out.println("After");
        webDriver.quit();
    }

    @Test
    public void test1() {
        System.out.println("Testa");
        webDriver.navigate().to("http://www.QA.com");
    }


}
