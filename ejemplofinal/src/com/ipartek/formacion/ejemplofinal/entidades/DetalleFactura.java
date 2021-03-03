package com.ipartek.formacion.ejemplofinal.entidades;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class DetalleFactura {
	private Factura factura;
	private Producto producto;
	private Integer cantidad;
}
