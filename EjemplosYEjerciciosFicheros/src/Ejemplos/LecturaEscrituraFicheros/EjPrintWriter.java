package Ejemplos.LecturaEscrituraFicheros;

import java.io.*;

public class EjPrintWriter {
    public static void main(String[] args) {
        File f = new File("EjemploPrintWriter.txt");
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(f));
            // Una vez creado el Print Writer vamos a escribir
            for (int i = 0; i < 10; i++) {
                pw.println("Esta es la fila número " + i + " con PrintWriter");
            }
            // Cerrar Print Writer
            pw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
