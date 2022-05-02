package ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("page:home.page")
public class SimulacionCuotaLibranzaUi extends PageObject {

    public static final Target NOMBRE_EMPRESA =
            Target.the("Nombre de Empresa").located(By.id("nombreEmpresaSimulador"));

    public static final Target SELECT_NOMBRE_EMPRESA =
            Target.the("Seleccion de Empresa").located(By.cssSelector("a[class='ng-binding']"));

    public static final Target VALOR_SOLICITADO =
            Target.the("Valor Solicitado").located(By.name("valorSolicitado"));

    public static final Target PLAZO_MESES =
            Target.the("Plazo en Meses").located(By.name("plazo"));

    public static final Target INCLUSION_SEGURO =
            Target.the("Incluir Seguro Cuota Protegida").located(By.cssSelector("label[for='cmn-toggle-1']"));

    public static final Target VALOR_CUOTA =
            Target.the("Valor Cuota Préstamo").located(By.cssSelector("b[class='ng-binding']"));
}
