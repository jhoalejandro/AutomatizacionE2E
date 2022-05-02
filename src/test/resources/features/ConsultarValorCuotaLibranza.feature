@ConsultarValorCuotaLibranza
Feature: Consultar cuota de libranza con o sin seguro de cuota protegida
  El cliente de la empresa con convenio con el Banco de Occidente desea consultar el valor de la cuota de un crédito de libranza para solicitar un préstamo

  Scenario Outline: El usuario accede a consultar la cuota de un crédito de libranza con seguro de cuota protegida para solicitar crédito
    Given el usuario ingresa al simulador de Libranza de Banco de Occidente
    When el consulta la cuota con seguro de cuota protegida con lo datos del credito <empresa>, <valor>, <plazo>
    Then el visualiza el valor de cuota esperado <valorCuota>
    Examples:
      | empresa              | valor    | plazo    | valorCuota |
      | POLICIA NACIONAL     | 50000000 | 24 Meses | $2.565.764 |
#      | POLICIA NACIONAL     | 60000000 | 36 Meses | $2.184.322 |
#      | E MC ALLISTER S.A.S. | 40000000 | 36 Meses | $1.458.140 |
#      | E MC ALLISTER S.A.S. | 80000000 | 48 Meses | $1.458.140 |