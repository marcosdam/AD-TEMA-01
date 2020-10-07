package Ejemplos.FicherosDirectorios;

import java.io.*;

public class ListadoFicheros {
    public static void main(String[] args) {
        // Pedimos al usuario la ruta del fichero y lo leemos
        System.out.println("Dime la ruta del fichero (ruta relativa)");
        // Preparamos el buffer para leer la entrada
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String linea = br.readLine();
            File f = new File(linea);
            // Sacamos la ruta absoluta
            System.out.println("El archivo solicitado es: " + f.getAbsolutePath());
            System.out.println("Y su tamaño es de: " + f.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
