@gestionEmpleados
Feature: Yo como automatizador,
  requiero automatizar las pruebas de gestión de empleados en OrangeHRM,
  para validar su funcionalidad y obtener el código de finalización de la prueba

  @agregarEmpleados
  Scenario Outline: Agregar un nuevo empleado con datos válidos
    Given realizo login
    When agrego un nuevo empleado con Nombre <Nombre>, Apellido <Apellido>, Email <Email> y Departamento <Departamento>
    Then el empleado con Nombre <Nombre> y Apellido <Apellido> ha sido creado exitosamente

    Examples:
      | Nombre | Apellido | Email           | Departamento      |
      | Ana    | Pérez    | ana@example.com | Quality Assurance |

  @agregarEmpleadoVacio
  Scenario Outline: Intentar agregar un empleado con campos requeridos vacíos
    Given realizo login
    When agrego un nuevo empleado con Nombre <Nombre>, Apellido <Apellido>
    Then se muestran mensajes de error indicando que los campos son requeridos

    Examples:
      | Nombre | Apellido |
      |        |          |

  @editarEmpleados
  Scenario Outline: Editar un empleado existente y validar cambios
    Given realizo login
    When busco al empleado <NombreExistente> por nombre
    And edito el email a <NuevoEmail>
    Then los detalles del empleado muestran el email <NuevoEmail>

    Examples:
      | NombreExistente | NuevoEmail            |
      | Ana Pérez       | ana.nueva@example.com |

  @buscarEmpleados
  Scenario Outline: Buscar un empleado por nombre
    Given realizo login
    When busco empleados por nombre <Busqueda>
    Then se muestran resultados que incluyen a <Busqueda>

    Examples:
      | Busqueda  |
      | Ana Pérez |

  @eliminarEmpleados
  Scenario Outline: Eliminar un empleado y validar su ausencia
    Given realizo login
    When busco al empleado <Empleado> por nombre
    And elimino al empleado
    Then el empleado <Empleado> no aparece en la lista de empleados

    Examples:
      | Empleado  |
      | Ana Pérez |

  @cargarArchivo
  Scenario: Cargar un archivo en "My Info" > "Contact Details"
    Given realizo login
    When navego a My Info > Contact Details
    And subo el archivo documento.pdf
    Then el archivo se ha cargado exitosamente

  @eliminarArchivo
  Scenario: Eliminar un archivo en "My Info" > "Contact Details"
    Given realizo login
    When navego a My Info > Contact Details
    And elimino el archivo cargado
    Then el archivo se ha eliminado exitosamente