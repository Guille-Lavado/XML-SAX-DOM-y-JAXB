# Ejercicios Propuestos
Como ejercicio para aplicar lo visto en este capítulo se propone una aplicación de gestión de una librería. Los pasos que la describen son:
1. Crear un esquema XML para soportar los libros de una librería. Los campos que debe tener son título, autor, ISBN, número de ejemplares, editorial, número de páginas, año de edición. El diseñador del esquema puede libremente elegir cuáles de esos campos son atributos o elementos. Una vez creado el esquema hay que crear un documento XML válido para el esquema.
2. La aplicación debe permitir mostrar todo el documento XML creado anteriormente (usando SAX).
3. Crear una estructura de objetos con JAXB. Para ello debe usar el esquema creado en el ejercicio 1.
4. La aplicación debe permitir modificar el título de un libro. El usuario proporciona el ISBN del libro que se quiere modificar y el nuevo título. Hay que utilizar la estructura de objetos creada en el ejercicio 3 para cargar con JAXB el documento XML con los libros de la librería, y sobre esos objetos hacer las modificaciones.
5. La aplicación debe permitir guardar la estructura de objetos JAXB en un fichero XML (marshalling-serialización).
6. La aplicación debe permitir al usuario consultar los libros de la librería usando XPath (y DOM).

# Resulucion
### Ejercicio 1: Definición del Esquema XSD y Fichero XML
* Creación del esquema (libreria.xsd): Se diseñó la estructura para validar los libros en.
* Creación del documento (libreria.xml): Se creo el archivo XML con datos de prueba en.

### Ejercicio 2: Lectura Secuencial con SAX
* Manejador de eventos (ManejadorLibreriaSAX.java): Se implementó una clase que extiende DefaultHandler para capturar eventos.
* Clase principal (LeerSAXMain.java): Se configuró el SAXParserFactory y se cargó el archivo XML

### Ejercicio 3: Estructura JAXB
* Creación de clases POJO: Libro.java y Libreria.java

### Ejercicios 4: Modificación de datos
* ModificarGuardarJAXBMain.java: Se recorrió la lista de objetos Java recuperados usando la estructura del ejercicio 3, se buscó un libro por su atributo ISBN y se actualizó su título.

### Ejercicio 5: Escritura en disco
* ModificarGuardarJAXBMain.java: Se configuró un Marshaller para guardar el resultado modificado de forma persistente en libreria_modificada.xml.

### Ejercicio 6: Consultas con XPath y DOM
* Carga con DOM y XPath (ConsultaXPathMain.java): Se cargó la estructura del XML en un objeto Document (DOM) y se compiló una instancia de XPath.
