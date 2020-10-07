package Ejemplos.LecturaEscrituraFicheros;

import java.io.*;

public class EjBufferedWriter {
    public static void main(String[] args) {
        File f = new File("EjBufferedWriter.txt");

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            for (int i = 0; i < 10; i++) {
                bw.write("Esta es la fila número " + i);
                bw.newLine();   // Salto de línea
            }
            // Cerramos Buffered Writer
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
