package ej7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Pipe {
public static void main(String[] args) {
	try {
		ProcessBuilder pb1 = new ProcessBuilder("echo", "Hola");
		Process proceso1 = pb1.start();
		ProcessBuilder pb2 = new ProcessBuilder("grep", "test");
		Process proceso2 = pb2.start();
		
		try(
				InputStream salidaProceso1 = proceso1.getInputStream();
				OutputStream entradaProceso2 = proceso2.getOutputStream();
				){
			salidaProceso1.transferTo(entradaProceso2);
		}
		try(BufferedReader reader = new BufferedReader
				(
						new InputStreamReader(proceso2.getInputStream())));
				String linea;
				while((linea = reader.readLine() != null)) {
					System.out.println("Resultado" + linea);
				}
	proceso1.waitFor();
	proceso2.waitFor();
		
	}catch(IOException | InterruptedException e) {
		e.printStackTrace();
	}
	
}
}
