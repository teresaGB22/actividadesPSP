package ej1;

import java.io.IOException;

/**
 * Crea un programa que ejecute echo con un mensaje 
 * y verifica que el proceso termina con código 0.
 */
public class Echo {
	
	public static void main(String [] argumentos) {
		try {
			//
			String nombre = "Teresa";
			ProcessBuilder pb = new ProcessBuilder("echo", "hola, $nombre");
			Process proceso = pb.start();
			int codigo = proceso.waitFor();
			
			if(codigo == 0) {
				System.out.println("Todo fue correcto");
			}
		}catch(Exception ex) {
			System.err.println(ex);
		}
			
	
	}

}
