package DOM;

import org.w3c.dom.*;

import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public class EscribirXML {
    public static void main(String[] args) {
        // Vamos a crear el documento con DocumentReader
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();
            // Creamos elemento raíz
            Element raiz = doc.createElement("root");
            doc.appendChild(raiz);
            // Creamos un hijo texto con salto de línea por estética
            raiz.appendChild(doc.createTextNode("\n"));

            // Añado el primer elemento a mi árbol
            Element elemento1 = doc.createElement("elemento1");
            raiz.appendChild(elemento1);
            raiz.appendChild(doc.createTextNode("\n"));

            // Añadimos atributo al elemento
            Attr atributo = doc.createAttribute("id");
            atributo.setValue("valor del atributo");
            elemento1.setAttributeNode(atributo);

            // Añadimos otro elemento
            Element elemento2 = doc.createElement("elemento2");
            elemento2.setTextContent("Contenido del elemento 2");   // A este le añadimos contenido en lugar de atributo
            raiz.appendChild(elemento2);
            raiz.appendChild(doc.createTextNode("\n"));

            // Creamos el archivo XML con el árbol DOM que hemos creado
            // Para ello usaremos la clase Transformer
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            DOMSource fuente = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("escribirXML.xml"));

            //
            transformer.transform(fuente, result);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
