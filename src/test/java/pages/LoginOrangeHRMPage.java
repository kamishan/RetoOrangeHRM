package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginOrangeHRMPage extends WebBasePage {

    @FindBy(xpath = "//input[@name='username']")
    private WebElement inputUsername;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonLogin;

    public void sendKeysInputUsername(String username) {
        waitUntilElementIsPresent(inputUsername,10);
        inputUsername.clear();
        inputUsername.sendKeys(username);
    }

    public void sendKeysInputPassword(String password) {
        waitUntilElementIsPresent(inputPassword,10);
        inputPassword.clear();
        inputPassword.sendKeys(password);
    }
    public void clickButtonEnviar() {
        waitUntilElementIsPresent(buttonLogin,10);
        buttonLogin.click();
    }
}
