package com.ipartek.formacion.spring.ejemplofinalspring.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

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
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate fechaNacimiento;
	
	private Set<Factura> facturas;
}
