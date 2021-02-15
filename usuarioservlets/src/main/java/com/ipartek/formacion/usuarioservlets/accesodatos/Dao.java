package com.ipartek.formacion.usuarioservlets.accesodatos;

public interface Dao<T> {
	default Iterable<T> obtenerTodos() {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	default T obtenerPorId(Long id) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	default T insertar(T t) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	default T modificar(T t) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	default void borrar(Long id) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}
}
