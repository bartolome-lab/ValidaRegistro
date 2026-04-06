package validaregistro.vista;

import validaregistro.modelo.beans.Solicitud;

import java.util.HashMap;
import java.util.Scanner;

public class Vista {
    Scanner teclado = new Scanner(System.in);

    public String pedirNombreArchivo(String mensaje){
        System.out.println(mensaje);
        return teclado.nextLine();
    }

    public void mostrarSolicitudes(HashMap<String, Solicitud> solicitudes) {
        for (Solicitud solicitud : solicitudes.values()) {
            System.out.println(solicitud);
        }
    }
}
