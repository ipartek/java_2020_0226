package com.ipartek.formacion.spring.uf2177_1.bibliotecas;

import java.math.BigDecimal;
import java.util.Scanner;

public class Consola {
	private static Scanner s = new Scanner(System.in);

	// private static BufferedReader br = new BufferedReader(new
	// InputStreamReader(System.in));
	// ...br.readLine()...
	public static void pl(Object mensaje) {
		System.out.println(mensaje);
	}

	public static void p(Object mensaje) {
		System.out.print(mensaje);
	}

	public static String leerString(String dato) {
		p("Introduce " + dato + ": ");

		return s.nextLine();
	}

	public static Long leerLong(String dato) {
		p("Introduce " + dato + ": ");

		String recibido = s.nextLine();

		return Long.parseLong(recibido);
	}

	public static BigDecimal leerBigDecimal(String dato) {
		String recibido = leerString(dato);

		return new BigDecimal(recibido);
	}

	public static void mostrarErrores(Throwable e) {
		pl(e.getMessage());

		while (e.getCause() != null) {
			pl(e.getCause().getLocalizedMessage());
			e = e.getCause();
		}
	}
}
