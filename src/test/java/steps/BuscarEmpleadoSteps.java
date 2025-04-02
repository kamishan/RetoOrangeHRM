package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import definitions.Hooks;
import pages.AgregarEmpleadoPage;
import pages.BuscarEmpleadoPage;
import pages.EditarEmpleadoPage;

public class BuscarEmpleadoSteps {

    AgregarEmpleadoPage agregarEmpleadoPage;
    EditarEmpleadoPage editarEmpleadoPage;
    BuscarEmpleadoPage buscarEmpleadoPage;

    public BuscarEmpleadoSteps() {
        this.agregarEmpleadoPage = new AgregarEmpleadoPage();
        agregarEmpleadoPage.setDriver(Hooks.getDriver());

        this.editarEmpleadoPage = new EditarEmpleadoPage();
        editarEmpleadoPage.setDriver(Hooks.getDriver());

        this.buscarEmpleadoPage = new BuscarEmpleadoPage();
        buscarEmpleadoPage.setDriver(Hooks.getDriver());
    }

    @When("busco empleados por nombre (.*)$")
    public void buscoEmpleadosPorNombre(String nombreBusqueda){
        agregarEmpleadoPage.clickPimMenu();
        editarEmpleadoPage.sendKeysInputEmployeeName(nombreBusqueda);
        editarEmpleadoPage.clickSearchButton();
    }

    @Then("^se muestran resultados que incluyen a (.*)$")
    public void losDetallesDelEmpleadoMuestranElEmail(String nombreBusqueda) {
        String nombreEncontrado = buscarEmpleadoPage.getFirstName() + " " + buscarEmpleadoPage.getLastName();
        assert nombreEncontrado.equals(nombreBusqueda) : "La busqueda no ha sido realizada correctamente.";
        System.out.println("La validación fue exitosa. La busqueda ha sido realizada correctamente.");
    }

}
