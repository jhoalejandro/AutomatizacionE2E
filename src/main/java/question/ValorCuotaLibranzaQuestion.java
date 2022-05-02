package question;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import ui.SimulacionCuotaLibranzaUi;


public class ValorCuotaLibranzaQuestion implements Question<String> {

    public static Question<String> es() {
        return new ValorCuotaLibranzaQuestion();
    }


    @Override
    public String answeredBy(Actor actor) {
        return Text.of(SimulacionCuotaLibranzaUi.VALOR_CUOTA)
                .viewedBy(actor)
                .asString();

    }
}
