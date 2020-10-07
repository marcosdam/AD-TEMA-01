package Ejercicios;

import java.io.*;

public class Ej02Extra {
    public static void main(String[] args) {
        /*2. Programa que calcule el tamaño total en bytes que ocupan los archivos ubicados en el directorio de trabajo
        sin contabilizar lo que ocupan los subdirectorios ubicados en el mismo.*/

        double totalBytes = 0;
        String dirActual = ".";

        // 1. Crear directorio
        File f = new File(dirActual);

        // 2. Listar archivos
        String[] archivos = f.list();
        // 3. Tamaño dirActual
        System.out.println("\nTamaño : " + f.length());

        // 4. Ver tamaño de los archivos en dirActual
        System.out.println("Ficheros en " + f.getName() + " : " + archivos.length +"\n");

        // 5. Ver más información de los archivos (nombre, si es fichero o directorio)
        for (int i = 0; i < archivos.length; i++) {
            File f2 = new File(f, archivos[i]);
            if(f2.isFile())
                System.out.println("Nombre: " + archivos[i] + " Tamaño: " + f2.length() + " Bytes");
        }

    }
}
