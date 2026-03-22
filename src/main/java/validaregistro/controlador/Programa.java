package validaregistro.controlador;

import validaregistro.modelo.Solicitud;
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
        String nombreArchivo;
        File archivo;

        nombreArchivo = vista.pedirNombreArchivo();
        archivo = new File(nombreArchivo);
        todasLasSolicitudes = gestorRegistros.leerSolicitudes(archivo);
        vista.mostrarSolicitudes(todasLasSolicitudes);

        solicitudesValidas = gestorRegistros.filtrarValidas(todasLasSolicitudes);
        vista.mostrarSolicitudes(solicitudesValidas);
    }
}
