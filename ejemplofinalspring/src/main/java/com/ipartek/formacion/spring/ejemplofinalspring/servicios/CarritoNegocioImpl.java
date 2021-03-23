package com.ipartek.formacion.spring.ejemplofinalspring.servicios;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.spring.ejemplofinalspring.entidades.Factura;
import com.ipartek.formacion.spring.ejemplofinalspring.entidades.Producto;
import com.ipartek.formacion.spring.ejemplofinalspring.repositorios.Dao;
import com.ipartek.formacion.spring.ejemplofinalspring.repositorios.DaoFactura;

import lombok.extern.java.Log;

@Service
@Log
public class CarritoNegocioImpl implements CarritoNegocio {

	@Autowired
	private Dao<Producto> daoProducto;
	@Autowired
	private DaoFactura daoFactura;

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
