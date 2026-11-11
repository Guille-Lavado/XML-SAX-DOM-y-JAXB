package org.example.libreria;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.InputStream;

/**
 * Esta clase realiza consultas sobre el documento XML utilizando XPath
 * XPathConstants.NODESET: Se utiliza cuando la consulta devuelve una colección de varios nodos
 * XPathConstants.STRING: Se utiliza cuando se sabe que la consulta devuelve un único resultado de texto
 */
public class ConsultaXPathMain {

    private static final String FICHERO_XML = "libreria.xml";

    public static void main(String[] args) {
        InputStream input = ConsultaXPathMain.class.getClassLoader().getResourceAsStream(FICHERO_XML);
        if (input == null) {
            System.err.println("No se encontró el archivo " + FICHERO_XML);
            return;
        }

        try {
            // Cargar el documento XML en memoria mediante DOM
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document xmlDoc = builder.parse(input);

            // Crear la instancia de XPath
            XPath xpath = XPathFactory.newInstance().newXPath();

            // CONSULTA 1: Obtener todos los títulos de los libros (/Libreria/Libro/Titulo)
            System.out.println("CONSULTA 1: Todos los Títulos");
            String expresion1 = "/Libreria/Libro/Titulo/text()";
            NodeList titulos = (NodeList) xpath.evaluate(expresion1, xmlDoc, XPathConstants.NODESET);

            for (int i = 0; i < titulos.getLength(); i++) {
                System.out.println(" - " + titulos.item(i).getNodeValue());
            }

            // CONSULTA 2: Filtrar libros con más de 10 ejemplares
            System.out.println("\nCONSULTA 2: Libros con Ejemplares > 10");
            String expresion2 = "/Libreria/Libro[Ejemplares > 10]";
            NodeList librosMuchosEjemplares = (NodeList) xpath.evaluate(expresion2, xmlDoc, XPathConstants.NODESET);

            for (int i = 0; i < librosMuchosEjemplares.getLength(); i++) {
                Element libroElem = (Element) librosMuchosEjemplares.item(i);
                String isbn = libroElem.getAttribute("isbn");
                String titulo = libroElem.getElementsByTagName("Titulo").item(0).getTextContent();
                String ejemplares = libroElem.getElementsByTagName("Ejemplares").item(0).getTextContent();
                System.out.println(" - [ISBN: " + isbn + "] " + titulo + " (Ejemplares: " + ejemplares + ")");
            }

            // CONSULTA 3: Buscar el autor de un libro por su ISBN mediante predicado
            System.out.println("\nCONSULTA 3: Autor del libro con ISBN '978-84-1545-000-0'");
            String expresion3 = "/Libreria/Libro[@isbn='978-84-1545-000-0']/Autor/text()";
            String autor = (String) xpath.evaluate(expresion3, xmlDoc, XPathConstants.STRING);
            System.out.println(" - Autor: " + autor);

        } catch (Exception e) {
            System.err.println("Error al ejecutar consultas XPath: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
