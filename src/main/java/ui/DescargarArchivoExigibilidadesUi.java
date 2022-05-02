package ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("page:home.descargue.archivo")
public class DescargarArchivoExigibilidadesUi extends PageObject {

    public static final Target ENLACE_DESCARGUE_ARCHIVO =
            Target.the("Choose file").located(By.cssSelector("#content > div > a:nth-child(2)"));

    public static final Target ENLACE_DESCARGUE_ARCHIVO_ROTO =
            Target.the("Choose file").located(By.cssSelector("#content > div > a:nth-child(2400)"));

}
