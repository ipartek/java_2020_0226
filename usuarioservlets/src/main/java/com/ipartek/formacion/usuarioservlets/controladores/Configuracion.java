package com.ipartek.formacion.usuarioservlets.controladores;

import com.ipartek.formacion.usuarioservlets.accesodatos.FabricaDao;
import com.ipartek.formacion.usuarioservlets.accesodatos.ProveedorDao;
import com.ipartek.formacion.usuarioservlets.accesodatos.UsuarioDao;

public class Configuracion {
	private Configuracion() {}
	
	private static String motor;

	public static void setMotor(String motor) {
		Configuracion.motor = motor;
		fabrica = ProveedorDao.obtenerFabrica(motor);
		daoUsuario = (UsuarioDao) fabrica.crear("usuario");
	}
	
	public static String getMotor() {
		return motor;
	}
	
	public static FabricaDao fabrica;
	public static UsuarioDao daoUsuario;
}
