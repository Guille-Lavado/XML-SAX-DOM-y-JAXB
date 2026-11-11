package org.example.modelo;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa la etiqueta raíz <Libreria>, que contiene la lista de libros.
 * @XmlAccessorType: Indica a JAXB que leerá y escribirá directamente en los campos de la clase
 * @XmlRootElement: Indica que puede ser elemento raíz de un documento
 */
@XmlRootElement(name = "Libreria")
@XmlAccessorType(XmlAccessType.FIELD)
public class Libreria {

    @XmlElement(name = "Libro")
    private List<Libro> libros = new ArrayList<>();

    public Libreria() {}

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
}
