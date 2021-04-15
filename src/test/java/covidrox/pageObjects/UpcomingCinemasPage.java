package covidrox.pageObjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITBy;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class UpcomingCinemasPage {

    UpcomingCinemasPage(WebDriver driver){

        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)),this);
    }


    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View[2]")
    @iOSXCUITBy(xpath = "")
    WebElement btnUpComing;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View")
    @iOSXCUITBy(xpath = "")
    WebElement firstContent;



    public void verifyUpComingMoviesPage(){

        Assert.assertEquals(true,btnUpComing.isDisplayed());
        btnUpComing.click();
        String text = firstContent.getText();
        System.out.println("Movie details : "+ text);
        firstContent.click();
    }


}
