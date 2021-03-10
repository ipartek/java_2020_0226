package com.ipartek.formacion.ejemplofinal.accesodatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.ipartek.formacion.ejemplofinal.entidades.Departamento;
import com.ipartek.formacion.ejemplofinal.entidades.Producto;

class ProductoDaoMySql implements Dao<Producto> {
	private static final String SQL_SELECT = "SELECT p.id AS id, p.nombre AS nombre, p.descripcion AS descripcion, url_imagen, precio, descuento, unidad_medida, precio_unidad_medida, cantidad, activo, d.id AS d_id, d.nombre AS d_nombre, d.descripcion AS d_descripcion  \r\n"
			+ "FROM productos p\r\n" + "JOIN departamentos d ON p.departamentos_id = d.id";
	private static final String SQL_SELECT_ID = SQL_SELECT + " WHERE p.id = ?";

	@Override
	public Set<Producto> obtenerTodos() {
		try (Connection con = Config.dataSource.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(SQL_SELECT)) {
			Set<Producto> productos = new HashSet<>();
			
			Producto producto;

			while (rs.next()) {
				producto = mapearResultSetProducto(rs);
				
				productos.add(producto);
			}
			
			return productos;
		} catch (Exception e) {
			throw new AccesoDatosException("Error al obtener todos los productos", e);
		}
	}

	@Override
	public Producto obtenerPorId(Long id) {
		try (Connection con = Config.dataSource.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID);
				) {
			
			pst.setLong(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			Producto producto = null;

			if (rs.next()) {
				producto = mapearResultSetProducto(rs);
			}
			
			return producto;
		} catch (Exception e) {
			throw new AccesoDatosException("Error al obtener el producto id " + id, e);
		}
	}

	private Producto mapearResultSetProducto(ResultSet rs) throws SQLException {
		Producto producto;
		Departamento departamento;
		departamento = new Departamento(rs.getLong("d_id"), rs.getString("d_nombre"),
				rs.getString("d_descripcion"), null);
		producto = new Producto(rs.getLong("id"), rs.getString("nombre"), rs.getString("descripcion"), rs.getString("url_imagen"),
				rs.getBigDecimal("precio"), rs.getInt("descuento"), rs.getString("unidad_medida"),
				rs.getBigDecimal("precio_unidad_medida"), rs.getInt("cantidad"), departamento,
				rs.getBoolean("activo"), null);
		return producto;
	}

}
