package com.ipartek.formacion.usuarioservlets.accesodatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.ipartek.formacion.usuarioservlets.entidades.Rol;
import com.ipartek.formacion.usuarioservlets.entidades.Usuario;

public class UsuarioDaoMySql implements UsuarioDao {

	private static final String SQL_SELECT = "SELECT u.id u_id, email, password, r.id r_id, nombre r_nombre, descripcion r_descripcion FROM usuarios u JOIN roles r ON u.roles_id = r.id";
	private static final String SQL_SELECT_EMAIL = SQL_SELECT + " WHERE email = ?";
	private static final String SQL_DELETE = "DELETE FROM usuarios WHERE id = ?";
	private static final String SQL_SELECT_ID = SQL_SELECT + " WHERE u.id = ?";
	
	private DataSource dataSource = null;

	public UsuarioDaoMySql() {
		try {
			InitialContext initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			dataSource = (DataSource) envCtx.lookup("jdbc/usuarioservlets");
		} catch (NamingException e) {
			throw new AccesoDatosException("No se ha encontrado el JNDI de usuarioservlets", e);
		}
	}

	@Override
	public Iterable<Usuario> obtenerTodos() {
		try (Connection con = dataSource.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(SQL_SELECT)) {
			ArrayList<Usuario> usuarios = new ArrayList<>();
			Usuario usuario;
			Rol rol;

			while (rs.next()) {
				rol = new Rol(rs.getLong("r_id"), rs.getString("r_nombre"), rs.getString("r_descripcion"));
				usuario = new Usuario(rs.getLong("u_id"), rs.getString("email"), rs.getString("password"), rol);

				usuarios.add(usuario);
			}

			return usuarios;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se han podido obtener todos los registros de usuarios", e);
		} catch (Exception e) {
			throw new AccesoDatosException(
					"ERROR NO ESPERADO: No se han podido obtener todos los registros de usuarios", e);
		}
	}

	@Override
	public Usuario obtenerPorId(Long id) {
		try (Connection con = dataSource.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_SELECT_ID);
				) {
			
			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			Usuario usuario = null;
			Rol rol;

			if (rs.next()) {
				rol = new Rol(rs.getLong("r_id"), rs.getString("r_nombre"), rs.getString("r_descripcion"));
				usuario = new Usuario(rs.getLong("u_id"), rs.getString("email"), rs.getString("password"), rol);
			}

			return usuario;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener el usuario " + id, e);
		} catch (Exception e) {
			throw new AccesoDatosException(
					"ERROR NO ESPERADO: No se ha podido obtener el usuario " + id, e);
		}
	}

	@Override
	public Usuario insertar(Usuario t) {
		// TODO Auto-generated method stub
		return UsuarioDao.super.insertar(t);
	}

	@Override
	public Usuario modificar(Usuario t) {
		// TODO Auto-generated method stub
		return UsuarioDao.super.modificar(t);
	}

	@Override
	public void borrar(Long id) {
		try (Connection con = dataSource.getConnection(); PreparedStatement pst = con.prepareStatement(SQL_DELETE);) {

			pst.setLong(1, id);

			if (pst.executeUpdate() != 1) {
				throw new AccesoDatosException("No se ha encontrado el registro a borrar: " + id);
			}

		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido borrar el usuario: " + id, e);
		} catch (Exception e) {
			throw new AccesoDatosException("ERROR NO ESPERADO: No se ha podido borrar el usuario: " + id, e);
		}
	}

	@Override
	public Usuario obtenerPorEmail(String email) {
		try (Connection con = dataSource.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_EMAIL);) {

			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();

			Usuario usuario = null;
			Rol rol;

			if (rs.next()) {
				rol = new Rol(rs.getLong("r_id"), rs.getString("r_nombre"), rs.getString("r_descripcion"));
				usuario = new Usuario(rs.getLong("u_id"), rs.getString("email"), rs.getString("password"), rol);
			}

			return usuario;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido obtener el usuario cuyo email es: " + email, e);
		} catch (Exception e) {
			throw new AccesoDatosException(
					"ERROR NO ESPERADO: No se ha podido obtener el usuario cuyo email es: " + email, e);
		}
	}

}
