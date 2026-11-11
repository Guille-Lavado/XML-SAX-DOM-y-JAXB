package org.example.libreria;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Esta clase escucha los eventos del analizador SAX redefiniendo los métodos de DefaultHandler
 */
public class ManejadorLibreriaSAX extends DefaultHandler {

    private StringBuilder valorCadena;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("=== INICIO DE LECTURA DEL DOCUMENTO LIBRERÍA (SAX) ===\n");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        valorCadena = new StringBuilder();

        // Si entramos en la etiqueta <Libro>, leemos sus atributos (ISBN y año)
        if (qName.equalsIgnoreCase("Libro")) {
            String isbn = attributes.getValue("isbn");
            String ano = attributes.getValue("ano");
            System.out.println("----------------------------------------");
            System.out.println("LIBRO [ISBN: " + isbn + " | Año: " + ano + "]");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // Captura el contenido textual del elemento actual
        if (valorCadena != null) {
            valorCadena.append(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (valorCadena != null) {
            String texto = valorCadena.toString().trim();

            if (!texto.isEmpty()) {
                switch (qName) {
                    case "Titulo":
                        System.out.println("  - Título: " + texto);
                        break;
                    case "Autor":
                        System.out.println("  - Autor: " + texto);
                        break;
                    case "Editorial":
                        System.out.println("  - Editorial: " + texto);
                        break;
                    case "Ejemplares":
                        System.out.println("  - Ejemplares: " + texto);
                        break;
                    case "Paginas":
                        System.out.println("  - Páginas: " + texto);
                        break;
                }
            }
        }
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("----------------------------------------");
        System.out.println("\n=== FIN DE LECTURA DEL DOCUMENTO ===");
    }
}
