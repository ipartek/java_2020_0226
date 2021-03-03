package com.ipartek.formacion.ejemplofinal.entidades;
import java.math.BigDecimal;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Producto {
	private Long id;
	private String nombre;
	private String descripcion;
	private String urlImagen;
	private BigDecimal precio;
	private String unidadMedida;
	private BigDecimal precioUnidadMedida;
	private Integer cantidad;
	
	private Departamento departamento;
	
	private Boolean activo;
	
	private Set<DetalleFactura> detallesFactura;
}
