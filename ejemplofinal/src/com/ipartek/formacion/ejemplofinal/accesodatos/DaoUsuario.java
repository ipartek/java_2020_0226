package com.ipartek.formacion.ejemplofinal.accesodatos;

import com.ipartek.formacion.ejemplofinal.entidades.Usuario;

public interface DaoUsuario extends Dao<Usuario>{
	Usuario obtenerPorEmail(String email);
}
