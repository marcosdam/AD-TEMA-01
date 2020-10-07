package DOM;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;

public class LeerXML {
    public static void main(String[] args) {

        try {
            // Utilizamos DocumentBuilder para parsear el XML
            File f = new File("leerXML.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            // Troceamos el xml y lo guardamos en un doc
            Document doc = db.parse(f);
            // Con esto le damos al texto un formato visual mejor
            doc.getDocumentElement().normalize();

            // Obtenemos la raíz de nuestro árbol DOM (empresa -> nodo principal)
            System.out.println("Elemento raíz: " + doc.getDocumentElement().getNodeName());

            // Buscamos los elementos hijos de raíz (empleado -> nodo hijo) y los guardamos en una lista
            NodeList listaEmpleados = doc.getElementsByTagName("empleado");
            // Recorremos los nodos para sacar la información
            for (int i = 0; i < listaEmpleados.getLength(); i++) {
                //Vamos a guardar ese nodo en el que estamos
                Node nodo = listaEmpleados.item(i);
                // Lo imprimimos
                System.out.println("Elemento: " + nodo.getNodeName());
                //
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodo;
                    // Para leer atributos utilizamos el getAttribute
                    System.out.println("id: " + element.getAttribute("id"));
                    // Ahora leemos el contenido de los nodos (nombre, username, password)
                    System.out.println("Nombre: " + element.getElementsByTagName("nombre").item(0).getTextContent());
                    System.out.println("Username: " + element.getElementsByTagName("username").item(0).getTextContent());
                    System.out.println("Password: " + element.getElementsByTagName("password").item(0).getTextContent());
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
}
