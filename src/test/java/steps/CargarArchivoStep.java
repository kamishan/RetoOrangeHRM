package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import definitions.Hooks;
import pages.CargarArchivoPage;


public class CargarArchivoStep {

    CargarArchivoPage cargarArchivoPage;

    public CargarArchivoStep() {
        this.cargarArchivoPage = new CargarArchivoPage();
        cargarArchivoPage.setDriver(Hooks.getDriver());
    }

    @When("navego a My Info > Contact Details")
    public void navegoALaRuta(){
        cargarArchivoPage.clickMyInfoMenu();
        cargarArchivoPage.clickAddButton();
        cargarArchivoPage.clickBrowseButton();
    }

    @When("subo el archivo documento.pdf")
    public void suboArchivo(){
        cargarArchivoPage.subirArchivo();
        cargarArchivoPage.clickSaveButton();
    }

    @Then("el archivo se ha cargado exitosamente")
    public void archivoCargadoExitosamente() {
    }

}
