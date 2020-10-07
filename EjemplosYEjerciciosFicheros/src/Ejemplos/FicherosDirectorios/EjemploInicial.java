package Ejemplos.FicherosDirectorios;

import java.io.*;

public class EjemploInicial {
    public static void main(String[] args) {
        // CREAR ARCHIVO EN CARPETA ACTUAL (La del proyecto)
        File f = new File(".");
        // GUARDAMOS EL LISTADO DE FICHEROS DE LA CARPETA EN UN ARRAY
        String[] ficheros = f.list();
        for (int i = 0; i < ficheros.length; i++) {
            // CREAMOS UN FICHERO EN CADA ITERACIÓN
            File f2 = new File(f, ficheros[i]);
            System.out.println("Nombre del archivo: " + f2.getName());
            System.out.println("¿Es un directorio? " + f2.isDirectory());
            System.out.println("¿Es un fichero? " + f2.isFile());
            System.out.println("Ruta absoluta: " + f2.getAbsolutePath());
            System.out.println("Ruta relativa: " + f2.getPath());
            System.out.println("Padre: " + f2.getParent());
            System.out.println("Tamaño: " + f2.length());
            System.out.println("Puede ejecutarse?: " + f2.canExecute());
            System.out.println("Puede leerse?: " + f2.canRead());
            System.out.println("Puede escribir?: " + f2.canWrite());
            System.out.println(" ");
        }
    }
}
