package Ejercicios;

import java.io.Serializable;

public class Pais implements Serializable {
    private String pais;
    private String capital;

    public Pais(String pais, String capital) {
        this.pais = pais;
        this.capital = capital;
    }

    public Pais() {
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    @Override
    public String toString() {
        return "País: " + pais + ", Capital: " + capital;
    }
}
