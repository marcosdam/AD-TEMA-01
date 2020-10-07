package Ejercicios;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MiObjectOutputStream02 extends ObjectOutputStream {
    public MiObjectOutputStream02(OutputStream out) throws IOException {
        super(out);
    }

    protected MiObjectOutputStream02() throws IOException, SecurityException {
    }

    // sobreescribir header -> Borrar -> super.writeStreamHeader();
    @Override
    protected void writeStreamHeader() throws IOException {
    }
}
