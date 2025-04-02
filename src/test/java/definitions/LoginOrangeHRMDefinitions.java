package definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import steps.LoginOrangeHRMSteps;

import java.io.IOException;

public class LoginOrangeHRMDefinitions {

    LoginOrangeHRMSteps loginOrangeHRMSteps;

    public LoginOrangeHRMDefinitions() {
        this.loginOrangeHRMSteps = new LoginOrangeHRMSteps();
    }

    @Given("realizo login")
    public void realizoLoginCon() throws IOException {
        loginOrangeHRMSteps.enterPageLoginOrangeHRM();
        loginOrangeHRMSteps.completarLogin();
    }

}
