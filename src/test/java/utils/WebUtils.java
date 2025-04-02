package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class WebUtils {

    public static String readProperty(String archivo, String clave) {
        Properties propiedades = new Properties();
        try (InputStream entrada = WebUtils.class.getResourceAsStream("/" + archivo)) {
            if (entrada == null) {
                throw new IllegalArgumentException("Archivo no encontrado: " + archivo);
            }
            propiedades.load(entrada);
            return propiedades.getProperty(clave);
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo", e);
        }
    }
}
