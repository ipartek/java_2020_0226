package com.ipartek.formacion.ejemplojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EjemploCompletoJava7 {

	public static void main(String[] args) {
		final String URL = "jdbc:mysql://localhost:3306/supermercado?serverTimezone=UTC";
		final String USER = "root";
		final String PASS = "admin";

		final String SQL_SELECT = "SELECT * FROM usuarios";

		// try-with-resources
		try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {

			System.out.println("Conexión establecida");

			try (Statement s = con.createStatement()) {

				try (ResultSet rs = s.executeQuery(SQL_SELECT)) {
					System.out.println(SQL_SELECT);

					while (rs.next()) {
						System.out.println(
								rs.getLong("id") + ", " + rs.getString("email") + ", " + rs.getString("password"));
					}
				} catch (SQLException e) {
					System.out.println("No se ha generado el conjunto de resultados: " + e.getMessage());
				}
			} catch (SQLException e) {
				System.out.println("No se ha podido crear la sentencia: " + e.getMessage());
			}
		} catch (SQLException e) {
			System.out.println("Ha habido un error en la conexión: " + e.getMessage());
		}

	}

}
