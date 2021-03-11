package com.ipartek.formacion.ejemplofinal.accesodatos;

import com.ipartek.formacion.ejemplofinal.entidades.Factura;

public interface DaoFactura extends Dao<Factura> {

	String obtenerUltimoCodigo();
}
