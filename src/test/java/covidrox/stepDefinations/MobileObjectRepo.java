package covidrox.stepDefinations;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class MobileObjectRepo implements PageObjectSelector{

    @AndroidFindBy(id = "android_username")
    @iOSXCUITFindBy(id = "ios_username")
    MobileElement userName;

    @AndroidFindBy(id = "android_password")
    @iOSXCUITFindBy(id = "ios_password")
    MobileElement password;

    @AndroidFindBy(id = "android_error_message")
    @iOSXCUITFindBy(id = "ios_error_message")
    MobileElement errorMessage;

    @AndroidFindBy(id = "android_login_button")
    @iOSXCUITFindBy(id = "ios_login_button")
    MobileElement loginButton;

    MobileObjectRepo(WebDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator((MobileDriver)driver, Duration.ofSeconds(5)), this);
    }

    @Override
    public void LoginWithCredentials(String userName, String password) {
            this.userName.sendKeys(userName);
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
