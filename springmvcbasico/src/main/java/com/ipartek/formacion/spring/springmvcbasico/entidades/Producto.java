package com.ipartek.formacion.spring.springmvcbasico.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Producto {
	@NotNull
	@Min(1)
	private Long id;
	
	@NotBlank
	@Size(min=3, max=150)
	private String nombre;
	
	@Min(0)
	@NotNull
	private BigDecimal precio;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@PastOrPresent
	private LocalDate fechaIncorporacion;
}
