package Ejemplos.LecturaEscrituraFicheros;

import java.io.*;

public class EjFileReader {

    public static void main(String[] args) {
        // Creamos fichero
        File fichero = new File("./EjemploFW.txt");
        try{
            FileReader fr = new FileReader(fichero);    // Permite leer CARACTERES
            int i;
            while((i=fr.read()) != -1) System.out.println((char)i);
            // Otra forma (más común)
            //while(true) System.out.println(fr.read());

        }catch (FileNotFoundException fnfe){
            fnfe.getStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}