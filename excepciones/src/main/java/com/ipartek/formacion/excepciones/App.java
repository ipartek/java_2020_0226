package com.ipartek.formacion.excepciones;

public class App {
	public static void main(String[] args) {
		int a = 5, b = 0, div;

		System.out.println("Inicio");
		
		try {
			String s = null;
			
			System.out.println(s.toUpperCase());
			
			div = a / b;
			
			System.out.println(div);
		} catch (ArithmeticException e) {
			System.out.println("No se ha podido efectuar la división: " + e.getMessage());
		} 
//		catch (Exception e) {
//			System.out.println("Error no esperado: " + e.getMessage());
//		} 
		finally {
			System.out.println("Me ejecuto por narices");
		}
		
		System.out.println("Fin");
	}
}
