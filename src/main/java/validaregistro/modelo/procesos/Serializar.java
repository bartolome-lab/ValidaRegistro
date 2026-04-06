package validaregistro.modelo.procesos;

import java.io.File;
import java.io.IOException;

public interface Serializar<T> {
    public void guardaObjeto(T objeto, File archivo) throws IOException;
    public T leeObjeto(File archivo) throws  IOException;
}
