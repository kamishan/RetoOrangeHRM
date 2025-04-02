package steps;

import definitions.Hooks;
import pages.LoginOrangeHRMPage;
import java.io.IOException;
import static utils.WebUtils.readProperty;

public class LoginOrangeHRMSteps {

    LoginOrangeHRMPage loginOrangeHRMPage;

    public LoginOrangeHRMSteps() {
        this.loginOrangeHRMPage = new LoginOrangeHRMPage();
        loginOrangeHRMPage.setDriver(Hooks.getDriver());
    }
    public void enterPageLoginOrangeHRM() throws IOException {
        loginOrangeHRMPage.openPageOrangeHRM();
    }

    public void completarLogin() {
        loginOrangeHRMPage.sendKeysInputUsername(readProperty("config.properties", "USER"));
        loginOrangeHRMPage.sendKeysInputPassword(readProperty("config.properties", "PASS"));
        loginOrangeHRMPage.clickButtonEnviar();
    }
}
