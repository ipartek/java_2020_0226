package com.ipartek.formacion.spring.ejemplofinalspring.entidades;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class DetalleCarrito implements Serializable {
	private static final long serialVersionUID = 8457880439062947651L;
	
	private Producto producto;
	private Integer cantidad;
}
