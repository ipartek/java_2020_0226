package com.ipartek.formacion.spring.springmvcbasico.controladores;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
	public String getProducto(Producto producto) {
		return "producto";
	}
	
	@PostMapping
	public String postProducto(@Valid Producto producto, BindingResult bindingResult) {
		log.info(producto.toString());
		log.info(bindingResult.toString());
		
		if(bindingResult.hasErrors()) {
			return "producto";
		} else {
			return "listado";
		}
	}

}
