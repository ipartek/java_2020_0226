package com.ipartek.formacion.ejemplofinal.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 3086908301375558731L;
	
	private Long id;
	private String nombre;
	private String apellidos;
	private String cif;
	private LocalDate fechaNacimiento;
	
	private Set<Factura> facturas;
}
