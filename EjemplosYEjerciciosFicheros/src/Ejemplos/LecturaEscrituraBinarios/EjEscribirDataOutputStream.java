package Ejemplos.LecturaEscrituraBinarios;

import java.io.*;

public class EjEscribirDataOutputStream {
    public static void main(String[] args) {
        // 1. Crear fichero
        File f = new File("DATAOS.dat");
        // 2. Crear Flujo de datos de salida ( Data Output Stream)
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(f));
            // 8 nombres y 8 edades
            String[] nombres = {"Paco", "Pepe", "Pedro", "Marta", "María", "Elena", "Julia", "Miguel"};
            int[] edades = {12, 18, 15, 30, 20, 21, 22, 25};

            for (int i = 0; i < edades.length; i++) {
                // .writeUTF para escribir Strings
                dos.writeUTF(nombres[i]);
                dos.writeInt(edades[i]);
            }
            // 3. Cerrar flujo de datos
            dos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
