package com.ipartek.formacion.jpa.ejemplojpa.accesodatos;

public interface Dao<T> {
	Iterable<T> obtenerTodos();
	T obtenerPorId(Long id);
	
	T agregar(T objeto);
	T modificar(T objeto);
	void borrar(Long id);
}
