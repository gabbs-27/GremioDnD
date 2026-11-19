package modelo;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class GestorArchivo {

    public static final String RUTA_ARCHIVO = "registro_gremio.txt";

    public static void anexar(String texto) throws IOException {
        FileWriter escritor = new FileWriter(RUTA_ARCHIVO, true);
        escritor.write("[" + LocalDateTime.now().withNano(0) + "] " + texto + "\n");
        escritor.close();
    }
}
