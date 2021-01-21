package com.ipartek.formacion.spring.springmvcbasico.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.spring.springmvcbasico.entidades.Producto;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/producto")
public class ProductoController {
	@GetMapping
	public String getProducto() {
		return "producto";
	}
	
	@PostMapping
	public String postProducto(Producto producto) {
		log.info(producto.toString());
		return "producto";
	}

}
