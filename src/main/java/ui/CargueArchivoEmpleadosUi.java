package ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("page:home.cargue.archivo")
public class CargueArchivoEmpleadosUi extends PageObject {

    public static final Target BOTON_CARGUE_ARCHIVO =
            Target.the("Choose file").located(By.id("file-upload"));

    public static final Target BOTON_UPLOAD =
            Target.the("Upload").located(By.id("file-submit"));

    public static final Target LABEL_ARCHIVO_CARGADO =
            Target.the("File Uploaded!").located(By.id("uploaded-files"));
}
