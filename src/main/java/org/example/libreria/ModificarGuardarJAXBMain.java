package org.example.libreria;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.example.modelo.Libreria;
import org.example.modelo.Libro;

import java.io.File;
import java.io.InputStream;

public class ModificarGuardarJAXBMain {

    private static final String FICHERO_XML = "libreria.xml";

    public static void main(String[] args) {
        // Datos de entrada para la modificación
        String isbnBuscar = "978-84-1545-000-0";
        String nuevoTitulo = "Acceso a Datos Avanzado en Java (Edición Modificada)";

        // Buscar Libreria
        InputStream input = ConsultaXPathMain.class.getClassLoader().getResourceAsStream(FICHERO_XML);
        if (input == null) {
            System.err.println("No se encontró el archivo " + FICHERO_XML);
            return;
        }

        try {
            // Crear el contexto JAXB con la clase raíz Libreria
            JAXBContext context = JAXBContext.newInstance(Libreria.class);

            // UNMARSHALLING (Leer el XML y convertirlo a Objetos Java)
            Unmarshaller unmarshaller = context.createUnmarshaller();

            // Leemos el fichero
            Libreria libreria = (Libreria) unmarshaller.unmarshal(input);

            // EJERCICIO 4 - Buscar por ISBN y modificar el título
            boolean encontrado = false;

            for (Libro libro : libreria.getLibros()) {
                if (libro.getIsbn().equalsIgnoreCase(isbnBuscar)) {
                    System.out.println("Libro encontrado: " + libro.getTitulo());
                    // Modificamos el título del objeto en memoria RAM
                    libro.setTitulo(nuevoTitulo);
                    encontrado = true;
                    System.out.println("--> Nuevo título asignado: " + libro.getTitulo());
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("No se encontró ningún libro con el ISBN: " + isbnBuscar);
                return;
            }

            // EJERCICIO 5 - MARSHALLING (Guardar la lista modificada a XML)
            Marshaller marshaller = context.createMarshaller();

            // Propiedad para que el XML resultante esté sangrado y bien formateado
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Archivo de salida donde guardaremos el resultado
            File archivoSalida = new File("src/main/resources/libreria_modificada.xml");

            // Convertir el objeto Java actualizado a un fichero XML en disco
            marshaller.marshal(libreria, archivoSalida);

            System.out.println("\n¡Éxito! El archivo se ha guardado correctamente en:");
            System.out.println(archivoSalida.getAbsolutePath());

        } catch (JAXBException e) {
            System.err.println("Error al procesar JAXB: " + e.getMessage());
            e.printStackTrace();
        }
    }
}