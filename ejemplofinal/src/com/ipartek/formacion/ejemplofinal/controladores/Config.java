package com.ipartek.formacion.ejemplofinal.controladores;

import com.ipartek.formacion.ejemplofinal.logicanegocio.CarritoNegocio;
import com.ipartek.formacion.ejemplofinal.logicanegocio.FabricaNegocio;

public class Config {
	private Config() {}
	
	static final String PATH_VISTAS = "/WEB-INF/vistas/";
	static final CarritoNegocio carritoNegocio = FabricaNegocio.getCarritoNegocio();	
}
