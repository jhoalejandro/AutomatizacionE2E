package commons;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class ArchivoUtils {

    private ArchivoUtils(){
        throw new IllegalStateException("ArchivoUtils class");
    }
    public static void eliminarArchivo(String rutaArchivo)  {
        try {
            Path path = FileSystems.getDefault().getPath(rutaArchivo);
            Files.delete(path);
        }catch(IOException e)
        {
            //Sin informacion
        }
    }

    public static Path obtenerPathArchivo(String rutaArchivo)
    {
        return FileSystems.getDefault().getPath(rutaArchivo);
    }

    public static void moverArchivo(String rutaArchivoOrigen, String rutaArchivoDestino ) throws IOException {
        File chosenFile = null;
        chosenFile = new File(rutaArchivoOrigen);
        Files.move(chosenFile.toPath(), obtenerPathArchivo(rutaArchivoDestino), StandardCopyOption.REPLACE_EXISTING);
    }

    public static boolean existeArchivo(Path path)
    {
        return Files.exists(path);

    }
}
