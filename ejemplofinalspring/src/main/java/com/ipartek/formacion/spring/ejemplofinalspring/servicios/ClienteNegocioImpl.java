package com.ipartek.formacion.spring.ejemplofinalspring.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.spring.ejemplofinalspring.entidades.Cliente;
import com.ipartek.formacion.spring.ejemplofinalspring.repositorios.Dao;

import lombok.extern.java.Log;

@Service
@Log
public class ClienteNegocioImpl implements ClienteNegocio {
	@Autowired
	private Dao<Cliente> dao;
	
	@Override
	public Cliente altaCliente(Cliente cliente) {
		log.info(cliente.toString());
		return dao.insertar(cliente);
	}

}
