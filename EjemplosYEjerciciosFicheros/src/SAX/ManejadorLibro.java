package SAX;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

// Para trabajar con SAX heredamos de un manejador por defecto (DefaultHandler)
public class ManejadorLibro extends DefaultHandler {
    private String valor = null;
    private ArrayList<Libro> libros;
    private Libro libro;

    // Creamos constructor solo con ArrayList
    public ManejadorLibro(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    // Usamos funciones heredadas (no Geeters & Setters)    StartElement, Character, Element
    // sobreescribimos función StartElement
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // Limpiamos variable temporal
        valor = null;
        // Si la etiqueta es libro tego que leer el isbn
        if(localName.equalsIgnoreCase("libro")){
            libro = new Libro();
            // Recupero isbn de los atributos
            String isbn = attributes.getValue("isbn");
            // Una vez guardado, lo introduzco en mi objeto Libro
            libro.setIsbn(isbn);
        }
    }

    // sobreescribimos función characters
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // Guardamos el valor en nuestra variable auxiliar
        valor = new String(ch, start, length);
    }

    // sobreescribimos función endElement
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Vamos a detectar en qué etiqueta estamos y según la etiqueta
        // guardamos en su correspondiente variable de libro
        if(localName.equals("titulo")){
            libro.setTitulo(valor);
        }else if(localName.equals("autor")){
            libro.setAutor(valor);
        }else if(localName.equals("anyo")){
            libro.setAnyo(valor);
        }else if(localName.equals("editorial")){
        libro.setEditorial(valor);
        }else if(localName.equals("libro")){
        libros.add(libro);
        }
    }
}
