package com.ipartek.formacion.holamundocomplejo;

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
