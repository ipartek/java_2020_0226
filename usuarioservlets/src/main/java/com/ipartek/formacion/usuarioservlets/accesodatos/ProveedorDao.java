package com.ipartek.formacion.usuarioservlets.accesodatos;

public class ProveedorDao {
	private ProveedorDao() {}
	
	public static FabricaDao obtenerFabrica(String tipo) {
		switch(tipo) {
		case "mysql": return new FabricaDaoMySql();
		default: throw new AccesoDatosException("No disponemos de fábrica de " + tipo); // return null;
		}
	}
}
