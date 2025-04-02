package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditarEmpleadoPage extends WebBasePage {

    @FindBy(xpath = "(//input[@placeholder='Type for hints...'])[1]")
    private WebElement inputEmployeeName;

    @FindBy(xpath = "//button[text()=' Search ']")
    private WebElement searchButton;

    @FindBy(xpath = "//button[i[contains(@class, 'bi-pencil-fill')]]")
    private WebElement editButton;

    public void sendKeysInputEmployeeName(String employeeName) {
        waitUntilElementIsPresent(inputEmployeeName,10);
        inputEmployeeName.click();
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].value = '';", employeeName);
        inputEmployeeName.sendKeys(employeeName);
    }

    public void clickSearchButton() {
        waitUntilElementIsPresent(searchButton, 10);
        searchButton.click();
        waitTime(5);
    }

    public void clickEditButton() {
        waitUntilElementIsPresent(editButton, 10);
        editButton.click();
    }

}
