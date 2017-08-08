import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by dmclark on 08/08/17.
 */
public class LodInPage {


    @FindBy(css = "form tr tr:nth-child(1) input")
    private WebElement username;
    @FindBy(css = "form tr tr:nth-child(2) input")
    private WebElement password;
    @FindBy(css = "form tr tr:nth-child(3) input")
    private WebElement submit;
    @FindBy(css = "big b")
    private WebElement login;

    public void set_username(String uname) {
        username.sendKeys(uname);
    }

    public void set_password(String pass) {
        password.sendKeys(pass);
    }

    public void set_submit() {
        submit.click();
    }
    public String get_login(){
       return login.getText();
    }

}
