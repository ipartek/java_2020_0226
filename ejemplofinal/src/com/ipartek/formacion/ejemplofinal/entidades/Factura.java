package com.ipartek.formacion.ejemplofinal.entidades;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Factura implements Serializable {

	private static final long serialVersionUID = 2396176411731906644L;

	private Long id;
	private String codigo;
	private LocalDate fecha;
	
	private Cliente cliente;
	
	private Set<DetalleFactura> detallesFactura;
}
