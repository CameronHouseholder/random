package io.safensound.elements;

import com.vaadin.flow.component.textfield.testbench.PasswordFieldElement;
import com.vaadin.flow.component.textfield.testbench.TextFieldElement;
import com.vaadin.flow.component.button.testbench.ButtonElement;
import com.vaadin.flow.component.html.testbench.H1Element;
import com.vaadin.testbench.TestBenchElement;
import com.vaadin.testbench.annotations.Attribute;
import com.vaadin.testbench.elementsbase.Element;

import io.qameta.allure.Step;

@Element("vaadin-login-overlay-wrapper")
@Attribute(name = "id", value = "vaadinLoginOverlayWrapper")
public class LoginOverlayWrapperElement extends TestBenchElement {

    // element locators
    protected H1Element lblTitle() {
        return $(H1Element.class).first();
    }

    protected TextFieldElement txtLoginUsername() {
        return $(TextFieldElement.class).id("vaadinLoginUsername");
    }

    protected PasswordFieldElement txtLoginPassword() {
        return $(PasswordFieldElement.class).id("vaadinLoginPassword");
    }

    protected ButtonElement btnSignIn() {
        return $(ButtonElement.class).attribute("part", "vaadin-login-submit").first();
    }

    // element actions
    @Step("Checking the Login Title text")
    public String getTitle() {
        return lblTitle().getText();
    }

    @Step("Setting the login username: {0}")
    public void setLoginUsername(String username) {
        txtLoginUsername().setValue(username);
    }

    @Step("Setting the login password: {0}")
    public void setLoginPassword(String password) {
        txtLoginPassword().setValue(password);
    }

    @Step("Clicking Sign In")
    public void clickSignIn() {
        btnSignIn().click();
    }
}
