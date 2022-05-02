package task;

import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Upload;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.CargueArchivoEmpleadosUi;
import java.nio.file.Path;
import java.nio.file.Paths;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CargarArchivoEmpleadosTask implements Task {


    private final String nombre;

    public static CargarArchivoEmpleadosTask conElNombre(String nombre) {
        return instrumented(CargarArchivoEmpleadosTask.class, nombre);

    }

    public CargarArchivoEmpleadosTask(String nombre) {
        this.nombre = nombre;
    }

    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T actor) {
/* con clase Robot
        try {
            //https://www.techlistic.com/2019/06/upload-file-using-selenium-webdriver.html
            Robot robot = new Robot();

            //Mover mouse a la ubicacion establecida
            robot.mouseMove(621, 255);

            //Dar clic izquierdo
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            //Soltar clic izquierdo
            robot.mouseRelease((InputEvent.BUTTON1_DOWN_MASK));

            //Mouse moverse donde esta el archivo
            //robot.mouseMove(700, 285);

            //Espera para que se abra la ventana de cargue de archivo de windows
            Thread.currentThread().sleep(5000);

            //Ruta donde esta el archivo
            String path = System.getProperty("user.dir");
            String localizacionArchivo = path + "\\src\\test\\resources\\archivos\\" + nombre;
            StringSelection ubicacionArchivo = new StringSelection(localizacionArchivo);

            //Tomar la ruta del archivo y colocarla en el portapapeles
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ubicacionArchivo, null);

            //pegar la ruta en el campo de selección de archivo y dar aceptar ventana
            robot.keyPress(KeyEvent.VK_CONTROL);
            // Press Ctrl + V key - It will paste the file path in windows dialog
            robot.keyPress(KeyEvent.VK_V);

            // Now release V + Ctrl key
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            // Click Enter Key
            robot.keyPress(KeyEvent.VK_ENTER);

            // Release Enter Key
            robot.keyRelease(KeyEvent.VK_ENTER);

            //Cargar archivo en la página
            actor.attemptsTo(Click.on(CargueArchivoEmpleadosUi.BOTON_UPLOAD));

            Serenity.recordReportData().withTitle("Ubicacion Archivo").andContents(localizacionArchivo);

        } catch (AWTException | InterruptedException e) {
            e.printStackTrace();
        }
        */
        //Ruta donde esta el archivo
        String path = System.getProperty("user.dir");
        String rutaArchivo = path + "\\src\\test\\resources\\archivos\\" + nombre;
        //obtener elemento WebElement desde Target
        WebElement subirArchivo = CargueArchivoEmpleadosUi.BOTON_CARGUE_ARCHIVO.resolveFor(actor).getWrappedElement();
        //obtener elemento By desde WebElement
        String[] data = subirArchivo.toString().split(" -> ")[1].replace("]", "").split(": ");
        String locator = data[0];
        String term = data[1];
        By subirArchivoBy;
        switch (locator) {
            case "xpath":
                subirArchivoBy = By.xpath(term);
                break;
            case "css selector":
                subirArchivoBy = By.cssSelector(term);
                break;
            case "id":
                subirArchivoBy = By.id(term);
                break;
            case "tag name":
                subirArchivoBy = By.tagName(term);
                break;
            case "name":
                subirArchivoBy = By.name(term);
                break;
            case "link text":
                subirArchivoBy = By.linkText(term);
                break;
            default:
                subirArchivoBy = By.className(term);
                break;
        }
        //opcion con FileToUpload desde WebElement
        //FileToUpload fileToUpload = new FileToUpload(BrowseTheWeb.as(actor).getDriver(), rutaArchivo);
        //fileToUpload.fromLocalMachine().to(subirArchivo);
        //Cargue archivo con serenityBdd
        //Path rutaArchivoPath = Paths.get(rutaArchivo);
        //actor.attemptsTo(Upload.theFile(rutaArchivoPath).to(CargueArchivoEmpleadosUi.BOTON_CARGUE_ARCHIVO));
        //Cargue archivo con By
        BrowseTheWeb.as(actor).getDriver().findElement(subirArchivoBy).sendKeys(rutaArchivo);

        actor.attemptsTo(Click.on(CargueArchivoEmpleadosUi.BOTON_UPLOAD));

    }
}
