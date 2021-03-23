package com.ipartek.formacion.spring.ejemplofinalspring.servicios;

import com.ipartek.formacion.spring.ejemplofinalspring.entidades.Usuario;

public interface UsuarioNegocio {
	boolean validarUsuario(Usuario usuario);

	Usuario obtenerUsuarioPorEmail(String email);
}
