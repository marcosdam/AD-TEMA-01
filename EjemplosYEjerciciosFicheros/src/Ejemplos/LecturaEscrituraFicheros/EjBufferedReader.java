package Ejemplos.LecturaEscrituraFicheros;

import java.io.*;

public class EjBufferedReader {
    public static void main(String[] args) {
        File f = new File("EjemploFW.txt");
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            // TODO EN UNA SOLA INSTRUCCIÓN:
            // BufferedReader br = new BufferedReader(new FileReader(new File("EjemploFW.txt")));

            // String linea para almacenar la línea que leemos
            String linea;
            while ((linea = br.readLine()) != null){  // Leemos mientras haya algo que leer
                System.out.println(linea);            // Vamos imprimiendo la línea
            }
            br.close(); // Cerramos Buffered Reader
            fr.close(); // Cerramos File Reader

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
