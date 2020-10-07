package EjercicioDOM;

import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;

public class EjDOMa {
    public static void main(String[] args) {
        /* Ejercicio DOM
        1.- Realiza las siguientes tareas, a partir de la clase EjercicioDOM.Persona:
        a) Crea un fichero "FichPersona.dat", que almacene varios objetos persona(Nombre
        y edad).
        b) Tomando como base el fichero anterior, crea un documento XML usando DOM.
        c) Implementa una clase que permita leer el documento XML del apartado anterior.*/

        // 1. Creamos 3 objetos
        Persona[] misPersonas =
                {new Persona("Pepe", 20),
                        new Persona("Laura", 40),
                        new Persona("Marta", 30)};

        // 2. Declaramos el fichero
        File f = new File("FichPersona.dat");

        // 3. Si el fichero existe utilizo mi propia función para añadir objetos sin cabecera
        if (f.exists())
            guardarPersonaMIOOS(f, misPersonas);
        else
            guardarPersona(f, misPersonas);

        // Parte B
        crearXML_DOM(f);
        // Parte C
        File fileXML = new File("escribirXMLpersona.xml");
        //leerXML_DOM(fileXML);

        // Parte D (leerXML_SAX)
        leerXML_SAX();
    }

    // guardarPersona
    private static void guardarPersona(File f, Persona[] misPersonas) {
        try {
            // 1. DEFINIR FLUJO DE DATOS (FOS para binarios Y OOS para objetos)
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            // POR CADA OBJETO objPersona EN MISPERSONAS LO ESCRIBIMOS EN EL FICHERO (oos.write)
            for (Persona persona : misPersonas) {
                oos.writeObject(persona);
            }
            // 3. CERRAR FLUJO DE DATOS (OOS Y FOS)
            oos.close();    // flujo Objetos
            fos.close();    // flujo binarios

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Escribir a continuación del fichero ya escrito (append true), pero sin header (MiObjectOutputSteam sobreescrito)
    private static void guardarPersonaMIOOS(File f, Persona[] misPersonas) {
        try {
            // Creo el flujo de datos binarios al fichero y pongo el append true para añadir datos
            FileOutputStream fos = new FileOutputStream(f, true);

            // Utilizamos nuestro MOOS para que no añada cabecera al fichero al añadir objetos
            MiObjectOutputStream moos = new MiObjectOutputStream(fos);

            // Ahora hay que escribir los objetos
            for (Persona persona : misPersonas) {
                moos.writeObject(persona);
            }

            // CERRAMOS FLUJOS DE DATOS (binarios y de objetos)
            moos.close();
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Parte B
    private static void crearXML_DOM(File f) {
        try {
            // Instanciamos DBF
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();
            // Creamos elemento raíz
            Element raiz = doc.createElement("Personas");
            doc.appendChild(raiz);
            // Creamos un hijo texto con salto de línea por estética
            raiz.appendChild(doc.createTextNode("\n"));

            // Traemos a un array las personas que leemos del fichero .dat
            Persona[] personas = leerPersonas(f);

            // Añadimos elementos al XLM
            int i = 0;
            while (personas[i] != null) {
                // Crear elemento persona y añadirlo como hijo de la raíz personas
                Element persona = doc.createElement("Persona");
                persona.appendChild(doc.createTextNode("\n"));  // Salto de línea
                raiz.appendChild(persona);

                Element nombre = doc.createElement("Nombre");
                persona.appendChild(nombre);
                nombre.setTextContent(personas[i].getName());
                persona.appendChild(doc.createTextNode("\n"));  // Salto de línea

                Element edad = doc.createElement("Edad");
                persona.appendChild(edad);
                edad.setTextContent(String.valueOf(personas[i].getEdad()));
                persona.appendChild(doc.createTextNode("\n"));  // Salto de línea

                raiz.appendChild(doc.createTextNode("\n")); // Salto de línea (cierre de personas)

                i++;
            }
            // Creamos el archivo XML con el árbol DOM que hemos creado (Usamos Transformer)
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            DOMSource fuente = new DOMSource(doc);  // Le pasamos como fuente nuestro Document(doc) que tiene el árbol DOM
            StreamResult result = new StreamResult(new File("escribirXMLpersona.xml"));
            // Llamamos al transformer y le pasamos el source(fuente) y el result
            transformer.transform(fuente, result);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    // Leer objetos del fichero (lo usaremos en crearXML_DOM();
    private static Persona[] leerPersonas(File f) {
        Persona[] personas = new Persona[100];
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            int i = 0;
            // Leer mientras se pueda
            while (true) {
                // Guardar las personas del fichero en el array
                personas[i] = (Persona)ois.readObject();
                i++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            // Modificamos esta IOException
        } catch (IOException e) {
            System.out.println("FIN DEL FICHERO");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return personas;
    }

    // Leer archivo XML
    private static void leerXML_DOM(File f) {
        try {
            // Utilizamos DocumentBuilder para parsear el XML
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            // Troceamos el xml y lo guardamos en un doc
            Document doc = db.parse(f);
            // Con esto le damos al texto un formato visual mejor
            doc.getDocumentElement().normalize();

            // Obtenemos la raíz de nuestro árbol DOM (empresa -> nodo principal)
            System.out.println("Elemento raíz del XML: " + doc.getDocumentElement().getNodeName());

            // Buscamos los elementos hijos de raíz (persona -> nodo hijo) y los guardamos en una lista
            NodeList listaPersonas = doc.getElementsByTagName("Persona");
            // Recorremos los nodos para sacar la información
            for (int i = 0; i < listaPersonas.getLength(); i++) {
                //Vamos a guardar ese nodo en el que estamos
                Node nodo = listaPersonas.item(i);
                // Lo imprimimos
                System.out.println("Elemento: " + nodo.getNodeName());
                //
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodo;
                    // Ahora leemos el contenido de los nodos (nombre y edad)
                    System.out.println("Nombre: " + element.getElementsByTagName("Nombre").item(0).getTextContent());
                    System.out.println("Edad: " + element.getElementsByTagName("Edad").item(0).getTextContent());
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void leerXML_SAX() {
        // Creamos la lista de libros
        ArrayList<Persona> listaPersonas = new ArrayList<>();

        // Creamos la factoria de parseadores (troceadores) por defecto
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();

            // Añadimos nuestro manejador al reader pasándole el arrayList
            reader.setContentHandler(new ManejadorPersona(listaPersonas));

            // Procesamos el XML de ejemplo
            reader.parse(new InputSource(new FileInputStream("escribirXMLpersona.xml")));

            // Ya lo tenemos troceado, solo falta sacarlo por pantalla
            for (Persona persona : listaPersonas) {
                System.out.println(persona.toString());
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
