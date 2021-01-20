package com.ipartek.formacion.holamundocomplejo;

import java.util.Scanner;

public class ProveedorMensajesConsola implements ProveedorMensajes {

	@Override
	public String getMensaje() {
		System.out.print("Introduce el mensaje: ");
		String mensaje;
		try (Scanner s = new Scanner(System.in)) {
			mensaje = s.nextLine();
			return mensaje;
		}
	}
	
}
