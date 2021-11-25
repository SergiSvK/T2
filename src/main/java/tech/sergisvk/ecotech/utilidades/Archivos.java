package tech.sergisvk.ecotech.utilidades;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 *
 */
public class Archivos {

    /**
     * Crea un fichero vacío si aún no existe
     * @param paths ruta /examples/emptyFile.txt
     */
    public static void createFileIfNotExit(String paths){
        Path emptyFile = Paths.get(paths);
        if (Files.notExists(emptyFile)) {
            try {
                Files.createFile(Paths.get(paths));
            } catch (IOException e) {
                System.out.println("Error a la creacción de archivos");
            }
        }
    }

    /**
     * Escribe un String a un fichero de texto, sobreescribiéndolo si ya existiera
     * @param paths ruta /examples/emptyFile.txt
     * @param text texto
     */
    public static void anyadirTexto(String paths,String text){
        try {
            Files.write(Paths.get(paths), text.getBytes(StandardCharsets.UTF_8),
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
