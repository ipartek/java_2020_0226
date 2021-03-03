package com.ipartek.formacion.ejemplofinal.accesodatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.ipartek.formacion.ejemplofinal.entidades.Departamento;
import com.ipartek.formacion.ejemplofinal.entidades.Producto;

public class ProductoDaoMySql implements Dao<Producto> {
	private static final String SQL_SELECT = "SELECT p.id AS id, p.nombre AS nombre, p.descripcion AS descripcion, precio, descuento, unidad_medida, precio_unidad_medida, cantidad, d.id AS d_id, d.nombre AS d_nombre, d.descripcion AS d_descripcion  \r\n"
			+ "FROM productos p\r\n" + "JOIN departamentos d ON p.departamentos_id = d.id";
	private DataSource dataSource;

	private ProductoDaoMySql() {
		try {
			InitialContext initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			dataSource = (DataSource) envCtx.lookup("jdbc/supermercado");
		} catch (NamingException e) {
			throw new AccesoDatosException("No se ha encontrado el JNDI de supermercado", e);
		}
	}

	@Override
	public Iterable<Producto> obtenerTodos() {
		try (Connection con = dataSource.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(SQL_SELECT)) {
			ArrayList<Producto> productos = new ArrayList<>();
			
			Producto producto;
			Departamento departamento;

			while (rs.next()) {
				departamento = new Departamento(rs.getLong("d_id"), rs.getString("d_nombre"),
						rs.getString("d_descripcion"), null);
				producto = new Producto(rs.getLong("id"), rs.getString("nombre"), rs.getString("descripcion"), rs.getString("url_imagen"),
						rs.getBigDecimal("precio"), rs.getInt("descuento"), rs.getString("unidad_medida"),
						rs.getBigDecimal("precio_unidad_medida"), rs.getInt("cantidad"), departamento,
						rs.getBoolean("activo"), null);
				
				productos.add(producto);
			}
			
			return productos;
		} catch (Exception e) {
			throw new AccesoDatosException("Error al obtener todos los productos", e);
		}
	}

	// TODO: Singleton o fábrica

}
