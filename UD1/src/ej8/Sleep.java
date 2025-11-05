package ej8;

import java.util.concurrent.TimeUnit;
import java.io.IOException;

/**
 * 
Ejercicio 8:
- Tiempo máximo de espera y cancelación.
- Ejecuta sleep 10 y finalízalo si tarda más de 2 segundos.
- Indicaciones para resolverlo
         Usa 
         p.waitFor(2, TimeUnit.SECONDS); 
               si devuelve false, llama a p.destroy() o destroyForcibly().
 */
public class Sleep {
	   public static void main(String[] args) {
	        // Crear ProcessBuilder con el comando sleep 10 (Linux/macOS)
	        ProcessBuilder pb = new ProcessBuilder("sleep", "10");

	        try {
	            // Iniciar el proceso
	            Process p = pb.start();

	            // Esperar un máximo de 2 segundos a que termine el proceso
	            boolean terminado = p.waitFor(2, TimeUnit.SECONDS);

	            if (!terminado) {
	                // Si no ha terminado, se finaliza
	                System.out.println("El proceso tarda demasiado. Se cancela.");
	                p.destroy(); // O p.destroyForcibly() si queremos forzar
	            } else {
	                System.out.println("El proceso terminó correctamente.");
	            }

	        } catch (IOException e) {
	            System.err.println("Error al iniciar el proceso: " + e.getMessage());
	        } catch (InterruptedException e) {
	            System.err.println("El hilo principal fue interrumpido: " + e.getMessage());
	            Thread.currentThread().interrupt();
	        }
	    }
}