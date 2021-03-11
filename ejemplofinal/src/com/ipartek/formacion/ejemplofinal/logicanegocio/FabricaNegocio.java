package com.ipartek.formacion.ejemplofinal.logicanegocio;

public class FabricaNegocio {
	private FabricaNegocio() {}
	
	private static final CarritoNegocio carritoNegocio = new CarritoNegocioImpl();
	private static final ClienteNegocio clienteNegocio = new ClienteNegocioImpl();
	private static final UsuarioNegocio usuarioNegocio = new UsuarioNegocioImpl();
	
	public static CarritoNegocio getCarritoNegocio() {
		return carritoNegocio;
	}

	public static ClienteNegocio getClienteNegocio() {
		return clienteNegocio;
	}

	public static UsuarioNegocio getUsuarioNegocio() {
		return usuarioNegocio;
	}
}
