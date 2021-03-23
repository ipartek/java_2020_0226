package com.ipartek.formacion.spring.ejemplofinalspring.entidades;
import java.io.Serializable;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Departamento implements Serializable {
	private static final long serialVersionUID = 7623251760150200816L;
	
	private Long id;
	private String nombre;
	private String descripcion;
	
	private Set<Producto> productos;
}
