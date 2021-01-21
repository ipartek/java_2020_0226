package com.ipartek.formacion.spring.springmvcbasico.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SaludarController {
	@GetMapping("/saludo")
	public String saludo(@RequestParam(required = false, defaultValue = "al curso") String nombre, Model modelo) {
		modelo.addAttribute("nombre", nombre);
		return "saludo";
	}
}
