package com.ipartek.formacion.ejemplofinal.logicanegocio;

import com.ipartek.formacion.ejemplofinal.accesodatos.ClienteDaoMySql;
import com.ipartek.formacion.ejemplofinal.accesodatos.Dao;
import com.ipartek.formacion.ejemplofinal.entidades.Cliente;

import lombok.extern.java.Log;

@Log
public class ClienteNegocioImpl implements ClienteNegocio {
	private Dao<Cliente> dao = new ClienteDaoMySql();
	
	@Override
	public Cliente altaCliente(Cliente cliente) {
		log.info(cliente.toString());
		return dao.insertar(cliente);
	}

}
