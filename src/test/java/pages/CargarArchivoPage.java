package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.nio.file.Paths;

public class CargarArchivoPage extends WebBasePage{

    @FindBy(xpath = "//a[@class='oxd-main-menu-item' and contains(., 'My Info')]")
    private WebElement myInfoMenu;

    @FindBy(xpath = "//button//i[@class='oxd-icon bi-plus oxd-button-icon']")
    private WebElement addButton;

    @FindBy(xpath = "//input[@type='file']")
    private WebElement browseButton;

    @FindBy(xpath = "(//button[@type='submit'])[3]")
    private WebElement saveButton;

    public void clickMyInfoMenu() {
        waitUntilElementIsPresent(myInfoMenu, 10);
        myInfoMenu.click();
    }

    public void clickAddButton() {
        waitUntilElementIsPresent(addButton, 10);
        addButton.click();
    }

    public void clickBrowseButton() {
        waitUntilElementIsPresent(browseButton, 10);
        browseButton.click();
    }

    public void subirArchivo() {
        String rutaCompleta = Paths.get("src/test/resources/archivos/documento.pdf")
                .toAbsolutePath().toString();

        // Ejecutar JavaScript para hacer visible el input si es necesario
        ((JavascriptExecutor) getDriver()).executeScript(
                "arguments[0].style.display = 'block';", browseButton
        );
        browseButton.sendKeys(rutaCompleta);
    }

    public void clickSaveButton() {
        waitTime(3);
        waitUntilElementIsPresent(saveButton, 10);
        saveButton.click();
        waitTime(2);
    }
}
