package com.ipartek.formacion.spring.springdatajpaunoavarios;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.ipartek.formacion.spring.springdatajpaunoavarios.entidades.Categoria;
import com.ipartek.formacion.spring.springdatajpaunoavarios.entidades.Producto;
import com.ipartek.formacion.spring.springdatajpaunoavarios.repositorios.CategoriaDao;
import com.ipartek.formacion.spring.springdatajpaunoavarios.repositorios.CategoriaRepository;
import com.ipartek.formacion.spring.springdatajpaunoavarios.repositorios.Dao;
import com.ipartek.formacion.spring.springdatajpaunoavarios.repositorios.ProductoRepository;

@SpringBootApplication
public class SpringdatajpaunoavariosApplication implements CommandLineRunner {
	@Autowired
	private Dao<Producto> daoProductos;

	@Autowired
	private CategoriaDao daoCategorias;

	@Autowired
	private ProductoRepository productos;

	@Autowired
	private CategoriaRepository categorias;

	public static void main(String[] args) {
		SpringApplication.run(SpringdatajpaunoavariosApplication.class, args);
	}

	@Override

	public void run(String... args) throws Exception {
		System.out.println(daoProductos.obtenerPorId(2L));

		Categoria categoria = daoCategorias.obtenerPorIdConProductos(1L);

		System.out.println(categoria);

		for (Producto producto : categoria.getProductos()) {
			System.out.println(producto);
		}
		// inicializarDatos();

		// mostrarDatos();
	}

	@Transactional
	private void mostrarDatos() {
		System.out.println(productos.findById(2L).orElse(null));

		Categoria categoria = categorias.findById(1L).orElse(null);

		System.out.println(categoria);

		for (Producto producto : categoria.getProductos()) {
			System.out.println(producto);
		}
	}

	@Transactional
	private void inicializarDatos() {
		Categoria informatica = new Categoria(null, "Informática", "La de siempre");

		Producto monitor = new Producto(null, "Monitor", new BigDecimal("123.45"), informatica);
		Producto raton = new Producto(null, "Ratón", new BigDecimal("12.34"), informatica);

		categorias.save(informatica);

		productos.save(monitor);
		productos.save(raton);
	}

}
