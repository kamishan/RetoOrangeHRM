package definitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Hooks {
    static WebDriver driver;

    @Before
    public void setupBrowser(Scenario scenario) {
        String browser = System.getProperty("browser", "chrome"); // Por defecto, Chrome
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Navegador no soportado: " + browser);
        }
        driver.manage().window().maximize();
        System.out.println("Iniciando navegador: " + browser + " para el escenario: " + scenario.getName());
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }

    static public WebDriver getDriver(){
        return driver;
    }
}
