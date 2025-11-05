package ej7;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;


/**
 * Ejercicio 7:
Simula un “pipe” (ej. echo 'hola mundo' | wc -w).
Crea dos procesos y conecta la salida del primero con la entrada del segundo desde Java.
 */
//"bash", "-lc" -- >Ejecuta este comando dentro de un intérprete de Bash como si fuera una línea escrita en la terminal.”
public class Pipe {
    public static void main(String[] args) {
        try {
            // 1. Crear archivo temporal para simular la tubería
            File tmp = File.createTempFile("pipe", ".txt");

            // 2. Proceso 1: genera "hola mundo" y lo escribe en el archivo
            ProcessBuilder pb1 = new ProcessBuilder("bash", "-lc", "echo 'hola mundo test'");
            pb1.redirectOutput(tmp);  // salida a archivo
            pb1.start().waitFor();

            // 3. Proceso 2: lee del archivo (simulando stdin) y cuenta palabras
            ProcessBuilder pb2 = new ProcessBuilder("bash", "-lc", "wc -w");
            pb2.redirectInput(tmp);   // entrada desde archivo
            Process p2 = pb2.start();

            // 4. Leer resultado
            String output = new String(p2.getInputStream().readAllBytes(), StandardCharsets.UTF_8).trim();
            p2.waitFor();

            System.out.println("Resultado: " + output); // -> 2

            // 5. Borrar el temporal
            Files.deleteIfExists(tmp.toPath());

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}

