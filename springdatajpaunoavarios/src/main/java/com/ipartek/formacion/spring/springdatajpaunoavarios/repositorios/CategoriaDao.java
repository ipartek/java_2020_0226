package com.ipartek.formacion.spring.springdatajpaunoavarios.repositorios;

import com.ipartek.formacion.spring.springdatajpaunoavarios.entidades.Categoria;

public interface CategoriaDao extends Dao<Categoria> {
	Categoria obtenerPorIdConProductos(Long id);
}
