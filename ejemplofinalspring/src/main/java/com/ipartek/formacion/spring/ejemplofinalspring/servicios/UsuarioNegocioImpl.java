package com.ipartek.formacion.spring.ejemplofinalspring.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.spring.ejemplofinalspring.entidades.Usuario;
import com.ipartek.formacion.spring.ejemplofinalspring.repositorios.DaoUsuario;

@Service
public class UsuarioNegocioImpl implements UsuarioNegocio {

	@Autowired
	private DaoUsuario dao;
	
	@Override
	public boolean validarUsuario(Usuario usuario) {
		Usuario usuarioBdd = dao.obtenerPorEmail(usuario.getEmail());
		
		if(usuarioBdd != null && usuario.getPassword().equals(usuarioBdd.getPassword())) {
			usuario.setId(usuarioBdd.getId());
			usuario.setCliente(usuarioBdd.getCliente());
			
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Usuario obtenerUsuarioPorEmail(String email) {
		return dao.obtenerPorEmail(email);
	}
}
