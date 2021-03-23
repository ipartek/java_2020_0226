package com.ipartek.formacion.spring.ejemplofinalspring.entidades;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Producto implements Serializable {
	private static final long serialVersionUID = -1067728694838158604L;
	
	private Long id;
	private String nombre;
	private String descripcion;
	private String urlImagen;
	private BigDecimal precio;
	private Integer descuento;
	private String unidadMedida;
	private BigDecimal precioUnidadMedida;
	private Integer cantidad;
	
	private Departamento departamento;
	
	private Boolean activo;
	
	private Set<DetalleFactura> detallesFactura;
}
