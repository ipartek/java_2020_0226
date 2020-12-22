package com.ipartek.formacion.excepciones;

public class PuntoPrueba {

	public static void main(String[] args) throws Exception {
		try {
			String s = null;
			
			System.out.println(s.toUpperCase());
			
			Punto p = new Punto(-5, 6);
		} catch (PuntoException e) {
			System.out.println("Error al construir el punto: " + e.getMessage());
		} catch(Exception e) {
			System.out.println("Error genérico: " + e.getMessage());
		}
	}

}
