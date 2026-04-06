package validaregistro.modelo.procesos;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SerializeImpl<T> implements Serializar<T> {

    @Override
    public void guardaObjeto(T objeto, File archivo) {

    }

    @Override
    public T leeObjeto(File archivo) throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (T) ois.readObject();
        } catch (IOException ioe) {
            System.out.println("Error al leer el objeto");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error al leer el objeto");
        }
    }
}
