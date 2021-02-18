package com.ipartek.formacion.usuarioservlets.accesodatos;

public interface FabricaDao {
	@SuppressWarnings("rawtypes")
	Dao crear(String entidad);
}
