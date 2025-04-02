package definitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import steps.EditarEmpleadoSteps;

public class EditarEmpleadoDefinitions {

    EditarEmpleadoSteps editarEmpleadoSteps;

    public EditarEmpleadoDefinitions(){this.editarEmpleadoSteps = new EditarEmpleadoSteps();}

    @When("busco al empleado (.*) por nombre$")
    public void buscoEmpleadoPorNombre(String nombreEmpleado){
        editarEmpleadoSteps.buscoEmpleadoPorNombre(nombreEmpleado);

    }

    @When("edito el email a (.*)$")
    public void editoEmail(String email){
        editarEmpleadoSteps.editoEmail(email);
    }

    @Then("^los detalles del empleado muestran el email (.*)$")
    public void losDetallesDelEmpleadoMuestranElEmail(String email) {
        editarEmpleadoSteps.losDetallesDelEmpleadoMuestranElEmail(email);
    }
}
