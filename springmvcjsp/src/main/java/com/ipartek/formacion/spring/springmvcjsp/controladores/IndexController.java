package com.ipartek.formacion.spring.springmvcjsp.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/") // @WebServlet("/")
public class IndexController { // extends HttpServlet
	@GetMapping
	public String get() { //doGet
		return "index"; // request.getRequestDispatcher("/WEB-INF/vistas/index.jsp").forward(request,response)
	}
	
	@PostMapping
	public String post(String nombre, Model modelo) { //doPost
		System.out.println(nombre);
		
		modelo.addAttribute("nombre", nombre);
		
		//return "saludo"; // request.getRequestDispatcher("/WEB-INF/vistas/saludo.jsp").forward(request,response)
		//return saludo(nombre, modelo);
		return "forward:/saludo"; // request.getRequestDispatcher("/saludo").forward(request, response)
	}
	
	@RequestMapping("saludo")
	public String saludo(Model modelo) {
		modelo.addAttribute("saludo", "¿cómo andas?");
		return "saludo";
	}
	
	@GetMapping("index")
	public String indice() {
		return "redirect:/"; // response.sendRedirect("/");
	}
}
