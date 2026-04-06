package validaregistro.modelo.procesos;

import validaregistro.modelo.beans.Solicitud;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class GestorRegistros {

    private HashMap<String, Solicitud> solicitudesValidas;
    private ArrayList<String> solicitudesNoValidas;

    public GestorRegistros() {
        solicitudesValidas = new HashMap<>();
        solicitudesNoValidas = new ArrayList<>();
    }

    public HashMap<String, Solicitud> leerSolicitudes(File archivo) throws FileNotFoundException, IOException {
        HashMap<String, Solicitud> solicitudes = new HashMap<>();
        BufferedReader br = null;

        String linea;
        String[] partes;

        if (archivo.exists()) {
            if (archivo.canRead()) {
                try {
                    br = new BufferedReader(new FileReader(archivo));
                    while ((linea = br.readLine()) != null) {
                        partes = linea.split(":");
                        if (partes.length == 5) {
                            Solicitud solicitud = new Solicitud(partes[0], partes[1], partes[2], partes[3], partes[4]);
                            solicitudes.putIfAbsent(solicitud.getLogin(), solicitud);
                        } else {
                            solicitudesNoValidas.add(linea);
                        }
                    }
                } catch (FileNotFoundException fnfe) {
                    System.out.println("Archivo no encontrado.");
                } catch (IOException ioe) {
                    System.out.println("Error en el archivo.");
                } finally {
                    if (br != null) {
                        br.close();
                    }
                }
            } else {
                System.out.println("No puede leerse el archivo.");
            }
        } else {
            System.out.println("No existe el archivo a leer.");
        }
        return solicitudes;
    }

    public HashMap<String, Solicitud> filtrarValidas(HashMap<String, Solicitud> solicitudes) {
        HashMap<String, Solicitud> solicitudesValidas = new HashMap<>();

        if (solicitudes != null) {
            for (Solicitud solicitud : solicitudes.values()) {
                if (solicitud.esValida() && !solicitudesValidas.containsKey(solicitud)) {
                    solicitudesValidas.put(solicitud.getLogin(), solicitud);
                } else {
                    this.solicitudesNoValidas.add(solicitud.toFormat());
                }
            }
        }
        return solicitudesValidas;
    }

    public void almacenarArchivo(File archivo, HashMap<String, Solicitud> solicitudesValidas) throws IOException {
        PrintWriter pw = null;

        if (archivo.exists() && archivo.canWrite()) {
            try {
                pw = new PrintWriter(new FileWriter(archivo, true));
                if (solicitudesValidas != null) {
                    for (Solicitud solicitud : solicitudesValidas.values()) {
                        pw.println(solicitud.toFormat());
                    }
                }
            } catch (IOException ioe) {
                System.out.println("Error en el archivo.");
            } finally {
                if (pw != null) {
                    pw.close();
                }
            }
        } else {
            System.out.println("El archivo donde se pretende escribir no existe.");
        }
    }

    public void almacenarSerializado(File archivo, HashMap<String, Solicitud> solicitudesValidas) throws FileNotFoundException, IOException {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(archivo));
            oos.writeObject(solicitudesValidas);
        } catch (FileNotFoundException fnfe) {
            System.out.println("Archivo no encontrado.");
        } catch (IOException ioe) {
            System.out.println("Error en el archivo.");
        } finally {
            if (oos != null) {
                oos.close();
            }
        }
    }
}
