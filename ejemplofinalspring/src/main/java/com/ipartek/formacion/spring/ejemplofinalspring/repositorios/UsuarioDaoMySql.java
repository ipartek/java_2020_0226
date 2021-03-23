package com.ipartek.formacion.spring.ejemplofinalspring.repositorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.spring.ejemplofinalspring.entidades.Cliente;
import com.ipartek.formacion.spring.ejemplofinalspring.entidades.Usuario;

@Repository
class UsuarioDaoMySql implements DaoUsuario {

	private static final String SQL_EMAIL = "SELECT * FROM usuarios u LEFT JOIN clientes c ON u.clientes_id = c.id WHERE email = ?";
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public Usuario obtenerPorEmail(String email) {
		try (Connection con = dataSource.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_EMAIL)) {
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			
			Usuario usuario = null;
			Cliente cliente = null;
			
			if(rs.next()) {
				cliente = new Cliente(rs.getLong("c.id"), rs.getString("c.nombre"), rs.getString("c.apellidos"), rs.getString("c.cif"), rs.getDate("c.fecha_nacimiento").toLocalDate(), null);
				usuario = new Usuario(rs.getLong("u.id"), rs.getString("u.email"), rs.getString("u.password"), cliente);
			}
			
			return usuario;
		} catch (Exception e) {
			throw new AccesoDatosException("No ha podido obtener el usuario por su email: " + email, e);
		}
	}

}
