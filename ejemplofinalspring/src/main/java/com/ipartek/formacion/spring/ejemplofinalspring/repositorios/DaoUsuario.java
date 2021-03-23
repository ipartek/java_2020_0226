package com.ipartek.formacion.spring.ejemplofinalspring.repositorios;

import com.ipartek.formacion.spring.ejemplofinalspring.entidades.Usuario;

public interface DaoUsuario extends Dao<Usuario>{
	Usuario obtenerPorEmail(String email);
}
