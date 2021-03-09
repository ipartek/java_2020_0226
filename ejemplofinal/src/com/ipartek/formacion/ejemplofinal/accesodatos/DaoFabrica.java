package com.ipartek.formacion.ejemplofinal.accesodatos;

import com.ipartek.formacion.ejemplofinal.entidades.Factura;
import com.ipartek.formacion.ejemplofinal.entidades.Producto;

public class DaoFabrica {
	
	private DaoFabrica() {}

	private static final Dao<Producto> daoProducto = new ProductoDaoMySql();
	private static final Dao<Factura> daoFactura = new FacturaDaoMySql();
	
	public static Dao<Producto> getDaoProducto() {
		return daoProducto;
	}

	public static Dao<Factura> getDaoFactura() {
		return daoFactura;
	}
	
}
