package question;

import commons.ArchivoUtils;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;


public class DescargaArchivoExigibilidadesQuestion implements Question<String> {

    public static DescargaArchivoExigibilidadesQuestion fue() {
        return new DescargaArchivoExigibilidadesQuestion();
    }

    @Override
    public String answeredBy(Actor actor) {
        if (actor.recall("nombreArchivo") == null || actor.recall("nombreArchivo").equals("")) {
            return "NO DESCARGO ARCHIVO";
        } else if (ArchivoUtils.existeArchivo(actor.recall("nombreArchivo"))) {
            return "EXITOSA";
        } else {
            return "NO EXISTE ARCHIVO";
        }
    }
}
