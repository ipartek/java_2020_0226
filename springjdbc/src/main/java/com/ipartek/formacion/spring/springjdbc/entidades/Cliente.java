package com.ipartek.formacion.spring.springjdbc.entidades;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Cliente {
	private Long id;
	private String nombre, apellidos, cif;
	private LocalDate fechaNacimiento;
}
