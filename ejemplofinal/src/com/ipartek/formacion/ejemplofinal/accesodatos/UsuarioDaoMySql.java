package com.ipartek.formacion.ejemplofinal.accesodatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

import com.ipartek.formacion.ejemplofinal.entidades.Cliente;
import com.ipartek.formacion.ejemplofinal.entidades.Usuario;

public class UsuarioDaoMySql implements DaoUsuario {

	private static final String SQL_EMAIL = "SELECT * FROM usuarios u LEFT JOIN clientes c ON u.clientes_id = c.id WHERE email = ?";

	@Override
	public Usuario obtenerPorEmail(String email) {
		try (Connection con = Config.dataSource.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_EMAIL)) {
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			
			Usuario usuario = null;
			Cliente cliente = null;
			
			if(rs.next()) {
				cliente = new Cliente(rs.getLong("c.id"), rs.getString("c.nombre"), rs.getString("c.apellidos"), rs.getString("c.cif"), (LocalDate) rs.getObject("c.fecha_nacimiento"), null);
				usuario = new Usuario(rs.getLong("u.id"), rs.getString("u.email"), rs.getString("u.password"), cliente);
			}
			
			return usuario;
		} catch (Exception e) {
			throw new AccesoDatosException("No ha podido obtener el usuario por su email: " + email, e);
		}
	}

}
