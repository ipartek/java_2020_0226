package com.ipartek.formacion.ejemplofinal.logicanegocio;

public class FabricaNegocio {
	private FabricaNegocio() {}
	
	private static final CarritoNegocio carritoNegocio = new CarritoNegocioImpl();
	
	public static CarritoNegocio getCarritoNegocio() {
		return carritoNegocio;
	}
}
