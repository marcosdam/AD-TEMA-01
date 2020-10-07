package SAX;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ProcesaLibro {
    public static void main(String[] args) {
        // Creamos la lista de libros
        ArrayList<Libro> miLista = new ArrayList<>();

        // Creamos la factoria de parseadores (troceadores) por defecto
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();

            // Añadimos nuestro manejador al reader pasándole el arrayList
            reader.setContentHandler(new ManejadorLibro(miLista));

            // Procesamos el XML de ejemplo
            reader.parse(new InputSource(new FileInputStream("libro.xml")));

            // Ya lo tenemos troceado, solo falta sacarlo por pantalla
            for (Libro l:miLista) {
                System.out.println(l.toString());
            }

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
