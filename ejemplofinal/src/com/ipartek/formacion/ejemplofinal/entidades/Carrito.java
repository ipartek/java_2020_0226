package com.ipartek.formacion.ejemplofinal.entidades;

import java.io.Serializable;
import java.util.TreeMap;

public class Carrito implements Serializable {

	private static final long serialVersionUID = -370385928841361725L;

	private TreeMap<Long, DetalleCarrito> lineas = new TreeMap<>();
	
	public void addProducto(Producto producto, Integer cantidad) {
		Long id = producto.getId();
		
		if(lineas.containsKey(id)) {
			DetalleCarrito linea = lineas.get(id);
			
			linea.setCantidad(linea.getCantidad() +  producto.getCantidad());
		} else {
			DetalleCarrito linea = new DetalleCarrito(producto, cantidad);
		
			lineas.put(id, linea);
		}
	}
	
	public Iterable<DetalleCarrito> getLineas() {
		return lineas.values();
	}
}
