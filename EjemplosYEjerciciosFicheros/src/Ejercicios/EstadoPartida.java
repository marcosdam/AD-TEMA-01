package Ejercicios;

import java.io.Serializable;

public class EstadoPartida implements Serializable{
    private int vidas;
    private int pantalla;
    private String nombre;

    public EstadoPartida(int vidas, int pantalla, String nombre) {
        this.vidas = vidas;
        this.pantalla = pantalla;
        this.nombre = nombre;
    }

    public EstadoPartida() {
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public int getPantalla() {
        return pantalla;
    }

    public void setPantalla(int pantalla) {
        this.pantalla = pantalla;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Vidas: " +  this.vidas + ", Pantalla actual: " + this.pantalla + ", Nombre: " + this.nombre;
    }
}
