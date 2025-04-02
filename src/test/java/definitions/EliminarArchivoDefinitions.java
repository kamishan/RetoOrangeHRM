package definitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import steps.EliminarArchivoSteps;
import steps.EliminarEmpleadoSteps;

public class EliminarArchivoDefinitions {

    EliminarArchivoSteps eliminarArchivoSteps;

    public EliminarArchivoDefinitions() {
        this.eliminarArchivoSteps = new EliminarArchivoSteps();
    }

    @When("elimino el archivo cargado")
    public void eliminoArchivo () {
       eliminarArchivoSteps.eliminoArchivo();
    }

    @Then("el archivo se ha eliminado exitosamente")
    public void archivoEliminadoExitosamente (){
      eliminarArchivoSteps.archivoEliminadoExitosamente();
    }

}
