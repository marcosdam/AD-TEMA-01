package Ejemplos.LecturaEscrituraBinarios;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

// HEREDAMOS LOS MÉTODOS DE LA CLASE ObjectOutputStream

public class MiObjectOutputStream extends ObjectOutputStream {
    public MiObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    protected MiObjectOutputStream() throws IOException, SecurityException {
    }

    // SOBREESCRIBIMOS SU MÉTODO HEADER PARA QUE NO HAGA NADA
    // (para poder escribir más objetos a continuación en ficheros que ya tienen Objetos escritos en ellos,
    // ya que con Objetos no hay append como con datos simples)
    @Override
    protected void writeStreamHeader() throws IOException {
    }
}
