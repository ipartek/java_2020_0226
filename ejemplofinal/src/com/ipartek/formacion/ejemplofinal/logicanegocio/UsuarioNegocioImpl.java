package com.ipartek.formacion.ejemplofinal.logicanegocio;

import com.ipartek.formacion.ejemplofinal.accesodatos.DaoFabrica;
import com.ipartek.formacion.ejemplofinal.accesodatos.DaoUsuario;
import com.ipartek.formacion.ejemplofinal.entidades.Usuario;

public class UsuarioNegocioImpl implements UsuarioNegocio {

	private DaoUsuario dao = DaoFabrica.getDaoUsuario();
	
	@Override
	public boolean validarUsuario(Usuario usuario) {
		Usuario usuarioBdd = dao.obtenerPorEmail(usuario.getEmail());
		
		if(usuario.getPassword().equals(usuarioBdd.getPassword())) {
			usuario.setId(usuarioBdd.getId());
			usuario.setCliente(usuarioBdd.getCliente());
			
			return true;
		} else {
			return false;
		}
	}

}
