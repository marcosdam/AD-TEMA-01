package Ejemplos.FicherosDirectorios;

import java.io.*;

public class CrearBorrarFicheros {
    public static void main(String[] args) {
        // Creamos un directorio, 2 archivos y les cambiamos el nombre

        // 1. Crear directorio
        File directorio = new File("NUEVODIR");

        // 2. Crear 2 ficheros dentro del NUEVODIR
        File f1 = new File(directorio, "fichero1.txt");
        File f2 = new File(directorio, "fichero2.txt");

        // Creo el directorio
        directorio.mkdir();

        try{
            if (f1.createNewFile())
                System.out.println("Fichero creado correctamente"); // Creo el fichero 1
            else
                System.out.println("No se ha podido crear el fichero 1");   // Si no puede crearlo, lo aviso
            if (f2.createNewFile())
                System.out.println("Fichero creado correctamente");
            else
                System.out.println("No se ha podido crear el fichero 2");

            // 3. Renombrar el fichero1
            f1.renameTo(new File(directorio, "FICHERO1NUEVO.txt"));
            System.out.println("Renombro el fichero1");

            // 4. Nuevo archivo (fichero3)
            File f3 = new File("NUEVODIR/FICHERO3.txt");
            if (f3.createNewFile())
                System.out.println("Creo el fichero3");
            else
                System.out.println("El fichero 3 ya existe");

            // DESTRUIR:
            if (f1.delete()) System.out.println("Fichero eliminado");
            else System.out.println("No se ha podido eliminar el fichero 1");

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
