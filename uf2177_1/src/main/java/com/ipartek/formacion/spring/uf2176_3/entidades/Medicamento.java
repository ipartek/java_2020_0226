package com.ipartek.formacion.spring.uf2176_3.entidades;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medicamento {
	@Min(1)
	private Long id;
	@NotBlank
	@Size(min = 12, max = 12)
	private String referencia;
	@NotBlank
	private String nombre;
	@Min(0)
	private BigDecimal precio;
}
