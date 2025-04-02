package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import definitions.Hooks;
import pages.AgregarEmpleadoPage;
import pages.EditarEmpleadoPage;

public class EditarEmpleadoSteps {
    AgregarEmpleadoPage agregarEmpleadoPage;
    EditarEmpleadoPage editarEmpleadoPage;

    public EditarEmpleadoSteps() {
        this.agregarEmpleadoPage = new AgregarEmpleadoPage();
        agregarEmpleadoPage.setDriver(Hooks.getDriver());

        this.editarEmpleadoPage = new EditarEmpleadoPage();
        editarEmpleadoPage.setDriver(Hooks.getDriver());
    }

    @When("busco al empleado (.*) por nombre$")
    public void buscoEmpleadoPorNombre(String nombreEmpleado){
        agregarEmpleadoPage.clickPimMenu();
        editarEmpleadoPage.sendKeysInputEmployeeName(nombreEmpleado);
        editarEmpleadoPage.clickSearchButton();
    }

    @When("edito el email a (.*)$")
    public void editoEmail(String email){
        editarEmpleadoPage.clickEditButton();
        agregarEmpleadoPage.clickContactDetailsButton();
        agregarEmpleadoPage.sendKeysInputEmail(email);
        agregarEmpleadoPage.clickSaveButton();
    }

    @Then("^los detalles del empleado muestran el email (.*)$")
    public void losDetallesDelEmpleadoMuestranElEmail(String email) {
        String nuevoEmail = agregarEmpleadoPage.getEmail();
        assert nuevoEmail.equals(email) : "El Email no ha sido editado correctamente.";
        System.out.println("La validación fue exitosa. El Email ha sido editado correctamente.");
    }

}
