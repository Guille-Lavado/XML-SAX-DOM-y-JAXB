package org.example.libreria;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import org.example.modelo.Libreria;
import org.example.modelo.Libro;

import java.io.InputStream;

/**
 * La clase para ejecutar la lectura del archivo XML con JAXB
 */
public class LeerJAXBMain {

    private static final String FICHERO_XML = "libreria.xml";

    public static void main(String[] args) {
        // Buscar el archivo en src/main/resources
        InputStream input = ConsultaXPathMain.class.getClassLoader().getResourceAsStream(FICHERO_XML);
        if (input == null) {
            System.err.println("No se encontró el archivo " + FICHERO_XML);
            return;
        }

        try {
            // Crear el contexto JAXB indicando la clase raíz
            JAXBContext context = JAXBContext.newInstance(Libreria.class);

            // Crear el objeto Unmarshaller (XML -> Objetos Java)
            Unmarshaller unmarshaller = context.createUnmarshaller();

            // Transformar el XML en objetos Java
            Libreria libreria = (Libreria) unmarshaller.unmarshal(input);

            // Mostrar los libros cargados
            System.out.println("=== LIBROS CARGADOS CON JAXB ===");
            for (Libro libro : libreria.getLibros()) {
                System.out.println(libro);
            }

        } catch (Exception e) {
            System.err.println("Error en JAXB: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
