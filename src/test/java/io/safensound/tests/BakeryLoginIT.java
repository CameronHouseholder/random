package io.safensound.tests;

import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

import com.vaadin.testbench.TestBenchTestCase;

import io.safensound.configs.EnvironmentConfig;
import io.safensound.configs.LoginConfig;
import io.safensound.elements.LoginOverlayWrapperElement;
import io.safensound.support.Constants;
import io.safensound.utils.DriverUtil;

public class BakeryLoginIT extends TestBenchTestCase {

    // configs
    private EnvironmentConfig environment;
    private LoginConfig login;

    // elements
    private LoginOverlayWrapperElement loginOverlayWrapper;

    @BeforeTest
    public void beforeTest() {
        // setup for vaadin license
        System.setProperty("vaadin.proKey", "cameron.house84@gmail.com/pro-6b57f741-aa2d-4959-aa4a-a6aa1532ad8b");
        // setup the driver
        setDriver(DriverUtil.getNewDriver(Constants.CHROME_HEADLESS));
        // create the configs
        environment = ConfigFactory.create(EnvironmentConfig.class);
        login = ConfigFactory.create(LoginConfig.class);
    }

    @AfterTest
    public void afterTest() {
        getDriver().quit();
    }

    @BeforeMethod
    public void beforeMethod() {
        // go to login page
        getDriver().get(environment.baseUrl());
        // init the elements
        loginOverlayWrapper = $(LoginOverlayWrapperElement.class).first();
    }

    @Test(enabled = true, description = "Check Login Page is Shown")
    public void loginPageIsShown() {
        assertThat(loginOverlayWrapper.getTitle()).as("Login Title").isEqualTo(LoginOverlayWrapperElement.TITLE);
    }

    @Test(enabled = false)
    public void loginValidUsernameValidPassword() {
        loginOverlayWrapper.setLoginUsername(login.adminUsername());
        loginOverlayWrapper.setLoginPassword(login.adminPassword());
    }
}
