package org.example.libreria;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.InputStream;

/**
 * La clase para ejecutar la lectura del archivo XML con SAX
 */
public class LeerSAXMain {
    private static final String FICHERO_XML = "libreria.xml";

    public static void main(String[] args) {
        // Cargar el fichero libreria.xml desde los recursos (src/main/resources)
        InputStream input = LeerSAXMain.class.getClassLoader().getResourceAsStream(FICHERO_XML);
        if (input == null) {
            System.err.println("No se encontró el archivo '" + FICHERO_XML + "' en src/main/resources.");
            return;
        }

        try {
            // Crear la factoría y el parser SAX
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            // Crear una instancia del manejador SAX y parsear el archivo
            ManejadorLibreriaSAX manejador = new ManejadorLibreriaSAX();
            saxParser.parse(input, manejador);

        } catch (Exception e) {
            System.err.println("Error al procesar el archivo XML con SAX: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
