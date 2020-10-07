package Ejemplos.LecturaEscrituraFicheros;

import java.io.*;

public class EjFileWriter {
    public static void main(String[] args) {
        // 1. Declarar el fichero
        File fichero = new File("EjemploFW.txt");

        // 2. Definir flujo de datos (Trabajaremos con el FileWriter)
        try {
            FileWriter fw = new FileWriter(fichero, true);  // Escribirá a continuación del fichero existente
            String frase = "Esto es una prueba de File Writer 2";

            // 3. Escribiremos por carácteres, hay que recorrer la cadena (char[])
            char[] cadena = frase.toCharArray();    // Convertimos el String a char Array

            // 4. Recorremos el array
            for (int i = 0; i < cadena.length; i++) {
                // 5. En cada iteración escribimos el carácter en el fichero
                fw.write(cadena[i]);
            }
            // 6. Añadimos al final del fichero un asterisco con APPEND
            fw.append('*');

            // Otra forma es hacerlo del tirón, ya que FileWriter acepta int, String, char[]
            fw.write(cadena);

            // También puede escribir un String
            String last = "\nEsto es lo último*\n";
            fw.write(last);
            fw.write("\n");

            // Y los elementos de un Array[]
            String[] provincias = {"Albacete", "Soria", "Valencia", "Alicante"};
            for (int i = 0; i < provincias.length; i++) {
                fw.write(provincias[i]);
                fw.write("\n");
            }

            // 7. CERRAR EL FICHERO
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
