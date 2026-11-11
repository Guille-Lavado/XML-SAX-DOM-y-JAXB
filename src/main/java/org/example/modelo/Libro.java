package org.example.modelo;

import jakarta.xml.bind.annotation.*;

/**
 * Representa la estructura de cada etiqueta <Libro>
 * @XmlAccessorType: Indica a JAXB que leerá y escribirá directamente en los campos de la clase
 * @XmlType: Indica el orden de los elementos hijo
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"titulo", "autor", "editorial", "ejemplares", "paginas"})
public class Libro {

    // Atributos XML (isbn y ano)
    @XmlAttribute(name = "isbn", required = true)
    private String isbn;

    @XmlAttribute(name = "ano", required = true)
    private String ano;

    // Elementos XML hijos
    @XmlElement(name = "Titulo")
    private String titulo;

    @XmlElement(name = "Autor")
    private String autor;

    @XmlElement(name = "Editorial")
    private String editorial;

    @XmlElement(name = "Ejemplares")
    private int ejemplares;

    @XmlElement(name = "Paginas")
    private int paginas;

    // Constructores
    public Libro() {}

    public Libro(String isbn, String ano, String titulo, String autor, String editorial, int ejemplares, int paginas) {
        this.isbn = isbn;
        this.ano = ano;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.ejemplares = ejemplares;
        this.paginas = paginas;
    }

    // Getters y Setters
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getAno() { return ano; }
    public void setAno(String ano) { this.ano = ano; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public String getEditorial() { return editorial; }
    public void setEditorial(String editorial) { this.editorial = editorial; }

    public int getEjemplares() { return ejemplares; }
    public void setEjemplares(int ejemplares) { this.ejemplares = ejemplares; }

    public int getPaginas() { return paginas; }
    public void setPaginas(int paginas) { this.paginas = paginas; }

    @Override
    public String toString() {
        return "Libro{" +
                "isbn='" + isbn + '\'' +
                ", año='" + ano + '\'' +
                ", título='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", editorial='" + editorial + '\'' +
                ", ejemplares=" + ejemplares +
                ", páginas=" + paginas +
                '}';
    }
}
