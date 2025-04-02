package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import definitions.Hooks;
import pages.AgregarEmpleadoPage;


public class AgregarEmpleadoSteps {

    AgregarEmpleadoPage agregarEmpleadoPage;

    public AgregarEmpleadoSteps() {
        this.agregarEmpleadoPage = new AgregarEmpleadoPage();
        agregarEmpleadoPage.setDriver(Hooks.getDriver());
    }

    @When("agrego un nuevo empleado con Nombre (.*), Apellido (.*), Email (.*) y Departamento (.*)$")
    public void agregoNuevoEmpleado(String nombre, String apellido, String email, String departamento) {
        agregarEmpleadoPage.clickPimMenu();
        agregarEmpleadoPage.clickAddButton();
        agregarEmpleadoPage.sendKeysInputFirstName(nombre);
        agregarEmpleadoPage.sendKeysInputLastName(apellido);
        agregarEmpleadoPage.clickSaveButton();
        agregarEmpleadoPage.clickContactDetailsButton();
        agregarEmpleadoPage.sendKeysInputEmail(email);
        agregarEmpleadoPage.clickSaveButton();
        agregarEmpleadoPage.clickJobButton();
        agregarEmpleadoPage.clickListDepartment();
        agregarEmpleadoPage.sendKeysListDepartment(String.valueOf(departamento.charAt(0)).toLowerCase());
        agregarEmpleadoPage.clickSaveButton();
    }

    @Then("^el empleado con Nombre (.*), Apellido (.*) ha sido creado exitosamente$")
    public void empleadoCreadoExitosamente(String nombre, String apellido) {
        String employeeName = agregarEmpleadoPage.getEmployeeName();
        assert employeeName.equals(nombre + " " + apellido) : "El empleado no ha sido creado correctamente.";
        System.out.println("La validación fue exitosa. El empleado ha sido creado correctamente.");
    }

    @When("agrego un nuevo empleado con Nombre (.*), Apellido (.*)$")
    public void agregoNuevoEmpleadoVacio(String nombre, String apellido) {
        agregarEmpleadoPage.clickPimMenu();
        agregarEmpleadoPage.clickAddButton();
        agregarEmpleadoPage.sendKeysInputFirstName(nombre);
        agregarEmpleadoPage.sendKeysInputLastName(apellido);
        agregarEmpleadoPage.clickSaveButton();
    }


    @Then("se muestran mensajes de error indicando que los campos son requeridos")
    public void muestraMensajeCampoRequerido() {
        String requerido = agregarEmpleadoPage.getLabelRequired();
        assert requerido.equals("Required") : "Error el sistema no debe permitir guardar usuarios con campos requeridos vacíos.";
        System.out.println("La validación fue exitosa. No es posible crear un Empleado sin los campos son requeridos.");
    }
}

