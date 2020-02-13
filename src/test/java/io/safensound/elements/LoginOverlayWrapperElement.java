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

    /**
     * returns the title label
     * 
     * @return H1Element
     */
    protected H1Element lblTitle() {
        return $(H1Element.class).first();
    }

    /**
     * returns the login username text box
     * 
     * @return TextFieldElement
     */
    protected TextFieldElement txtLoginUsername() {
        return $(TextFieldElement.class).id("vaadinLoginUsername");
    }

    /**
     * returns the login password text box
     * 
     * @return PasswordFieldElement
     */
    protected PasswordFieldElement txtLoginPassword() {
        return $(PasswordFieldElement.class).id("vaadinLoginPassword");
    }

    /**
     * returns the sign in button
     * 
     * @return ButtonElement
     */
    protected ButtonElement btnSignIn() {
        return $(ButtonElement.class).attribute("part", "vaadin-login-submit").first();
    }

    /**
     * returns the title text
     * 
     * @return String title text
     */
    @Step("Checking the Login Title text")
    public String getTitle() {
        return lblTitle().getText();
    }

    /**
     * set the value of the login username text box
     * 
     * @param username value to set in the login username text box
     */
    @Step("Setting the login username: {0}")
    public void setLoginUsername(String username) {
        txtLoginUsername().setValue(username);
    }

    /**
     * set the value of the login password text box
     * 
     * @param password value to set in the login password text box
     */
    @Step("Setting the login password: {0}")
    public void setLoginPassword(String password) {
        txtLoginPassword().setValue(password);
    }

    /**
     * click the sign in button
     */
    @Step("Clicking Sign In")
    public void clickSignIn() {
        btnSignIn().click();
    }
}
