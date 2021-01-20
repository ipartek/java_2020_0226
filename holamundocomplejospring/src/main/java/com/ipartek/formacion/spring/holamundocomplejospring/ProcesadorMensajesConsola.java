package com.ipartek.formacion.spring.holamundocomplejospring;

public class ProcesadorMensajesConsola implements ProcesadorMensajes {
	private ProveedorMensajes proveedor;
	
	public ProcesadorMensajesConsola(ProveedorMensajes proveedor) {
		this.proveedor = proveedor;
	}

	@Override
	public void procesar() {
		System.out.println(proveedor.getMensaje());
	}

}
