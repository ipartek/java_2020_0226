package com.ipartek.formacion.spring.ejemplofinalspring.repositorios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.spring.ejemplofinalspring.entidades.Cliente;

import lombok.extern.java.Log;

@Repository
@Log
class ClienteDaoMySql implements Dao<Cliente> {
	
	private static final String SQL_INSERT = "INSERT INTO clientes (nombre, apellidos, cif, fecha_nacimiento) VALUES (?, ?, ?, ?)";

	@Autowired
	private DataSource dataSource;
	
	@Override
	public Cliente insertar(Cliente cliente) {
		try (Connection con = dataSource.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
				) {
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getApellidos());
			ps.setString(3, cliente.getCif());
			ps.setObject(4, cliente.getFechaNacimiento());
			
			int num = ps.executeUpdate();
			
			if(num != 1) {
				throw new AccesoDatosException("Ha habido una incidencia en la inserción de cliente: " + num);
			}
			
			ResultSet rs = ps.getGeneratedKeys();
			
			rs.next();
			
			cliente.setId(rs.getLong(1));
			
			log.info(cliente.toString());
			
			return cliente;
		} catch (Exception e) {
			throw new AccesoDatosException("Error al insertar el cliente " + cliente, e);
		}
	}
	
}
