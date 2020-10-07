package Ejemplos.LecturaEscrituraBinarios;

import java.io.*;

public class EjLecturaData {
    public static void main(String[] args) {
        // Creamos el fichero que queremos leer
        File f = new File("DATAOS.dat");

        // Creamos flujo de datos ( Data Input Stream )
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream(f));

            // String e int auxiliares para leer
            String nombre;
            int edad;

            while (true){
                nombre = dis.readUTF(); // Recuperamos el nombre
                edad = dis.readInt(); // Lo mismo con la edad
                System.out.println("Nombre: " + nombre + " Edad: " + edad);
            }

        } catch (EOFException eofe){
            System.out.println("Fin del fichero");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
