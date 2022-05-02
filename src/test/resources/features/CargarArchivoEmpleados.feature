@cargarArchivoEmpleados
Feature: Cargar archivo de empleados por convenio
  El cliente de la empresa con convenio con el Banco de Occidente desea cargar archivo de empleados que puede solicitar préstamo

  Scenario Outline: El usuario accede a cargar el archivo de empleados para permitir a los clientes para solicitar crédito
    Given el usuario ingresa al sitio para cargar empleados de Libranza de Banco de Occidente
    When el selecciona y carga el archivo con <nombre>
    Then el visualiza el nombre del archivo <nombre>
    Examples:
      | nombre        |
      | EmpresaConvenio123.txt |