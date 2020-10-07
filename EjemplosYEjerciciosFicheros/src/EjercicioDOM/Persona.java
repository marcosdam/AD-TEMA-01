package EjercicioDOM;

import java.io.Serializable;

public class Persona implements Serializable {
    private String name;
    private int edad;

    public Persona() {
    }

    public Persona(String name, int edad) {
        this.name = name;
        this.edad = edad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Nombre: " + name + " Edad: " + edad + "\n";
    }
}
