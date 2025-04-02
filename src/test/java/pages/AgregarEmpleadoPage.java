package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AgregarEmpleadoPage extends WebBasePage {

    @FindBy(xpath = "//a[@class='oxd-main-menu-item' and contains(., 'PIM')]")
    private WebElement pimMenu;

    @FindBy(xpath = "//button[@type='button' and contains(@class, 'oxd-button')]")
    private WebElement addButton;

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement inputFirstName;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement inputLastName;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveButton;

    @FindBy(xpath = "//div[contains(@class, 'orangehrm-edit-employee-name')]")
    private WebElement labelEmployeeName;

    @FindBy(xpath = "//a[text()='Contact Details']")
    private WebElement contactDetailsButton;

    @FindBy(xpath = "(//input[contains(@class, 'oxd-input')])[10]")
    private WebElement inputEmail;

    @FindBy(xpath = "//a[text()='Job']")
    private WebElement jobButton;

    @FindBy(xpath = "(//div[@class='oxd-select-text-input' and text()='-- Select --'])[3]")
    private WebElement listDepartment;

    @FindBy(xpath = "(//span[text()='Required'])[1]")
    private WebElement labelRequired;



    public void clickPimMenu() {
        waitUntilElementIsPresent(pimMenu, 10);
        pimMenu.click();
    }

    public void clickAddButton() {
        waitUntilElementIsPresent(addButton, 10);
        addButton.click();
    }

    public void sendKeysInputFirstName(String firstname) {
        waitUntilElementIsPresent(inputFirstName,10);
        inputFirstName.clear();
        inputFirstName.sendKeys(firstname);
    }

    public void sendKeysInputLastName(String lastname) {
        waitUntilElementIsPresent(inputLastName,10);
        inputLastName.clear();
        inputLastName.sendKeys(lastname);
    }

    public void clickSaveButton() {
        waitTime(2);
        waitUntilElementIsPresent(saveButton, 10);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", saveButton);
        waitTime(5);
    }

    public String getEmployeeName() {
        waitUntilElementIsPresent(labelEmployeeName, 10);
        return labelEmployeeName.getText();
    }

    public void clickContactDetailsButton() {
        waitUntilElementIsPresent(contactDetailsButton, 10);
        contactDetailsButton.click();
    }

    public void clickJobButton() {
        waitUntilElementIsPresent(jobButton, 10);
        jobButton.click();
    }

    public void sendKeysInputEmail(String email) {
        waitUntilElementIsPresent(inputEmail,10);
        inputEmail.click();
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].value = '';", inputEmail);
        inputEmail.sendKeys(email);
    }

    public void clickListDepartment() {
        waitUntilElementIsPresent(listDepartment, 10);
        listDepartment.click();
    }

    public void sendKeysListDepartment(String departamento) {
        waitUntilElementIsPresent(listDepartment,10);
        listDepartment.sendKeys(departamento, Keys.ENTER);
    }

    public String getEmail() {
        waitUntilElementIsPresent(inputEmail, 10);
        return inputEmail.getAttribute("value");
    }

    public String getLabelRequired() {
        waitUntilElementIsPresent(labelRequired, 10);
        return labelRequired.getText();
    }
}


