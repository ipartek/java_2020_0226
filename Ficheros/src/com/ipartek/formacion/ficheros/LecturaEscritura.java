package com.ipartek.formacion.ficheros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;

public class LecturaEscritura {

	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("datos.txt");
		PrintWriter pw = new PrintWriter(fw);
		
		pw.println("Hola");
		pw.println("Escrito desde mi programa");
		
		pw.close();
		
		System.out.println("Escrito el fichero");
		
		FileReader fr = new FileReader("datos.txt");
		BufferedReader br = new BufferedReader(fr);
		//Scanner s = new Scanner(fr);
		
		String linea;
		
		while( (linea = br.readLine()) != null) {
			System.out.println(linea);
		}
		
		br.close();
		
		String contents = new String(Files.readAllBytes(FileSystems.getDefault().getPath("datos.txt")), StandardCharsets.UTF_8);
		
		System.out.println(contents);
		
		fw = new FileWriter("datoscopia.txt");
		fw.write(contents);
		fw.close();
		
		System.out.println("Copiado");
	}

}
