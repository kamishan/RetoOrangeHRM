package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;

public class EliminarArchivoPage extends WebBasePage{

    @FindBy(xpath = "//button[contains(.//i/@class, 'bi-trash')]")
    private WebElement deleteButton;

    public void clickDeleteButton() {
        waitUntilElementIsPresent(deleteButton, 10);
        deleteButton.click();
        waitTime(5);
    }
}
