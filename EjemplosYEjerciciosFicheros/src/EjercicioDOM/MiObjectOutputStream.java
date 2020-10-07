package EjercicioDOM;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MiObjectOutputStream extends ObjectOutputStream {
    public MiObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    protected MiObjectOutputStream() throws IOException, SecurityException {
    }

    // sobreescribir header -> Borrar -> super.writeStreamHeader();
    @Override
    protected void writeStreamHeader() throws IOException {
    }
}
