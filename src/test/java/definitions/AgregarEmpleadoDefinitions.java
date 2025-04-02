package definitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import steps.AgregarEmpleadoSteps;

public class AgregarEmpleadoDefinitions {
    AgregarEmpleadoSteps agregarEmpleadoSteps;

    public AgregarEmpleadoDefinitions() {
        this.agregarEmpleadoSteps = new AgregarEmpleadoSteps();
    }

    @When("agrego un nuevo empleado con Nombre (.*), Apellido (.*), Email (.*) y Departamento (.*)$")
    public void AgregarEmpleado(String nombre, String apellido, String email, String departamento) {
        agregarEmpleadoSteps.agregoNuevoEmpleado(nombre, apellido, email, departamento);
    }

    @When("agrego un nuevo empleado con Nombre (.*), Apellido (.*)$")
    public void agregoNuevoEmpleadoVacio(String nombre, String apellido) {
        agregarEmpleadoSteps.agregoNuevoEmpleadoVacio(nombre, apellido);
    }

    @Then("^el empleado con Nombre (.*) y Apellido (.*) ha sido creado exitosamente$")
    public void empleadoCreadoExitosamente(String nombre, String apellido) {
        agregarEmpleadoSteps.empleadoCreadoExitosamente(nombre,apellido);
    }

    @Then("se muestran mensajes de error indicando que los campos son requeridos")
    public void muestraMensajeCampoRequerido() {
        agregarEmpleadoSteps.muestraMensajeCampoRequerido();
    }
}
