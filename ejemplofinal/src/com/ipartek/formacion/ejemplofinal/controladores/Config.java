package com.ipartek.formacion.ejemplofinal.controladores;

import com.ipartek.formacion.ejemplofinal.logicanegocio.CarritoNegocio;
import com.ipartek.formacion.ejemplofinal.logicanegocio.ClienteNegocio;
import com.ipartek.formacion.ejemplofinal.logicanegocio.FabricaNegocio;
import com.ipartek.formacion.ejemplofinal.logicanegocio.UsuarioNegocio;

class Config {
	
	private Config() {}
	
	static final String PATH_VISTAS = "/WEB-INF/vistas/";
	static final CarritoNegocio carritoNegocio = FabricaNegocio.getCarritoNegocio();
	static final ClienteNegocio clienteNegocio = FabricaNegocio.getClienteNegocio();
	static final UsuarioNegocio usuarioNegocio = FabricaNegocio.getUsuarioNegocio();
}
