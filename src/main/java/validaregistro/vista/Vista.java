package validaregistro.vista;

import validaregistro.modelo.Solicitud;

import java.util.HashMap;
import java.util.Scanner;

public class Vista {
    Scanner teclado = new Scanner(System.in);

    public String pedirNombreArchivo1(){
        System.out.println("Ingrese el nombre del archivo a leer: ");
        return teclado.nextLine();
    }

    public void mostrarSolicitudes(HashMap<String, Solicitud> solicitudes) {
        for (Solicitud solicitud : solicitudes.values()) {
            System.out.println(solicitud);
        }
    }

    public String pedirNombreArchivo2() {
        System.out.println("Ingrese el nombre del archivo a escribir: ");
        return teclado.nextLine();
    }
}
