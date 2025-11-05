package ej9;

import java.io.File;

/*
 * Ejecuta 'cat /etc/passwds' guardando la salida en salida.txt y los errores en errores.txt.

 */
public class Fichero {
	public static void main(String [] args) {
		ProcessBuilder pb = new ProcessBuilder("cat", "/etc/passwd");
		pb.redirectOutput(new File("salida.txt"));
		pb.redirectError(new File("error.txt"));
		
		try {
			Process p = pb.start();
			p.waitFor();
			System.out.println("Finalizado");
		}catch(Exception ex) {
			
		}
		
	}
}