@descargarArchivosExigibilidades
Feature: Descargar archivo de exigibilidades por convenio
  El cliente de la empresa con convenio con el Banco de Occidente desea descargar archivo de exigibilidades para relacionar pago a Banco

  Scenario: El usuario accede a descargar el archivo de exigibilidades para visualizar el detalle del pago a realizar
    Given el usuario ingresa al sitio para descargar el archivo de exigibilidades de Libranza de Banco de Occidente
    When el selecciona y descarga el archivo de exigibilidades
    Then el visualiza que el archivo descargo de manera exitosa en la carpeta de descargas