package com.ipartek.formacion.ejemplofinal.entidades;
import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class DetalleFactura implements Serializable {
	private static final long serialVersionUID = 3924664355341140287L;
	
	private Factura factura;
	private Producto producto;
	private Integer cantidad;
	
	public BigDecimal getTotal() {
		return producto.getPrecio().multiply(new BigDecimal(cantidad));
	}
}
