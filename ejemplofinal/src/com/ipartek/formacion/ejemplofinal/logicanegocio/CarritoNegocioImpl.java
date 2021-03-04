package com.ipartek.formacion.ejemplofinal.logicanegocio;

import java.util.Set;

import com.ipartek.formacion.ejemplofinal.accesodatos.Dao;
import com.ipartek.formacion.ejemplofinal.accesodatos.DaoFabrica;
import com.ipartek.formacion.ejemplofinal.entidades.Producto;

import lombok.extern.java.Log;

@Log
public class CarritoNegocioImpl implements CarritoNegocio {

	private Dao<Producto> daoProducto = DaoFabrica.getDaoProducto();
	
	@Override
	public Set<Producto> listadoProductos() {
		Set<Producto> productos = daoProducto.obtenerTodos();
		log.info(productos.toString());
		return productos;
	}

}
