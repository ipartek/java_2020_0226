package com.ipartek.formacion.spring.holamundocomplejospring;

import org.springframework.stereotype.Component;

@Component
public class ProveedorMensajesConstante implements ProveedorMensajes {

	@Override
	public String getMensaje() {
		return "Hola Mundo";
	}
	
}
