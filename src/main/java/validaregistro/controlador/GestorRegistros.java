package validaregistro.controlador;

import validaregistro.modelo.Solicitud;

import java.io.*;
import java.util.HashMap;

public class GestorRegistros {

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
                        Solicitud solicitud = new Solicitud(partes[0], partes[1], partes[2], partes[3], partes[4]);
                        solicitudes.put(solicitud.getLogin(), solicitud);
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
            System.out.println("No existe el archivo.");
        }
        return solicitudes;
    }

    public HashMap<String, Solicitud> filtrarValidas(HashMap<String, Solicitud> solicitudes) {
        HashMap<String, Solicitud> solicitudesValidas = new HashMap<>();

        if (solicitudes != null) {
            for (Solicitud solicitud : solicitudes.values()) {
                if (solicitud.esValida()) {
                    solicitudesValidas.put(solicitud.getLogin(), solicitud);
                }
            }
        } return solicitudesValidas;
    }

}
