package com.ipartek.formacion.spring.ejemplofinalspring.entidades;

import java.io.Serializable;
import java.util.TreeMap;

/**
 * Representa el carrito de la compra de los usuarios de la aplicación
 * 
 * @author Javier Lete
 * @version 1.0
 */
public class Carrito implements Serializable {

	/**
	 * Necesario para los elementos Serializables
	 */
	private static final long serialVersionUID = -370385928841361725L;

	/**
	 * Almacenamos las líneas de carrito que contendrán el producto y cantidad
	 */
	private TreeMap<Long, DetalleCarrito> lineas = new TreeMap<>();
	
	/**
	 * Añade el producto en una cantidad concreta al carrito
	 * @param producto producto a introducir en el carrito
	 * @param cantidad cantidad del producto a introducir
	 */
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
	
	/**
	 * Método para la obtención del contenido del carrito
	 * @return líneas del carrito (producto, cantidad)
	 */
	public Iterable<DetalleCarrito> getLineas() {
		return lineas.values();
	}
}
