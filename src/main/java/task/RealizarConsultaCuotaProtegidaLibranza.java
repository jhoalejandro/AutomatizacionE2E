package task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import ui.SimulacionCuotaLibranzaUi;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RealizarConsultaCuotaProtegidaLibranza implements Task {
    String empresa;
    String valor;
    String plazo;

    public static RealizarConsultaCuotaProtegidaLibranza conLosDatos(String empresa, String valor, String plazo) {
        return instrumented(RealizarConsultaCuotaProtegidaLibranza.class, empresa, valor, plazo);
    }

    public RealizarConsultaCuotaProtegidaLibranza(String empresa, String valor, String plazo) {
        this.empresa = empresa;
        this.valor = valor;
        this.plazo = plazo;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(SimulacionCuotaLibranzaUi.NOMBRE_EMPRESA),
                Enter.theValue(this.empresa).into(SimulacionCuotaLibranzaUi.NOMBRE_EMPRESA),
                Click.on(SimulacionCuotaLibranzaUi.SELECT_NOMBRE_EMPRESA),
                Enter.theValue(this.valor.toString()).into(SimulacionCuotaLibranzaUi.VALOR_SOLICITADO),
                SelectFromOptions.byVisibleText(this.plazo)
                        .from(SimulacionCuotaLibranzaUi.PLAZO_MESES),
                Click.on(SimulacionCuotaLibranzaUi.INCLUSION_SEGURO)
        );

    }
}
