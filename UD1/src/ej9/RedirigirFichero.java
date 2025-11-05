package ej9;

import java.io.File;
import java.io.IOException;

public class RedirigirFichero {

    public static void main(String[] args) {

        // Creamos el ProcessBuilder para ejecutar 'dmesg'
    //	ProcessBuilder pb = new ProcessBuilder("cat", "/var/log/syslog");
    	ProcessBuilder pb = new ProcessBuilder("cat", "/etc/passwd");

        // Redirigimos la salida estándar a "salida.txt"
        pb.redirectOutput(new File("salida.txt"));

        // Redirigimos la salida de errores a "errores.txt"
        pb.redirectError(new File("errores.txt"));

        try {
            // Lanzamos el proceso
            Process p = pb.start();

            // Esperamos a que termine
            p.waitFor();

            System.out.println("Proceso terminado. Revisa salida.txt y errores.txt");

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}