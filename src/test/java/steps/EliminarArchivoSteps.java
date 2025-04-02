package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import definitions.Hooks;
import pages.EliminarArchivoPage;
import pages.EliminarEmpleadoPage;

public class EliminarArchivoSteps {


    EliminarArchivoPage eliminarArchivoPage;
    EliminarEmpleadoPage eliminarEmpleadoPage;

    public EliminarArchivoSteps() {
        this.eliminarArchivoPage = new EliminarArchivoPage();
        eliminarArchivoPage.setDriver(Hooks.getDriver());

        this.eliminarEmpleadoPage = new EliminarEmpleadoPage();
        eliminarEmpleadoPage.setDriver(Hooks.getDriver());
    }

        @When("elimino el archivo cargado")
        public void eliminoArchivo () {
            eliminarArchivoPage.clickDeleteButton();
            eliminarEmpleadoPage.clickConfirmDeleteButton();
        }

        @Then("el archivo se ha eliminado exitosamente")
        public void archivoEliminadoExitosamente (){
            String notFound = eliminarEmpleadoPage.getNoRecordFound();
            assert notFound.equals("No Records Found") : "El Archivo no ha sido eliminado correctamente.";
            System.out.println("La validación fue exitosa. El Archivo ha sido eliminado correctamente.");
        }
    }