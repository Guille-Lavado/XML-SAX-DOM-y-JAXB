package org.example;

import org.example.libreria.ConsultaXPathMain;
import org.example.libreria.LeerJAXBMain;
import org.example.libreria.LeerSAXMain;
import org.example.libreria.ModificarGuardarJAXBMain;

public class Main {

    public static void main(String[] args) {
        // Ejercicio 2: Lectura secuencial con SAX
        LeerSAXMain.main(args);
        System.out.println("\n");

        // Ejercicio 3: Lectura y mapeo a objetos con JAXB
        LeerJAXBMain.main(args);
        System.out.println("\n");

        // Ejercicios 4 y 5: Modificación y escritura en disco con JAXB
        ModificarGuardarJAXBMain.main(args);
        System.out.println("\n");

        // Ejercicio 6: Consultas y filtrado con XPath
        ConsultaXPathMain.main(args);
        System.out.println("\n");
    }
}