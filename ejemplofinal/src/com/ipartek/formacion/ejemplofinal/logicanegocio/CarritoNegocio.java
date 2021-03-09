package com.ipartek.formacion.ejemplofinal.logicanegocio;

import java.util.Set;

import com.ipartek.formacion.ejemplofinal.entidades.Factura;
import com.ipartek.formacion.ejemplofinal.entidades.Producto;

public interface CarritoNegocio {
	Set<Producto> listadoProductos();

	Producto productoPorId(Long id);

	Factura guardarFactura(Factura factura);
}
