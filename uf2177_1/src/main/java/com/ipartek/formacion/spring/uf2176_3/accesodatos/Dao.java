package com.ipartek.formacion.spring.uf2176_3.accesodatos;

public interface Dao<T> {
	default Iterable<T> obtenerTodos() {
		throw new AccesoDatosException("ESTE MÉTODO NO ESTÁ IMPLEMENTADO");
	}

	default T obtenerPorId(Long id) {
		throw new AccesoDatosException("ESTE MÉTODO NO ESTÁ IMPLEMENTADO");
	}

	default T agregar(T t) {
		throw new AccesoDatosException("ESTE MÉTODO NO ESTÁ IMPLEMENTADO");
	}

	default T modificar(T t) {
		throw new AccesoDatosException("ESTE MÉTODO NO ESTÁ IMPLEMENTADO");
	}

	default T borrar(Long id) {
		throw new AccesoDatosException("ESTE MÉTODO NO ESTÁ IMPLEMENTADO");
	}

}
