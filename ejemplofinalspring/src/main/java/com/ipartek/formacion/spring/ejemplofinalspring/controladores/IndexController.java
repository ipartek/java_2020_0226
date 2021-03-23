package com.ipartek.formacion.spring.ejemplofinalspring.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ipartek.formacion.spring.ejemplofinalspring.entidades.Carrito;
import com.ipartek.formacion.spring.ejemplofinalspring.entidades.Producto;
import com.ipartek.formacion.spring.ejemplofinalspring.servicios.CarritoNegocio;

@Controller
@SessionAttributes("carrito")
public class IndexController {
	@Autowired
	private CarritoNegocio carritoNegocio;
	
	@ModelAttribute("carrito")
	private Carrito getCarrito() {
		return new Carrito();
	}
	
	@RequestMapping("/")
	public String index(Model modelo) {
		modelo.addAttribute("productos", carritoNegocio.listadoProductos());
		return "index";
	}
	
	@RequestMapping("/add-carrito")
	public String addCarrito(@RequestParam Long id, Carrito carrito) {
		Producto producto = carritoNegocio.productoPorId(id);
		
		carrito.addProducto(producto, 1);
		
		return "carrito";
	}
}
