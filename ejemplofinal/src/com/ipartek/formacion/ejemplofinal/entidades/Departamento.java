package com.ipartek.formacion.ejemplofinal.entidades;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Departamento {
	private Long id;
	private String nombre;
	private String descripcion;
	
	private Set<Producto> productos;
}
