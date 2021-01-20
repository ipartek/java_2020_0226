package com.ipartek.formacion.spring.holamundocomplejospring;

import org.springframework.stereotype.Component;

@Component
public class ProcesadorMensajesConsolaFormateado implements ProcesadorMensajes {
	private ProveedorMensajes proveedor;
	
	public ProcesadorMensajesConsolaFormateado(ProveedorMensajes proveedor) {
		this.proveedor = proveedor;
	}

	@Override
	public void procesar() {
		System.out.println("####" + proveedor.getMensaje() + "####");
	}

}
