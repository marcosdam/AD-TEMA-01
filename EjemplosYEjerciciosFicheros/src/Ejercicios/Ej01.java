package Ejercicios;

import java.io.*;

public class Ej01 {
    public static void main(String[] args) {
        /* 1. Disponemos de un archivo de texto en el que en cada una de sus líneas aparece
        una anotación correspondiente a un cargo o abono en una cuenta bancaria. Se pide
        desarrollar un programa que procese esta información mostrando al finalizar el saldo
        bancario por pantalla, así como el número de cargos y abonos que se han procesado.*/


        int cantidadCargos = 0, cantidadAbonos = 0;
        double saldo = 0;

        // 1. Crear el txt
        File f = new File("CuentaBancaria.txt");

        // 2. Leer
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null){
                System.out.println(linea);

                String arrLinea[] = linea.split(" ");
                if (arrLinea[0].equalsIgnoreCase("cargo")){
                    saldo -= (saldo + Double.parseDouble(arrLinea[1]));
                    cantidadCargos += 1;
                }
                if (arrLinea[0].equalsIgnoreCase("abono")){
                    saldo += (saldo + Double.parseDouble(arrLinea[1]));
                    cantidadAbonos += 1;
                }
            }
            System.out.println("\nSALDO: " + saldo + "€");
            System.out.println("CARGOS PROCESADOS: " + cantidadCargos);
            System.out.println("ABONOS PROCESADOS: " + cantidadAbonos);

            br.close();
            fr.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
