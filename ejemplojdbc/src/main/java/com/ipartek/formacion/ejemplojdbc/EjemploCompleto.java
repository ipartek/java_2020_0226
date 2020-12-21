package com.ipartek.formacion.ejemplojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EjemploCompleto {

	public static void main(String[] args) {
		final String URL = "jdbc:mysql://localhost:3306/supermercado?serverTimezone=UTC";
		final String USER = "root";
		final String PASS = "admin";

		final String SQL_SELECT = "SELECT * FROM usuarios";

		Connection con = null;

		try {
			con = DriverManager.getConnection(URL, USER, PASS);

			System.out.println("Conexión establecida");

			Statement s = null;

			try {
				s = con.createStatement();

				ResultSet rs = null;

				try {
					rs = s.executeQuery(SQL_SELECT);

					System.out.println(SQL_SELECT);

					while (rs.next()) {
						System.out.println(
								rs.getLong("id") + ", " + rs.getString("email") + ", " + rs.getString("password"));
					}
				} catch (SQLException e) {
					System.out.println("No se ha generado el conjunto de resultados: " + e.getMessage());
				} finally {
					if (rs != null) {
						try {
							rs.close();
						} catch (SQLException e) {
							System.out.println("Error al cerrar el conjunto de resultados" + e.getMessage());
						}
					}
				}
			} catch (SQLException e) {
				System.out.println("No se ha podido crear la sentencia: " + e.getMessage());
			} finally {
				if (s != null) {
					try {
						s.close();
					} catch (SQLException e) {
						System.out.println("Error al cerrar la sentencia: " + e.getMessage());
					}
				}
			}
		} catch (SQLException e) {
			System.out.println("Ha habido un error en la conexión: " + e.getMessage());
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println("Cierre de conexión erróneo: " + e.getMessage());
				}
			}
		}

	}

}
