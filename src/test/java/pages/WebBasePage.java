package pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import definitions.Hooks;
import utils.WebUtils;

import java.io.IOException;

import static utils.WebUtils.readProperty;

public class WebBasePage extends PageObject {

    WebUtils webUtils;
    public WebBasePage(){
        this.webUtils = new WebUtils();
    }

    public void openPageOrangeHRM() throws IOException {
        Hooks.getDriver().get(readProperty("config.properties", "ORANGE_HRM_URL"));
    }

        boolean waitUntilElementIsPresent(WebElement element, int time){
        try{
            new WebDriverWait(Hooks.getDriver(),time).until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public WebElement getElement(String xpath, String option){
        return element(By.xpath(xpath.replace("Replaceable",option)));
    }

   /* public void scrollElement(WebElement element){
        ((JavascriptExecutor) Hooks.getDriver()).executeScript("arguments[0].scrollIntoView(true);",element);
    }*/

    public void waitTime(int time){
        try {
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
