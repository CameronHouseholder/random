package io.safensound.tests;

import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

import com.vaadin.testbench.TestBenchTestCase;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.safensound.configs.EnvironmentConfig;
import io.safensound.configs.LoginConfig;
import io.safensound.elements.LoginOverlayWrapperElement;
import io.safensound.support.Constants;
import io.safensound.utils.DriverUtil;
import io.safensound.utils.PageUtil;

public class BakeryLoginIT extends TestBenchTestCase {

    // configs
    private EnvironmentConfig environmentConfig;
    private LoginConfig loginConfig;

    // elements
    private LoginOverlayWrapperElement loginOverlayWrapper;

    @BeforeTest
    public void beforeTest() {
        // setup the driver
        setDriver(DriverUtil.getNewDriver(Constants.CHROME));
        // create the configs
        environmentConfig = ConfigFactory.create(EnvironmentConfig.class);
        loginConfig = ConfigFactory.create(LoginConfig.class);
    }

    @AfterTest
    public void afterTest() {
        getDriver().quit();
    }

    @BeforeMethod
    public void beforeMethod() {
        // load the app
        PageUtil.init(getDriver()).open(environmentConfig.baseUrl(), Constants.LOGIN_PAGE_URL);
    }

    @Test(enabled = true, description = "Check Login Page is Shown")
    @Description("Open the Bakery application in the browser and check that the Login page is shown")
    @Severity(SeverityLevel.BLOCKER)
    public void loginPageIsShown() {
        loginOverlayWrapper = $(LoginOverlayWrapperElement.class).first();
        assertThat(loginOverlayWrapper.getTitle()).as("Login Page Title").isEqualTo(Constants.LOGIN_PAGE_TITLE);
    }

    @Test(enabled = true, description = "Check Cannot Login with Valid Username and No Password")
    @Description("Login with a valid username and no password, application should remain on the login page")
    @Epic("Login")
    @Severity(SeverityLevel.BLOCKER)
    public void loginValidEmailNoPassword() {
        loginOverlayWrapper = $(LoginOverlayWrapperElement.class).first();
        loginOverlayWrapper.setLoginUsername(loginConfig.adminUsername());
        loginOverlayWrapper.clickSignIn();
        assertThat(loginOverlayWrapper.getTitle()).as("Login Page Title").isEqualTo(Constants.LOGIN_PAGE_TITLE);
    }

    @Test(enabled = false, description = "Check Login with Valid Username and Valid Password")
    @Description("Login with a valid username and valid password, application should allow user to login")
    @Severity(SeverityLevel.BLOCKER)
    public void loginValidEmailValidPassword() {
        loginOverlayWrapper = $(LoginOverlayWrapperElement.class).first();
        loginOverlayWrapper.setLoginUsername(loginConfig.adminUsername());
        loginOverlayWrapper.setLoginPassword(loginConfig.adminPassword());
        loginOverlayWrapper.clickSignIn();
        assertThat(loginOverlayWrapper.getTitle()).as("Login Page Title").isEqualTo(Constants.LOGIN_PAGE_TITLE);
    }
}
