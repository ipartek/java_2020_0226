package com.ipartek.formacion.spring.springmvcbasico.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Producto {
	private Long id;
	private String nombre;
	private BigDecimal precio;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate fechaIncorporacion;
}
