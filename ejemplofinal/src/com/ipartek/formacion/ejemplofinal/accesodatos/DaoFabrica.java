package com.ipartek.formacion.ejemplofinal.accesodatos;

import com.ipartek.formacion.ejemplofinal.entidades.Cliente;
import com.ipartek.formacion.ejemplofinal.entidades.Producto;

public class DaoFabrica {
	
	

	private DaoFabrica() {}

	private static final Dao<Producto> daoProducto = new ProductoDaoMySql();
	private static final DaoFactura daoFactura = new FacturaDaoMySql();
	private static final Dao<Cliente> daoCliente = new ClienteDaoMySql();
	private static final DaoUsuario daoUsuario = new UsuarioDaoMySql();
	
	public static Dao<Producto> getDaoProducto() {
		return daoProducto;
	}

	public static DaoFactura getDaoFactura() {
		return daoFactura;
	}

	public static Dao<Cliente> getDaoCliente() {
		return daoCliente;
	}

	public static DaoUsuario getDaoUsuario() {
		return daoUsuario;
	}
	
}
