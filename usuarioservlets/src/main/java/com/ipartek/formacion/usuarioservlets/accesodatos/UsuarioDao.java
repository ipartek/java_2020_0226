package com.ipartek.formacion.usuarioservlets.accesodatos;

import com.ipartek.formacion.usuarioservlets.entidades.Usuario;

public interface UsuarioDao extends Dao<Usuario> {
	default Usuario obtenerPorEmail(String email) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}
	
	default Iterable<Usuario> obtenerPorIdRol(Long id) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}
	
	default Usuario modificarSinPassword(Usuario usuario) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}
}
