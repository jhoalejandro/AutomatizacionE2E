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
import question.ValorCuotaLibranzaQuestion;
import task.RealizarConsultaCuotaProtegidaLibranza;
import ui.SimulacionCuotaLibranzaUi;


public class ConsultaCuotaLibranzaSteps {

    @Managed
    WebDriver driver;

    private static final Actor ACTOR = Actor.named("Alejandro");

    @Given("^el usuario ingresa al simulador de Libranza de Banco de Occidente$")
    public void ingresarSimuladorLibranza() {
        ACTOR.can(BrowseTheWeb.with(driver));
        ACTOR.wasAbleTo(Open.browserOn(new SimulacionCuotaLibranzaUi()));
    }

    @When("^el consulta la cuota con seguro de cuota protegida con lo datos del credito (.+), (.+), (.+)$")
    public void consultarCuotaProtegida(String empresa, String valor, String plazo) {
        ACTOR.attemptsTo(
                        RealizarConsultaCuotaProtegidaLibranza.conLosDatos(empresa, valor, plazo));
    }

    @Then("^el visualiza el valor de cuota esperado (.+)$")
    public void visualizarCuotaProtegida(String valorcuota) {
        String valorCuotaObtenido = ValorCuotaLibranzaQuestion.es().answeredBy(ACTOR);
        Serenity.recordReportData().withTitle("Valor Cuota Protegida").andContents(valorCuotaObtenido);
        ACTOR.attemptsTo(

                Ensure.that(valorCuotaObtenido)
                        .isEqualTo(valorcuota));
    }
}
