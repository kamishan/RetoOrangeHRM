package definitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import steps.BuscarEmpleadoSteps;
import steps.EliminarEmpleadoSteps;

public class EliminarEmpleadoDefinitions {

    EliminarEmpleadoSteps eliminarEmpleadoSteps;
    BuscarEmpleadoSteps buscarEmpleadoSteps;

    public EliminarEmpleadoDefinitions() {
        this.eliminarEmpleadoSteps = new EliminarEmpleadoSteps();
        this.buscarEmpleadoSteps = new BuscarEmpleadoSteps();
    }

    @When("elimino al empleado")
    public void eliminoEmpleado() {
        eliminarEmpleadoSteps.eliminoEmpleado();
    }

    @Then("el empleado (.*) no aparece en la lista de empleados")
    public void elEmpleadoNoApareceEnListaDeEmpleados(String nombreEmpleado) {
        eliminarEmpleadoSteps.elEmpleadoNoApareceEnListaDeEmpleados(nombreEmpleado);
    }
}
