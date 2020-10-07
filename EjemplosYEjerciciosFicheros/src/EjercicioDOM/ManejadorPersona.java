package EjercicioDOM;

import SAX.Libro;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

// Para trabajar con SAX heredamos de un manejador por defecto (DefaultHandler)
public class ManejadorPersona extends DefaultHandler {
    private String valor = null;
    private ArrayList<Persona> personas;
    private Persona persona;

    // Creamos constructor solo con ArrayList
    public ManejadorPersona(ArrayList<Persona> personas) {
        this.personas = personas;
    }

    // Usamos funciones heredadas (no Geeters & Setters)    StartElement, Character, Element
    // sobreescribimos función StartElement
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // Limpiamos variable temporal
        valor = null;
        // Si la etiqueta es libro tego que leer el nombre
        if(localName.equalsIgnoreCase("Persona")){
            persona = new Persona();
            // Recupero isbn de los atributos
            String nombre = attributes.getValue("Nombre");
            // Una vez guardado, lo introduzco en mi objeto EjercicioDOM.Persona
            persona.setName(nombre);
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
        // guardamos en su correspondiente variable de persona
        if(localName.equals("Nombre")){
            persona.setName(valor);
        }else if(localName.equals("Edad")){
            persona.setEdad(Integer.parseInt(valor));
        }else if(localName.equals("Persona")){
            personas.add(persona);
        }
    }
}