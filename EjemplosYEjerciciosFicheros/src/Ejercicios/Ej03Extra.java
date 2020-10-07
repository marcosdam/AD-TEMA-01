package Ejercicios;

import java.io.*;

public class Ej03Extra {
    public static void main(String[] args) {
        /* 3. Programa que genere un menú que nos permita:
        - Guardar un país y su capital.(Lo añadirá a un fichero llamado PaisesYCapitales.txt)
        - Solicite un País y nosotros le devolveremos la capital.

        El menú será algo así:
        1. Introducir país y capital.
        2. Buscar un país.
        3. Salir.*/

        // 1. Crear txt
        File f = new File("PaisesYCapitales.txt");
        Pais pais = null;
        String eleccion = "";

        // 2. PEDIR NOMBRE Y CAPITAL DEL PAIS (br en lugar de Scanner)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            do {
                System.out.println("Pulsa 1, 2 o 3 + Enter");
                System.out.println("1. Introducir país y capital");
                System.out.println("2. Buscar un país");
                System.out.println("3. Salir");
                eleccion = br.readLine();

                switch (eleccion) {
                    case "1":
                        System.out.println("Escribe el nombre del país y pulsa Enter");
                        String nombre = br.readLine();
                        System.out.println("Escribe el nombre de la capital y pulsa Enter");
                        String capital = br.readLine();
                        pais = new Pais(nombre, capital);

                        // Si el fichero existe utilizo mi propia función para añadir objetos sin cabecera
                        if (f.exists())
                            guardarPaisMIOOS(f, pais);
                        else
                            guardarPais(f, pais);
                        break;
                    case "2":
                        System.out.println("Escribe el nombre del país que buscas y pulsa Enter");
                        nombre = br.readLine();
                        buscarPais(f, nombre);
                        break;
                    case "3":
                        System.exit(0);
                        break;
                }
            } while (!eleccion.equalsIgnoreCase("3"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // guardarPais
    private static void guardarPais(File f, Pais pais) {
        try {
            // 1. DEFINIR FLUJO DE DATOS (FOS para binarios Y OOS para objetos)
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            // 2. ESCRIBIR OBJETO
            oos.writeObject(pais);
            // 3. CERRAR FLUJO DE DATOS (OOS Y FOS)
            oos.close();    // flujo Objetos
            fos.close();    // flujo binarios

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Escribir a continuación del fichero ya escrito (append true), pero sin header (MiObjectOutputSteam sobreescrito)
    private static void guardarPaisMIOOS(File f, Pais pais) {
        try {
            // Creo el flujo de datos binarios al fichero y pongo el append true para añadir datos
            FileOutputStream fos = new FileOutputStream(f, true);
            // Utilizamos nuestro MOOS para que no añada cabecera al fichero al añadir objetos
            MiObjectOutputStream02 moos = new MiObjectOutputStream02(fos);
            // Ahora hay que escribir los objetos
            moos.writeObject(pais);
            // CERRAMOS FLUJOS DE DATOS (binarios y de objetos)
            moos.close();
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // buscarPais
    private static Pais buscarPais(File f, String nombrePais) {
        Pais resultado = null;
        try {
            // 1. CREAR FLUJO DE LECTURA DE DATOS BINARIOS DESDE EL FICHERO
            FileInputStream fis = new FileInputStream(f);
            // 2. CREAR FLUJO DE LECTURA DE OBJETOS DESDE EL FICHERO
            ObjectInputStream ois = new ObjectInputStream(fis);
            // 3. OBJETOS PAIS (Si son iguales saco el país, si no sigo buscando)
            Pais auxiliar;

            // 4. Bucle infinito hasta que la excepción nos expulse (cuando no quede nada que leer en el fichero)
            while (true) {
                auxiliar = (Pais) ois.readObject();
                // COMPARAR SI EL NOMBRE QUE ME HAN PASADO ES EL MISMO DEL PAIS AUXILIAR
                if (auxiliar.getPais().equalsIgnoreCase(nombrePais)){
                    System.out.println("La capital es: " + auxiliar.getCapital());
                    return auxiliar;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");
        } catch (IOException e) {
            System.out.println("Fin del fichero");
        } catch (ClassNotFoundException e) {
            System.out.println("La clase no existe");
        }
        // Si no encuentras return resultado (null)
        return resultado;
    }
}
