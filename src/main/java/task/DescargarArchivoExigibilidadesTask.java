package task;

import commons.ArchivoUtils;
import exceptions.CustomException;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import ui.DescargarArchivoExigibilidadesUi;

import java.net.HttpURLConnection;
import java.net.URL;


import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DescargarArchivoExigibilidadesTask implements Task {

    private static final String RUTA_DESTINO_DESCARGAS = "C:\\descargasAlejo2\\";

    public static DescargarArchivoExigibilidadesTask delConvenio() {
        return instrumented(DescargarArchivoExigibilidadesTask.class);

    }

    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T actor) {

        //resetear variable de actor
        actor.remember("nombreArchivo", "");

        //Validar datos del archivo a descargar el cual esta ubicado como un link en una página.
        String url = DescargarArchivoExigibilidadesUi.ENLACE_DESCARGUE_ARCHIVO.resolveFor(actor).getWrappedElement().getAttribute("href");
        HttpURLConnection httpURLConnection = (HttpURLConnection) (new URL(url).openConnection());
        httpURLConnection.setRequestMethod("HEAD");
        httpURLConnection.connect();
        //Propiedades del archivo
        int contentLength = httpURLConnection.getContentLength();

        //obtener nombre del archivo
        String[] urlSplit = url.split("/");
        String nombreArchivo = urlSplit[urlSplit.length - 1];
        String rutaArchivoDescargasUsuario=null;
        String rutaArchivoDescargasDestinoUsuario= null;
        if(!nombreArchivo.isEmpty())
        {
            //eliminar archivo existente en las dos rutas
            rutaArchivoDescargasUsuario = System.getProperty("user.home") + "\\" + nombreArchivo;
            rutaArchivoDescargasDestinoUsuario = RUTA_DESTINO_DESCARGAS + nombreArchivo;
            ArchivoUtils.eliminarArchivo(rutaArchivoDescargasUsuario);
            ArchivoUtils.eliminarArchivo(rutaArchivoDescargasDestinoUsuario);
        }
        //si el archivo es mayor a cero darle clic para descargar
        if (contentLength > 0) {
            actor.attemptsTo(
                    Click.on(DescargarArchivoExigibilidadesUi.ENLACE_DESCARGUE_ARCHIVO));
            Thread.sleep(5000);
            //Mover archivo a carpeta definitiva
            ArchivoUtils.moverArchivo(rutaArchivoDescargasUsuario, rutaArchivoDescargasDestinoUsuario);
            actor.remember("nombreArchivo", ArchivoUtils.obtenerPathArchivo(rutaArchivoDescargasDestinoUsuario));
        } else {
            //throw new CustomException("Archivo ubicado en "+url+" con tamaño 0");
        }

    }
}
