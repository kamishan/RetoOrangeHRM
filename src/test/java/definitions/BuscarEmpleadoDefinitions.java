package definitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import steps.BuscarEmpleadoSteps;

public class BuscarEmpleadoDefinitions {
    BuscarEmpleadoSteps buscarEmpleadoSteps;

    public BuscarEmpleadoDefinitions(){this.buscarEmpleadoSteps = new BuscarEmpleadoSteps();}

    @When("busco empleados por nombre (.*)$")
    public void buscoEmpleadosPorNombre(String nombreBusqueda){
       buscarEmpleadoSteps.buscoEmpleadosPorNombre(nombreBusqueda);
    }

    @Then("^se muestran resultados que incluyen a (.*)$")
    public void losDetallesDelEmpleadoMuestranElEmail(String nombreBusqueda) {
       buscarEmpleadoSteps.losDetallesDelEmpleadoMuestranElEmail(nombreBusqueda);
    }
}

