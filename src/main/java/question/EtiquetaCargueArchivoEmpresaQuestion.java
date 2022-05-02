package question;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import ui.CargueArchivoEmpleadosUi;

public class EtiquetaCargueArchivoEmpresaQuestion implements Question<String> {

    public static EtiquetaCargueArchivoEmpresaQuestion es(){
        return new EtiquetaCargueArchivoEmpresaQuestion();
    }
    @Override
    public String answeredBy(Actor actor) {
        return Text.of(CargueArchivoEmpleadosUi.LABEL_ARCHIVO_CARGADO).viewedBy(actor).asString();
    }
}
