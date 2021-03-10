package com.ipartek.formacion.ejemplofinal.accesodatos;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

class Config {
	private static final String JDBC_SUPERMERCADO = "jdbc/supermercado";

	private Config() {}
	
	static final DataSource dataSource;
	
	static {
		try {
			InitialContext initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			dataSource = (DataSource) envCtx.lookup(JDBC_SUPERMERCADO);
		} catch (NamingException e) {
			throw new AccesoDatosException("No se ha encontrado el JNDI de supermercado", e);
		}
	}
}
