# Automatización de Pruebas para la Gestión de Empleados en OrangeHRM

## Descripción del Proyecto

Este proyecto tiene como objetivo automatizar las pruebas funcionales de la aplicación web de gestión de empleados OrangeHRM. Se han desarrollado pruebas automatizadas para validar las funcionalidades clave relacionadas con la gestión de empleados, como agregar, editar, buscar, eliminar empleados y cargar/eliminar archivos.

## Problema Abordado

La empresa utiliza OrangeHRM para la gestión de sus empleados. Para asegurar la calidad y el correcto funcionamiento de la aplicación, se requiere la automatización de las pruebas más importantes. Esto permite reducir el tiempo y el esfuerzo dedicado a las pruebas manuales, además de garantizar una cobertura de pruebas consistente y exhaustiva.

## Funcionalidades Automatizadas

Se han automatizado las siguientes funcionalidades de la aplicación:

* **Agregar Empleado:** Creación de nuevos empleados con datos válidos.
* **Editar Empleado:** Modificación de la información de empleados existentes.
* **Buscar Empleado:** Búsqueda de empleados por nombre.
* **Eliminar Empleado:** Eliminación de empleados del sistema.
* **Cargar Archivo:** Subida de archivos en la sección "My Info" > "Contact Details".
* **Eliminar Archivo:** Eliminación de archivos cargados en la sección "My Info" > "Contact Details".

## Escenarios de Prueba Automatizados

A continuación, se describen los escenarios de prueba automatizados, basados en la especificación Gherkin proporcionada:

* **Agregar un nuevo empleado con datos válidos:**
    * Se verifica que un nuevo empleado puede ser agregado al sistema con información completa (nombre, apellido, email y departamento).
    * Se valida que el empleado se crea exitosamente.
* **Intentar agregar un empleado con campos requeridos vacíos:**
    * Se verifica que el sistema muestra mensajes de error cuando se intenta agregar un empleado sin completar los campos obligatorios.
* **Editar un empleado existente y validar cambios:**
    * Se busca un empleado existente por su nombre.
    * Se modifica su email.
    * Se valida que los detalles del empleado se actualizan correctamente con el nuevo email.
* **Buscar un empleado por nombre:**
    * Se busca un empleado utilizando su nombre como criterio de búsqueda.
    * Se verifica que los resultados de la búsqueda incluyen al empleado buscado.
* **Eliminar un empleado y validar su ausencia:**
    * Se busca un empleado por su nombre.
    * Se elimina al empleado.
    * Se valida que el empleado ya no aparece en la lista de empleados.
* **Cargar un archivo en "My Info" > "Contact Details":**
    * Se navega a la sección "My Info" > "Contact Details".
    * Se sube un archivo (ej. documento.pdf).
    * Se verifica que el archivo se ha cargado exitosamente y aparece en la tabla.
* **Eliminar un archivo en "My Info" > "Contact Details":**
    * Se navega a la sección "My Info" > "Contact Details".
    * Se elimina el archivo previamente cargado.
    * Se verifica que el archivo se ha eliminado exitosamente.

## Requisitos Adicionales Implementados

* **Pruebas en múltiples navegadores:** Las pruebas están diseñadas para ejecutarse en al menos dos navegadores diferentes: Chrome y Firefox. Esto asegura la compatibilidad y el correcto funcionamiento de la aplicación en diferentes entornos de navegación.
* **Validaciones avanzadas:** Se han implementado validaciones para verificar que los campos editados se actualizan correctamente en la base de datos o en la interfaz de usuario.
* **Manejo de escenarios de error:** Se han considerado escenarios de error, como intentar agregar empleados con datos inválidos o campos requeridos incompletos, validando que el sistema responde de manera adecuada (por ejemplo, mostrando mensajes de error).

## Especificación de Pruebas (Feature File)

A continuación, se incluye el archivo de especificación de pruebas en formato Gherkin utilizado para la automatización:

```gherkin
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
      | Nombre | Apellido | Email                 | Departamento      |
      | Ana    | Pérez    | ana@example.com       | Quality Assurance |

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
      | NombreExistente | NuevoEmail              |
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
```
## Tecnologías Utilizadas (Ejemplo)

Aunque no se especificaron las tecnologías, comúnmente para este tipo de automatización se utilizan herramientas como:

* **Selenium WebDriver:** Para la interacción con el navegador web.
* **[Framework de pruebas - SerenityBDD, Cucumber, Behave, POM]:** Para la estructura y ejecución de las pruebas.
* **[Lenguaje de programación - Java]:** Para escribir el código de automatización.
* **[Gestor de dependencias - Maven (Java)]:** Para gestionar las librerías necesarias.
* **Drivers de navegador (ChromeDriver, GeckoDriver):** Para la comunicación entre Selenium y los navegadores.

**Nota:** Reemplace los ejemplos entre corchetes con las tecnologías específicas utilizadas en este proyecto.

## Próximos Pasos

* Integrar estas pruebas en un sistema de integración continua (CI/CD) para su ejecución automática en cada cambio de código.
* Ampliar la cobertura de pruebas para incluir otras funcionalidades de la aplicación.
* Generar informes de pruebas detallados.
* Implementar pruebas de rendimiento y seguridad.
