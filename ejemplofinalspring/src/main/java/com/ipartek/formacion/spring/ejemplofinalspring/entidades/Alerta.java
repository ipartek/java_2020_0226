package com.ipartek.formacion.spring.ejemplofinalspring.entidades;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Alerta implements Serializable {

	private static final long serialVersionUID = 4718434984524239877L;

	private String nivel;
	private String mensaje;
}
