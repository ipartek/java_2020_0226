package com.ipartek.formacion.usuarioservlets.accesodatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.ipartek.formacion.usuarioservlets.entidades.Rol;

public class RolDaoMySql implements Dao<Rol> {

	private static final String SQL_SELECT = "SELECT id, nombre, descripcion FROM roles";
	private DataSource dataSource = null;
	
	public RolDaoMySql() {
		try {
			InitialContext initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			dataSource = (DataSource) envCtx.lookup("jdbc/usuarioservlets");
		} catch (NamingException e) {
			throw new AccesoDatosException("No se ha encontrado el JNDI de usuarioservlets", e);
		}
	}

	@Override
	public Iterable<Rol> obtenerTodos() {
		try (Connection con = dataSource.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(SQL_SELECT)) {
			ArrayList<Rol> roles = new ArrayList<>();
			Rol rol;

			while (rs.next()) {
				rol = new Rol(rs.getLong("id"), rs.getString("nombre"), rs.getString("descripcion"));
				roles.add(rol);
			}

			return roles;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se han podido obtener todos los registros de roles");
		} catch (Exception e) {
			throw new AccesoDatosException(
					"ERROR NO ESPERADO: No se han podido obtener todos los registros de roles");
		}
	}

}
