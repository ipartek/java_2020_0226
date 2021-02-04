package com.ipartek.formacion.spring.springdatajpaunoavarios.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.spring.springdatajpaunoavarios.entidades.Categoria;
import com.ipartek.formacion.spring.springdatajpaunoavarios.entidades.Producto;

@Repository
public class ProductoDaoJdbcTemplate implements Dao<Producto> {

	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public Iterable<Producto> obtenerTodos() {
		return jdbc.query("SELECT * \r\n"
				+ "FROM productos p\r\n"
				+ "LEFT JOIN categorias c ON p.categoria_id = c.id\r\n", (rs, rowNum) -> 
				new Producto(rs.getLong("p.id"), rs.getString("p.nombre"), rs.getBigDecimal("p.precio"),
						new Categoria(rs.getLong("c.id"), rs.getString("c.nombre"), rs.getString("c.descripcion"))));
	}

	@Override
	public Producto obtenerPorId(Long id) {
		return jdbc.queryForObject("SELECT * \r\n"
				+ "FROM productos p\r\n"
				+ "LEFT JOIN categorias c ON p.categoria_id = c.id\r\n"
				+ "WHERE p.id = ?", (rs, rowNum) -> 
				new Producto(rs.getLong("p.id"), rs.getString("p.nombre"), rs.getBigDecimal("p.precio"),
						new Categoria(rs.getLong("c.id"), rs.getString("c.nombre"), rs.getString("c.descripcion"))), id);
	}

}
