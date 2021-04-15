package covidrox.stepDefinations;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;


public class CovidRox {

    private WebDriver driver;
    public static String PLATFORM = null;
    PageObjectSelector pageObject;
    String validUserName = "userName1";
    String validPassword = "password1";

    String inValidUser = "inValidUser2";
    String inValidPassword = "inValidPassword2";

    @Given("^I am on the login page for (android|ios|web)$")
    public void OpenTheApplication(String deviceType) throws MalformedURLException {

        PLATFORM = deviceType;
        driver = getDriver(deviceType);
        pageObject = getPageObject();
        if (PLATFORM.contains("web")) {
            driver.get("https://yoururlforcovidrox.com");
            Assert.assertEquals("yourExpectedTitle", driver.getTitle());
        } else {
            //Assertion for ios/android
            Assert.assertEquals("", "");
        }
    }

    @When("I enter the valid credentials")
    public void EnterCredentials() {
        pageObject.LoginWithCredentials(validUserName, validPassword);
    }

    @When("I enter the invalid credentials")
    public void EnterInValidCredentials() {
        pageObject.LoginWithCredentials(inValidUser, inValidPassword);
    }

    @Then("I shall see successful login to landing screen")
    public void LandingScreen() {
        boolean isLoginSuccess = pageObject.isSuccessLogin();
        Assert.assertEquals(true, isLoginSuccess);
    }

    @Then("I shall see error message")
    public void ErrorMessage() {
        boolean isErrorMessage = !pageObject.isSuccessLogin();

        Assert.assertEquals(true, isErrorMessage);
    }

    @When("I enter either username or password only")
    public void EnterUserNameOrPassword() {
        pageObject.EnterOnlyUserName(validUserName);
    }

    @When("I shall not see submit button")
    public void CheckSubmitButtonDisplay() {
        Assert.assertEquals(true, pageObject.isSubmitButtonEnabled());
    }


    //Shall create a separate Page Object Class for below:
    public WebDriver getDriver(String deviceType) throws MalformedURLException {
        switch (deviceType) {
            case "web":
                return new ChromeDriver();
            case "android":
                return new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), getAndroidDesiredCapabilities());
            case "ios":
                return new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), getIOSDesiredCapabilities());
            default:
                return null;
        }

    }

    public PageObjectSelector getPageObject() {
        if (PLATFORM.equals("web")) {
            pageObject = new WebObjectRepo(driver);
        } else {
            pageObject = new MobileObjectRepo(driver);
        }
        return pageObject;
    }

    //Android

    private static DesiredCapabilities getAndroidDesiredCapabilities() {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability("appActivity", "com.covid.rox.MainActivity");
        caps.setCapability("appPackage", "com.covid.rox");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("platformVersion", "9");
        caps.setCapability("platformName", "Android");
        caps.setCapability("app", System.getProperty("user.dir") + "/src/test/resources/app/covid-rox.apk");

        return caps;
    }

    //IOS

    private static DesiredCapabilities getIOSDesiredCapabilities() {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        caps.setCapability("bundleId", "com.covid.rox");
        caps.setCapability("deviceName", "iPhone XS");
        caps.setCapability("platformVersion", "13.2");
        caps.setCapability("platformName", "iOS");

        return caps;
    }

}
