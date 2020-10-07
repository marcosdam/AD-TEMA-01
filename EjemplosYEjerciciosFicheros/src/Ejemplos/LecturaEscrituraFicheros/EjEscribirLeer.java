package Ejemplos.LecturaEscrituraFicheros;

import java.io.*;

public class EjEscribirLeer {
    public static void main(String[] args) {
        // 1. Crear archivo
        File archivo = new File("EjerEscribirLeer.txt");

        // 2. Escribir en él ( FileWriter )
        try {
            FileWriter fw = new FileWriter(archivo, true);
            String frase = "Soy un String escrito con FileWriter";
            fw.write(frase);

            // 3. CERRAR EL File Writer
            fw.close();

            // 4. Leer el archivo ( File Reader )
            FileReader fr = new FileReader(archivo);    // Permite leer CARACTERES
            int i;
            while((i=fr.read()) != -1){
                System.out.println((char)i);
            }
            // 5. CERRAR FILE READER
            fr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
