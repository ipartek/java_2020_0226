package com.ipartek.formacion.spring.ejemplofinalspring.servicios;

import java.util.Set;

import com.ipartek.formacion.spring.ejemplofinalspring.entidades.Factura;
import com.ipartek.formacion.spring.ejemplofinalspring.entidades.Producto;

public interface CarritoNegocio {
	Set<Producto> listadoProductos();

	Producto productoPorId(Long id);

	Factura guardarFactura(Factura factura);
}
