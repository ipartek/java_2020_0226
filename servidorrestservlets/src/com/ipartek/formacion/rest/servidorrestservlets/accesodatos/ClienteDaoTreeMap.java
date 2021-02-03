package com.ipartek.formacion.rest.servidorrestservlets.accesodatos;

import java.time.LocalDate;
import java.util.TreeMap;

import com.ipartek.formacion.rest.servidorrestservlets.entidades.Cliente;

public class ClienteDaoTreeMap implements Dao<Cliente> {
	private static TreeMap<Long, Cliente> clientes = new TreeMap<>();

	static {
		clientes.put(1L, new Cliente(1L, "Javier", LocalDate.now()));
		clientes.put(2L, new Cliente(2L, "Pepe", LocalDate.now()));
	}

	@Override
	public Iterable<Cliente> obtenerTodos() {
		
		return clientes.values();
	}

	@Override
	public Cliente obtenerPorId(Long id) {
		return clientes.get(id);
	}

	@Override
	public Cliente insertar(Cliente cliente) {
		Long id = clientes.size() > 0 ? clientes.lastKey() + 1L : 1L;

		cliente.setId(id);

		clientes.put(cliente.getId(), cliente);
		
		return cliente;
	}

	@Override
	public Cliente modificar(Cliente cliente) {
		clientes.put(cliente.getId(), cliente);
		return cliente;
	}

	@Override
	public void borrar(Long id) {
		if(clientes.containsKey(id)) {
			clientes.remove(id);
		} else {
			throw new AccesoDatosException("No se ha encontrado el registro a borrar");
		}
	}

}
