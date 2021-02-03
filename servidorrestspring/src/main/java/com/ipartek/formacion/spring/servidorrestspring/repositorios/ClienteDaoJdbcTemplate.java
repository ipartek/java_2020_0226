package com.ipartek.formacion.spring.servidorrestspring.repositorios;

import java.sql.PreparedStatement;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.ipartek.formacion.spring.servidorrestspring.entidades.Cliente;

public class ClienteDaoJdbcTemplate implements Dao<Cliente> {

	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public Iterable<Cliente> obtenerTodos() {
		return jdbc.query("SELECT * FROM clientes", new BeanPropertyRowMapper<Cliente>(Cliente.class));
	}

	@Override
	public Cliente obtenerPorId(Long id) {
		return jdbc.queryForObject("SELECT * FROM clientes WHERE id = ?", new BeanPropertyRowMapper<Cliente>(Cliente.class), id);
	}

	@Override
	public Cliente insertar(Cliente cliente) {
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbc.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(
					"INSERT INTO clientes (nombre, apellidos) VALUES (?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getApellidos());
			
			return ps;
		}, keyHolder);

		cliente.setId(keyHolder.getKey().longValue());

		return cliente;
	}

	@Override
	public Cliente modificar(Cliente cliente) {
		jdbc.update("UPDATE clientes SET nombre = ?, apellidos = ? WHERE id = ?", cliente.getNombre(), cliente.getApellidos(), cliente.getId());
		return cliente;
	}

	@Override
	public void borrar(Long id) {
		jdbc.update("DELETE FROM clientes WHERE id = ?", id);
	}

}
