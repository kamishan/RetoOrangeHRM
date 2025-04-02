package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;

public class EliminarEmpleadoPage extends WebBasePage{

    @FindBy(xpath = "//button[i[contains(@class, 'bi-trash')]]")
    private WebElement deleteButton;

    @FindBy(xpath = "//button[contains(@class, 'oxd-button') and .//i[contains(@class, 'oxd-icon bi-trash')]]")
    private WebElement confirmDeleteButton;

    @FindBy(xpath = "//span[text()='No Records Found']")
    private WebElement labelNoRecordFound;


    public void clickDeleteButton() {
        waitUntilElementIsPresent(deleteButton, 10);
        deleteButton.click();
        waitTime(5);
    }

    public void clickConfirmDeleteButton() {
        waitUntilElementIsPresent(confirmDeleteButton, 10);
        confirmDeleteButton.click();
        waitTime(5);
        getDriver().navigate().refresh();
    }

    public String getNoRecordFound() {
        waitUntilElementIsPresent(labelNoRecordFound, 10);
        return labelNoRecordFound.getText();
    }
}
