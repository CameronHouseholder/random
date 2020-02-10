package io.safensound.elements;

import com.vaadin.flow.component.textfield.testbench.PasswordFieldElement;
import com.vaadin.flow.component.textfield.testbench.TextFieldElement;
import com.vaadin.flow.component.html.testbench.H1Element;
import com.vaadin.testbench.TestBenchElement;
import com.vaadin.testbench.annotations.Attribute;
import com.vaadin.testbench.elementsbase.Element;

@Element("vaadin-login-overlay-wrapper")
@Attribute(name = "id", value = "vaadinLoginOverlayWrapper")
public class LoginOverlayWrapperElement extends TestBenchElement {

    // element constants
    public static final String TITLE = "Bakery";

    // element locators
    protected TextFieldElement txtLoginUsername() {
        return $(TextFieldElement.class).id("vaadinLoginUsername");
    }

    protected PasswordFieldElement txtLoginPassword() {
        return $(PasswordFieldElement.class).id("vaadinLoginPassword");
    }

    protected H1Element lblTitle() {
        return $(H1Element.class).first();
    }

    // element actions
    public void setLoginUsername(String username) {
        txtLoginUsername().setValue(username);
    }

    public void setLoginPassword(String password) {
        txtLoginPassword().setValue(password);
    }

    public String getTitle() {
        return lblTitle().getText();
    }
}
