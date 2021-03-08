package com.ipartek.formacion.ejemplofinal.entidades;

import java.io.Serializable;
import java.util.TreeMap;

public class Carrito implements Serializable {

	private static final long serialVersionUID = -370385928841361725L;

	private TreeMap<Long, DetalleCarrito> lineas = new TreeMap<>();
	
	public void addProducto(Producto producto, Integer cantidad) {
		Long id = producto.getId();
		
		DetalleCarrito linea;
		
		if(lineas.containsKey(id)) {
			linea = lineas.get(id);
			
			linea.setCantidad(linea.getCantidad() +  cantidad);
		} else {
			linea = new DetalleCarrito(producto, cantidad);
		
			lineas.put(id, linea);
		}
	}
	
	public Iterable<DetalleCarrito> getLineas() {
		return lineas.values();
	}
}
