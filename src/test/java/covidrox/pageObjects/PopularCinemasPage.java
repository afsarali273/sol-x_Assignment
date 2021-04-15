package covidrox.pageObjects;

import io.appium.java_client.pagefactory.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class PopularCinemasPage {

    WebDriver driver;
    public PopularCinemasPage(WebDriver driver){

        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)),this);
        this.driver=driver;
    }

    @AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View[1]")
    @iOSXCUITBy(xpath = "")
    WebElement btnPopular;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View")
    @iOSXCUITBy(xpath = "")
    WebElement firstContent;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button[1]")
    @iOSXCUITBy(xpath = "")
    WebElement hamburger_Menu;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View[5]")
    @iOSXCUITBy(xpath = "")
    WebElement sideMenu_Movies;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View[6]")
    @iOSXCUITBy(xpath = "")
    WebElement sideMenu_TvShows;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View[8]")
    @iOSXCUITBy(xpath = "")
    WebElement sideMenu_Close;

    @FindBy(xpath = "")
    @iOSXCUITBy(xpath = "")
    WebElement btn_upcoming;



    public void verifyPopularMoviesPage(){

        Assert.assertEquals(true,btnPopular.isDisplayed());

        Assert.assertEquals(true,hamburger_Menu.isDisplayed());
        String text = firstContent.getText();
        System.out.println("Movie details : "+ text);
        firstContent.click();

    }
}
