package definitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import steps.CargarArchivoStep;

public class CargarAchivoDefinitions {

    CargarArchivoStep cargarArchivoStep;

    public CargarAchivoDefinitions() {
        this.cargarArchivoStep = new CargarArchivoStep();
    }

    @When("navego a My Info > Contact Details")
    public void navegoALaRuta(){
        cargarArchivoStep.navegoALaRuta();
    }

    @When("subo el archivo documento.pdf")
    public void suboArchivo(){
        cargarArchivoStep.suboArchivo();
    }

    @Then("el archivo se ha cargado exitosamente")
    public void archivoCargadoExitosamente() {

    }
}
