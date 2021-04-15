package covidrox.stepDefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebObjectRepo implements PageObjectSelector{

    @FindBy(id = "web_username")
    WebElement userName;

    @FindBy(id = "web_password")
    WebElement password;

    @AndroidFindBy(id = "web_error_message")
    WebElement errorMessage;

    @AndroidFindBy(id = "web_login_button")
    WebElement loginButton;

    WebDriver driver;

    WebObjectRepo(WebDriver driver){
       this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    @Override
    public void LoginWithCredentials(String username, String password) {

        userName.sendKeys(username);
        this.password.sendKeys(password);
        this.loginButton.click();
    }

    @Override
    public boolean isSuccessLogin() {
        return !errorMessage.isDisplayed();
    }

    @Override
    public void EnterOnlyUserName(String userName) {
        this.userName.sendKeys(userName);
    }

    @Override
    public boolean isSubmitButtonEnabled() {
        return loginButton.isEnabled();
    }
}
