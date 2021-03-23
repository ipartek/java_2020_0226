package com.ipartek.formacion.spring.ejemplofinalspring.repositorios;

import com.ipartek.formacion.spring.ejemplofinalspring.entidades.Factura;

public interface DaoFactura extends Dao<Factura> {

	String obtenerUltimoCodigo();
}
