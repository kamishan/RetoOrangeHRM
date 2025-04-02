package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BuscarEmpleadoPage extends WebBasePage{

    @FindBy(xpath = "//div[@class='oxd-table-cell oxd-padding-cell']//div[text()='Ana ']")
    private WebElement labelFirstName;

    @FindBy(xpath = "//div[@class='oxd-table-cell oxd-padding-cell']//div[text()='Pérez']")
    private WebElement labelLastName;

    public String getFirstName() {
        waitUntilElementIsPresent(labelFirstName, 10);
        return labelFirstName.getText();
    }

    public String getLastName() {
        waitUntilElementIsPresent(labelLastName, 10);
        return labelLastName.getText();
    }

}
