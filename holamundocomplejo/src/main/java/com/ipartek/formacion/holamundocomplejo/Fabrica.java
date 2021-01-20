package com.ipartek.formacion.holamundocomplejo;

import java.util.Properties;

public class Fabrica {
	private ProveedorMensajes proveedor;
	private ProcesadorMensajes procesador;
	
	public Fabrica(String configuracion) {
		Properties prop = new Properties();
		try {
			prop.load(this.getClass().getClassLoader().getResourceAsStream(configuracion + ".properties"));
			proveedor = (ProveedorMensajes)(Class.forName((String)prop.get("mensajes.proveedor")).newInstance());
			procesador = (ProcesadorMensajes)(Class.forName((String)prop.get("mensajes.procesador")).getConstructor(ProveedorMensajes.class).newInstance(proveedor));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ProcesadorMensajes getProcesadorMensajes() {
		
		return procesador;
	}

}
