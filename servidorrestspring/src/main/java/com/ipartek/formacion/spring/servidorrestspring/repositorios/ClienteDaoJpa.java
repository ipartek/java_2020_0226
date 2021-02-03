package com.ipartek.formacion.spring.servidorrestspring.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.spring.servidorrestspring.entidades.Cliente;

@Repository
public class ClienteDaoJpa implements Dao<Cliente> {

	@Autowired
	private ClienteRepository repo;

	@Override
	public Iterable<Cliente> obtenerTodos() {
		return repo.findAll();
	}

	@Override
	public Cliente obtenerPorId(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public Cliente insertar(Cliente cliente) {
		return repo.save(cliente);
	}

	@Override
	public Cliente modificar(Cliente cliente) {
		repo.save(cliente);
		return cliente;
	}

	@Override
	public void borrar(Long id) {
		repo.deleteById(id);
	}

}
