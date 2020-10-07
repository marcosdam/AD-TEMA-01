package Ejemplos.LecturaEscrituraBinarios;

import java.io.*;

public class EjObjetos {
    public static void main(String[] args) {
        File f = new File("EJObjetos.dat");     // Declaramos el fichero

        // Si el fichero existe utilizo mi propia función para añadir objetos sin cabecera
        if(f.exists())
            miEscribirObjeto(f);
        else
            escribirObjeto(f);      // Escribimos los objetos en él

        leerObjeto(f);      // Leemos los objetos de él
    }

    public static void escribirObjeto(File f){
        try {
            // 1. DEFINIR FLUJO DE DATOS (FOS para binarios Y OOS para objetos)
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            // 2. ARRAY DE PERSONAS
            Persona[] misPersonas =
                    {new Persona("Pepe", 23), new Persona("Laura", 26),
                    new Persona("Sara", 33), new Persona("Sergio", 22)};

            // 3. FOR EACH PARA RECORRER PERSONAS[] (por cada Persona 'p' en Personas[])
            for (Persona p:misPersonas) {
                oos.writeObject(p);
            }
            // 4. CERRAR FLUJO DE DATOS (OOS Y FOS)
            oos.close();    // flujo Objetos
            fos.close();    // flujo binarios

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Escribir a continuación del fichero ya escrito, pero sin header
    static void miEscribirObjeto(File f){
        try {
            // Creo el flujo de datos binarios al fichero y pongo el append true para añadir datos
            FileOutputStream fos = new FileOutputStream(f, true);
            //Utilizamos nuestro MOOS para que no añada cabecera al fichero al añadir objetos
            MiObjectOutputStream moos = new MiObjectOutputStream(fos);

            // Ahora hay que añadir los objetos
            Persona[] misPersonas =
                    {new Persona("Marta", 25), new Persona("Eduardo", 35)};

            // foreach persona en en array, escribimos cada persona con nuestro propio método sin cabecera
            for (Persona p:misPersonas) {
                moos.writeObject(p);
            }

            // CERRAMOS FLUJOS DE DATOS (binarios y de objetos)
            moos.close();
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void leerObjeto(File f){
        try {
            // 1. CREAR FLUJO DE LECTURA DE DATOS BINARIOS DESDE EL FICHERO
            FileInputStream fis = new FileInputStream(f);
            // 1. CREAR FLUJO DE LECTURA DE OBJETOS DESDE EL FICHERO
            ObjectInputStream ois = new ObjectInputStream(fis);

            // Declarar Persona auxiliar
            Persona p;

            // Bucle infinito hasta que la excepción nos expulse (cuando no quede nada que leer en el fichero)
            while(true){
                p = (Persona)ois.readObject();
                System.out.println(p.toString());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");
        } catch (IOException e) {
            System.out.println("Fin del fichero");
        } catch (ClassNotFoundException e) {
            System.out.println("La clase no existe");
        }
    }

}
