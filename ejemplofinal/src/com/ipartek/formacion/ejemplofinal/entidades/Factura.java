package com.ipartek.formacion.ejemplofinal.entidades;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor @AllArgsConstructor
public class Factura implements Serializable {

	private static final BigDecimal IVA = new BigDecimal("0.21");
	
	private static final long serialVersionUID = 2396176411731906644L;

	private Long id;
	private String codigo;
	private LocalDate fecha;
	
	private Cliente cliente;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private Set<DetalleFactura> detallesFactura = new HashSet<>();
	
	public BigDecimal getTotal() {
		BigDecimal total = BigDecimal.ZERO;
		
		for(DetalleFactura detalle: detallesFactura) {
			total = total.add(detalle.getTotal());
		}
		
		return total;
	}
	
	public BigDecimal getIva() {
		return getTotal().multiply(IVA);
	}
	
	public BigDecimal getTotalConIva() {
		return getTotal().add(getIva());
	}
}
