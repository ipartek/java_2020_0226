package com.ipartek.formacion.ejemplofinal.logicanegocio;

import java.time.LocalDate;
import java.util.Set;

import com.ipartek.formacion.ejemplofinal.accesodatos.Dao;
import com.ipartek.formacion.ejemplofinal.accesodatos.DaoFabrica;
import com.ipartek.formacion.ejemplofinal.accesodatos.DaoFactura;
import com.ipartek.formacion.ejemplofinal.entidades.Factura;
import com.ipartek.formacion.ejemplofinal.entidades.Producto;

import lombok.extern.java.Log;

@Log
public class CarritoNegocioImpl implements CarritoNegocio {

	private Dao<Producto> daoProducto = DaoFabrica.getDaoProducto();
	private DaoFactura daoFactura = DaoFabrica.getDaoFactura();

	@Override
	public Set<Producto> listadoProductos() {
		Set<Producto> productos = daoProducto.obtenerTodos();
		log.info(productos.toString());
		return productos;
	}

	@Override
	public Producto productoPorId(Long id) {
		Producto producto = daoProducto.obtenerPorId(id);
		log.info(producto.toString());
		return producto;
	}

	@Override
	public Factura guardarFactura(Factura factura) {
		String codigo = daoFactura.obtenerUltimoCodigo(); //20210001
		String nuevoCodigo = aumentarCodigo(codigo);
		factura.setCodigo(nuevoCodigo);
		log.info(factura.toString());
		return daoFactura.insertar(factura);
	}

	private String aumentarCodigo(String codigoAnterior) {
		if (codigoAnterior != null && !codigoAnterior.matches("\\d{8}")) {
			throw new LogicaNegocioException("Error en el código recibido: " + codigoAnterior);
		}

		String codigo = null;
		String anio = null;
		String numero = null;

		if (codigoAnterior == null) {
			codigo = String.valueOf(LocalDate.now().getYear()) + "0001";
		} else {
			anio = codigoAnterior.substring(0, 4);
			numero = codigoAnterior.substring(4, 8);

			int siguiente = Integer.parseInt(numero) + 1;
			
			codigo = String.format("%s%04d", anio, siguiente);
		}

		return codigo;
	}
}
