package com.ipartek.formacion.usuarioservlets.accesodatos;

import com.ipartek.formacion.usuarioservlets.entidades.Rol;
import com.ipartek.formacion.usuarioservlets.entidades.Usuario;

public class FabricaDaoMySql implements FabricaDao {
	private static final Dao<Usuario> daoUsuario = new UsuarioDaoMySql();
	private static final Dao<Rol> daoRol = new RolDaoMySql();

	@SuppressWarnings("rawtypes")
	@Override
	public Dao crear(String entidad) {
		switch(entidad) {
		case "usuario": return daoUsuario;
		case "rol": return daoRol;
		default: throw new AccesoDatosException("No disponemos de un dao para la entidad " + entidad);
		}
	}
}
