package com.ipartek.formacion.spring.ejemplofinalspring.controladores;

import java.security.Principal;
import java.time.LocalDate;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ipartek.formacion.spring.ejemplofinalspring.entidades.Carrito;
import com.ipartek.formacion.spring.ejemplofinalspring.entidades.Cliente;
import com.ipartek.formacion.spring.ejemplofinalspring.entidades.DetalleCarrito;
import com.ipartek.formacion.spring.ejemplofinalspring.entidades.DetalleFactura;
import com.ipartek.formacion.spring.ejemplofinalspring.entidades.Factura;
import com.ipartek.formacion.spring.ejemplofinalspring.entidades.Producto;
import com.ipartek.formacion.spring.ejemplofinalspring.entidades.Usuario;
import com.ipartek.formacion.spring.ejemplofinalspring.servicios.CarritoNegocio;
import com.ipartek.formacion.spring.ejemplofinalspring.servicios.ClienteNegocio;
import com.ipartek.formacion.spring.ejemplofinalspring.servicios.UsuarioNegocio;

import lombok.extern.java.Log;

@Controller
@Log
@SessionAttributes({ "carrito", "cliente" })
public class IndexController {
	@Autowired
	private CarritoNegocio carritoNegocio;
	@Autowired
	private ClienteNegocio clienteNegocio;
	@Autowired
	private UsuarioNegocio usuarioNegocio;

	@ModelAttribute("carrito")
	private Carrito getCarrito() {
		return new Carrito();
	}

	@ModelAttribute("cliente")
	private Cliente getCliente() {
		return new Cliente();
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

	@RequestMapping("/confirmar-compra")
	public String confirmarCompra(Principal principal, Map<String, Object> model) {
		if (principal != null) {
			String email = principal.getName();

			Usuario usuario = usuarioNegocio.obtenerUsuarioPorEmail(email);

			if (usuario != null && usuario.getCliente() != null) {
				log.info(usuario.toString());
				model.put("cliente", usuario.getCliente());
				return "redirect:/crear-factura";
			}
		}
		
		return "redirect:/cliente";
	}

	@GetMapping("/cliente")
	public String clienteGet() {
		return "cliente";
	}

	@PostMapping("/cliente")
	public String clientePost(Cliente cliente) {
		clienteNegocio.altaCliente(cliente);

		log.info(cliente.toString());

		return "redirect:/crear-factura";
	}

	@RequestMapping("/crear-factura")
	public String crearFactura(Cliente cliente, Carrito carrito, Factura factura) {
		// TODO: Crear factura por lógica de negocio

		factura.setFecha(LocalDate.now());

		if (cliente.getId() == null) {
			return "redirect:/cliente";
		}

		factura.setCliente(cliente);

		for (DetalleCarrito detalle : carrito.getLineas()) {
			factura.getDetallesFactura().add(new DetalleFactura(factura, detalle.getProducto(), detalle.getCantidad()));
		}

		carritoNegocio.guardarFactura(factura);

		return "factura";
	}
}
