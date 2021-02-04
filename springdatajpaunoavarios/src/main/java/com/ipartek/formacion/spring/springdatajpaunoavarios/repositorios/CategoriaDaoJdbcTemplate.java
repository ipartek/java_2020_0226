package com.ipartek.formacion.spring.springdatajpaunoavarios.repositorios;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.spring.springdatajpaunoavarios.entidades.Categoria;
import com.ipartek.formacion.spring.springdatajpaunoavarios.entidades.Producto;

@Repository
public class CategoriaDaoJdbcTemplate implements CategoriaDao {

	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public Iterable<Categoria> obtenerTodos() {
		return jdbc.query("SELECT * FROM categorias", new BeanPropertyRowMapper<Categoria>(Categoria.class));
	}

	@Override
	public Categoria obtenerPorId(Long id) {
		return jdbc.queryForObject("SELECT * FROM categorias WHERE id = ?", new BeanPropertyRowMapper<Categoria>(Categoria.class), id);
	}

	@Override
	public Categoria obtenerPorIdConProductos(Long id) {
		Categoria categoria = obtenerPorId(id);
		Collection<Producto> productos = jdbc.query(
				"SELECT p.id, p.nombre, p.precio FROM productos p LEFT JOIN categorias c ON c.id = p.categoria_id WHERE c.id = ?",
				new BeanPropertyRowMapper<Producto>(Producto.class), id);
		categoria.getProductos().addAll(productos);
		
		return categoria;
	}

}
