package validaregistro.controlador;

import validaregistro.modelo.beans.Solicitud;
import validaregistro.modelo.procesos.GestorRegistros;
import validaregistro.vista.Vista;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Programa {
    public void ejecutar() throws IOException {
        Vista vista = new Vista();
        GestorRegistros gestorRegistros = new GestorRegistros();
        HashMap<String, Solicitud> todasLasSolicitudes;
        HashMap<String, Solicitud> solicitudesValidas;
        String nombreArchivo1;
        String nombreArchivo2;
        File archivo1;
        File archivo2;

        nombreArchivo1 = vista.pedirNombreArchivo("Ingrese el nombre del archivo a leer: ");
        archivo1 = new File(nombreArchivo1);
        nombreArchivo2 = vista.pedirNombreArchivo("Ingrese el nombre del archivo a escribir: ");
        archivo2 = new File(nombreArchivo2);
        todasLasSolicitudes = gestorRegistros.leerSolicitudes(archivo1);
        vista.mostrarSolicitudes(todasLasSolicitudes);

        solicitudesValidas = gestorRegistros.filtrarValidas(todasLasSolicitudes);
        vista.mostrarSolicitudes(solicitudesValidas);
        gestorRegistros.almacenarArchivo(archivo2, solicitudesValidas);
    }
}
