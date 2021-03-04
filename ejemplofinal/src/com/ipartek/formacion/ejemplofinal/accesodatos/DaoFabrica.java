package com.ipartek.formacion.ejemplofinal.accesodatos;

import com.ipartek.formacion.ejemplofinal.entidades.Producto;

public class DaoFabrica {
	
	private DaoFabrica() {}

	private static final Dao<Producto> daoProducto = new ProductoDaoMySql();
	
	public static Dao<Producto> getDaoProducto() {
		return daoProducto;
	}
	
}
