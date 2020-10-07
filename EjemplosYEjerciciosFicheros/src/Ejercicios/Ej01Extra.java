package Ejercicios;

import java.io.*;

public class Ej01Extra {
    public static void main(String[] args) {
        /*1. Programa que abra el fichero temperaturas.txt (creado y rellenado previamente)
        * ubicado en el directorio de trabajo y muestre por pantalla la media aritmética,
        * el valor máximo y el valor mínimo.*/

        double media = 0, suma = 0;
        double[] temperaturas = new double[8];
        double maxima = temperaturas[0];
        double minima = temperaturas[0];

        // 1. Crear el txt
        File f = new File("temperaturas.txt");

        // 2. Leer
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null){
                double tempActual = Double.parseDouble(linea);
                suma += tempActual;
                media = suma/temperaturas.length;

                for (int i = 0; i < temperaturas.length; i++){
                    temperaturas[i] = tempActual;
                    if (maxima < temperaturas[i])
                        maxima = temperaturas[i];
                    if (minima > temperaturas[i])
                        minima = temperaturas[i];
                }

                System.out.println(linea  + "ºC");
            }
            System.out.println("\nMEDIA: " + media + "ºC");
            System.out.println("TEMPERATURA MÁXIMA: " + maxima + "ºC");
            System.out.println("TEMPERATURA MÍNIMA: " + minima + "ºC");

            // 3. Cerrar flujos datos
            br.close();
            fr.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
