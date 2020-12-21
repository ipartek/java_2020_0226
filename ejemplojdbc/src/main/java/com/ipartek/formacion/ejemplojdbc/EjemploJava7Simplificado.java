package com.ipartek.formacion.ejemplojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EjemploJava7Simplificado {

	public static void main(String[] args) {
		final String URL = "jdbc:mysql://localhost:3306/supermercado?serverTimezone=UTC";
		final String USER = "root";
		final String PASS = "admin";

		final String SQL_SELECT = "SELECT * FROM usuarios";

		try (// try-with-resources
		 Connection con = DriverManager.getConnection(URL, USER, PASS);
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(SQL_SELECT)) {
			System.out.println(SQL_SELECT);

			while (rs.next()) {
				System.out.println(rs.getLong("id") + ", " + rs.getString("email") + ", " + rs.getString("password"));
			}
		} catch (SQLException e) {
			System.out.println("Ha habido un error en la SELECT: " + e.getMessage());
		}
	}
}
