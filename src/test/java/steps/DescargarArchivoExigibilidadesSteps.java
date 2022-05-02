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
import question.DescargaArchivoExigibilidadesQuestion;
import task.DescargarArchivoExigibilidadesTask;
import ui.DescargarArchivoExigibilidadesUi;

public class DescargarArchivoExigibilidadesSteps {

    @Managed
    WebDriver driver;

    private static final Actor ACTOR = Actor.named("Empresa");

    @Given("^el usuario ingresa al sitio para descargar el archivo de exigibilidades de Libranza de Banco de Occidente$")
    public void abrirDescargaArchivoExigibilidades() {
        ACTOR.can(BrowseTheWeb.with(driver));
        ACTOR.wasAbleTo(Open.browserOn(new DescargarArchivoExigibilidadesUi()));

    }


    @When("^el selecciona y descarga el archivo de exigibilidades$")
    public void seleccionarArchivoExigibilidades() {
        ACTOR.attemptsTo(
                DescargarArchivoExigibilidadesTask.delConvenio());

    }

    @Then("^el visualiza que el archivo descargo de manera exitosa en la carpeta de descargas$")
    public void validarDescargaArchivoExigibilidades() {
        ACTOR.attemptsTo(Ensure.that(DescargaArchivoExigibilidadesQuestion.fue().answeredBy(ACTOR))
                .isEqualTo("EXITOSA"));

    }

}
