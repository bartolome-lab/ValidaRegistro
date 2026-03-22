package validaregistro.vista;

import validaregistro.modelo.Solicitud;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Vista {
    Scanner teclado = new Scanner(System.in);

    public String pedirNombreArchivo(){
        System.out.println("Ingrese el nombre del archivo: ");
        return teclado.nextLine();
    }

    public void mostrarSolicitudes(HashMap<String, Solicitud> solicitudes) {
        for (Solicitud solicitud : solicitudes.values()) {
            System.out.println(solicitud);
        }
    }
}
