package Ejercicios;

import java.io.*;

public class Ej02 {
    public static void main(String[] args) {
        /* 2. Se pide al desarrollador que implemente la clase EstadoPartida y los tres métodos siguientes de la aplicación:
        // Guardará la partida por primera vez con ObjectOutputStream
        -void guardarPartida(File f, EstadoPartida objEP)
        // Guardará la partida si el archivo existe
        -void guardarPartidaMIOOS(File f, EstadoPartida objEP)
        // Dado el nombre de un jugador nos devolverá su objeto EstadoPartida asociado
        -EstadoPartida recuperarPartida(File f, String jugador)
        El main deberá crear 3 objetos EstadoPartida para luego guardarlos en un fichero mediante guardarPartida
        y posteriormente buscar un jugador usando recuperarPartida. */

        // 1. Creamos 3 objetos
        EstadoPartida[] misPartidas =
                {new EstadoPartida(10, 2, "Paco"),
                        new EstadoPartida(8, 3, "Miguel"),
                        new EstadoPartida(7, 5, "Laura")};

        // 2. Declaramos el fichero
        File f = new File("EJ02.dat");

        // 3. POR CADA OBJETO objEP EN MISPARTIDAS LO ESCRIBIMOS EN EL FICHERO (oos.write)
        for (EstadoPartida ep:misPartidas) {
            // Si el fichero existe utilizo mi propia función para añadir objetos sin cabecera
            if (f.exists())
                guardarPartidaMIOOS(f, ep);
            else
                guardarPartida(f, ep);
        }

        // 4. PEDIR NOMBRE DEL JUGADOR PARA RECUPERAR PARTIDA (br en lugar de Scanner)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Escribe el nombre del jugador y pulsa Enter");
            String nombre = br.readLine();
            EstadoPartida buscado = recuperarPartida(f, nombre);
            if(buscado != null){
                System.out.println("La partida es: ");
                System.out.println(buscado.toString());
            }else {
                System.out.println("Jugador sin partidas");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // guardarPartida
    private static void guardarPartida(File f, EstadoPartida ep){
        try {
            // 1. DEFINIR FLUJO DE DATOS (FOS para binarios Y OOS para objetos)
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            // 2. ESCRIBIR OBJETO
            oos.writeObject(ep);
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
    private static void guardarPartidaMIOOS(File f, EstadoPartida ep){
        try {
            // Creo el flujo de datos binarios al fichero y pongo el append true para añadir datos
            FileOutputStream fos = new FileOutputStream(f, true);

            // Utilizamos nuestro MOOS para que no añada cabecera al fichero al añadir objetos
            MiObjectOutputStream02 moos = new MiObjectOutputStream02(fos);

            // Ahora hay que escribir los objetos
            moos.writeObject(ep);

            // CERRAMOS FLUJOS DE DATOS (binarios y de objetos)
            moos.close();
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // recuperarPartida
    private static EstadoPartida recuperarPartida(File f, String jugador){
        EstadoPartida resultado = null;
        try {
            // 1. CREAR FLUJO DE LECTURA DE DATOS BINARIOS DESDE EL FICHERO
            FileInputStream fis = new FileInputStream(f);
            // 2. CREAR FLUJO DE LECTURA DE OBJETOS DESDE EL FICHERO
            ObjectInputStream ois = new ObjectInputStream(fis);
            // 3. OBJETOS ESTADOPARTIDA (Si son iguales saco la partida, si no sigo buscando)
            EstadoPartida auxiliar;

            // 4. Bucle infinito hasta que la excepción nos expulse (cuando no quede nada que leer en el fichero)
            while(true){
                auxiliar = (EstadoPartida) ois.readObject();
                // COMPARAR SI EL NOMBRE QUE ME HAN PASADO ES EL MISMO DE LA PARTIDA AUXILIAR
                if(auxiliar.getNombre().equalsIgnoreCase(jugador))
                    return auxiliar;
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
