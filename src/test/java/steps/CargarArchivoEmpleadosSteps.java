package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import question.EtiquetaCargueArchivoEmpresaQuestion;
import task.CargarArchivoEmpleadosTask;
import task.RealizarConsultaCuotaProtegidaLibranza;
import ui.CargueArchivoEmpleadosUi;
import ui.SimulacionCuotaLibranzaUi;

public class CargarArchivoEmpleadosSteps {

    @Managed
    WebDriver driver;

    private static final Actor ACTOR = Actor.named("Empresa");

    @Given("^el usuario ingresa al sitio para cargar empleados de Libranza de Banco de Occidente$")
    public void abrirCargueArchivosEmpleados() {
        ACTOR.can(BrowseTheWeb.with(driver));
        ACTOR.wasAbleTo(Open.browserOn(new CargueArchivoEmpleadosUi()));

    }


    @When("^el selecciona y carga el archivo con (.+)$")
    public void seleccionarArchivoEmpleados(String nombre) {
        Serenity.recordReportData().withTitle("Archivo Selecionado").andContents(nombre);
        ACTOR.attemptsTo(
                CargarArchivoEmpleadosTask.conElNombre(nombre));

    }

    @Then("^el visualiza el nombre del archivo (.+)$")
    public void validarNombreArchivoEmpleados(String nombre) {
        Serenity.recordReportData().withTitle("Archivo Cargado").andContents(nombre);
        ACTOR.attemptsTo(Ensure.that(EtiquetaCargueArchivoEmpresaQuestion.es().answeredBy(ACTOR))
                .isEqualTo(nombre));

    }

}
