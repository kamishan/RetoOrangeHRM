package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import definitions.Hooks;
import pages.AgregarEmpleadoPage;
import pages.BuscarEmpleadoPage;
import pages.EditarEmpleadoPage;
import pages.EliminarEmpleadoPage;

public class EliminarEmpleadoSteps {

    AgregarEmpleadoPage agregarEmpleadoPage;
    EditarEmpleadoPage editarEmpleadoPage;
    BuscarEmpleadoPage buscarEmpleadoPage;
    EliminarEmpleadoPage eliminarEmpleadoPage;

    public EliminarEmpleadoSteps() {
        this.agregarEmpleadoPage = new AgregarEmpleadoPage();
        agregarEmpleadoPage.setDriver(Hooks.getDriver());

        this.editarEmpleadoPage = new EditarEmpleadoPage();
        editarEmpleadoPage.setDriver(Hooks.getDriver());

        this.buscarEmpleadoPage = new BuscarEmpleadoPage();
        buscarEmpleadoPage.setDriver(Hooks.getDriver());

        this.eliminarEmpleadoPage = new EliminarEmpleadoPage();
        eliminarEmpleadoPage.setDriver(Hooks.getDriver());
    }

    @When("busco empleados por nombre (.*)$")
    public void buscoEmpleadosPorNombre(String nombreBusqueda){
        agregarEmpleadoPage.clickPimMenu();
        editarEmpleadoPage.sendKeysInputEmployeeName(nombreBusqueda);
        editarEmpleadoPage.clickSearchButton();
    }

    @When("elimino al empleado")
    public void eliminoEmpleado(){
        eliminarEmpleadoPage.clickDeleteButton();
        eliminarEmpleadoPage.clickConfirmDeleteButton();

    }

    @Then("el empleado (.*) no aparece en la lista de empleados")
    public void elEmpleadoNoApareceEnListaDeEmpleados(String empleado) {
        editarEmpleadoPage.sendKeysInputEmployeeName(empleado);
        editarEmpleadoPage.clickSearchButton();
        String notFound = eliminarEmpleadoPage.getNoRecordFound();
        assert notFound.equals("No Records Found") : "El Empleado no ha sido eliminado correctamente.";
        System.out.println("La validación fue exitosa. El Empleado ha sido eliminado correctamente.");
    }
}
