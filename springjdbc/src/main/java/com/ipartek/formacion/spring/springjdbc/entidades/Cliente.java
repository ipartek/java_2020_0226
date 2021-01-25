package com.ipartek.formacion.spring.springjdbc.entidades;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Cliente {
	private Long id;
	private String nombre, apellidos, cif;
	private LocalDate fechaNacimiento;
}
