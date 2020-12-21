package com.ipartek.formacion.ejemplojdbc;

import java.sql.*;

// JDBC: Java Data Base Conectivity

public class App {
	public static void main(String[] args) throws SQLException {
		final String URL = "jdbc:mysql://localhost:3306/supermercado?serverTimezone=UTC";
		final String USER = "root";
		final String PASS = "admin";

		final String SQL_SELECT = "SELECT * FROM usuarios";
		final String SQL_SELECT_ID = "SELECT * FROM usuarios WHERE id = ?";

		final String SQL_INSERT = "INSERT INTO `supermercado`.`usuarios` (email, password) VALUES (?, ?)";
		final String SQL_UPDATE = "UPDATE usuarios SET email = ?, password = ? WHERE id = ?";
		final String SQL_DELETE = "DELETE FROM usuarios WHERE id = ?";

		Connection con = DriverManager.getConnection(URL, USER, PASS);

		System.out.println("Conexión establecida");

		// SELECT

		Statement s = con.createStatement();

		ResultSet rs = s.executeQuery(SQL_SELECT);

		System.out.println(SQL_SELECT);

		while (rs.next()) {
			System.out.println(rs.getLong("id") + ", " + rs.getString("email") + ", " + rs.getString("password"));
		}

		// SELECT POR ID

		Long id = 2L;

		PreparedStatement ps = con.prepareStatement(SQL_SELECT_ID);

		ps.setLong(1, id);

		rs = ps.executeQuery();

		System.out.println(SQL_SELECT_ID);

		while (rs.next()) {
			System.out.println(rs.getLong("id") + ", " + rs.getString("email") + ", " + rs.getString("password"));
		}

		// INSERT

		String email = "nuevo3@nuevez.com";
		String pass = "nuevo3";

		ps = con.prepareStatement(SQL_INSERT);

		ps.setString(1, email);
		ps.setString(2, pass);

		int numeroRegistrosAfectados = ps.executeUpdate();

		System.out.println(SQL_INSERT);

		System.out.println(numeroRegistrosAfectados);

		// UPDATE

		email = "pepe@perez.com";
		pass = "pepe";
		id = 2L;

		ps = con.prepareStatement(SQL_UPDATE);

		ps.setString(1, email);
		ps.setString(2, pass);
		ps.setLong(3, id);

		numeroRegistrosAfectados = ps.executeUpdate();

		System.out.println(SQL_UPDATE);

		System.out.println(numeroRegistrosAfectados);
		
		// DELETE
		
		id = 6L;
		
		ps = con.prepareStatement(SQL_DELETE);

		ps.setLong(1, id);

		numeroRegistrosAfectados = ps.executeUpdate();

		System.out.println(SQL_DELETE);

		System.out.println(numeroRegistrosAfectados);
	}
}
