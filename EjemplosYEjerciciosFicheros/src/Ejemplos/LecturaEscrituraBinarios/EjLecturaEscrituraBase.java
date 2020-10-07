package Ejemplos.LecturaEscrituraBinarios;

import java.io.*;

public class EjLecturaEscrituraBase {
    public static void main(String[] args) {
        // En lugar de .txt vamos a tener archivos .dat (binarios)
        File f = new File("EjemploBinario.dat");

        // 2. File Output Stream (FOS)
        try {
            FileOutputStream fos = new FileOutputStream(f);
            // 3. Escribimos en el fichero números del 0 al 49 en binario
            for (int i = 0; i < 50; i++) {
                fos.write(i);
            }
            // 4. Cerramos el File Output Stream
            fos.close();

            // 5. Leemos
            FileInputStream fis = new FileInputStream(f);
            int j;
            while ((j=fis.read()) != -1){
                System.out.println(j);  // Leemos mientras queden datos, si no quedan devuelve -1 y sale del bucle
            }
            // 6. Cerramos el File Input Stream
            fis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
