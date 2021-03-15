package com.ipartek.formacion.ejemplofinal.controladores;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.ejemplofinal.entidades.Carrito;
import com.ipartek.formacion.ejemplofinal.entidades.Cliente;
import com.ipartek.formacion.ejemplofinal.entidades.DetalleCarrito;
import com.ipartek.formacion.ejemplofinal.entidades.DetalleFactura;
import com.ipartek.formacion.ejemplofinal.entidades.Factura;
import com.ipartek.formacion.ejemplofinal.entidades.Usuario;

@WebServlet("/crear-factura")
public class CrearFacturaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cliente cliente;
		
		Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
		
		if(usuario != null && usuario.getCliente() != null) {
			cliente = usuario.getCliente();
		} else {
			cliente = (Cliente) request.getAttribute("cliente");
		}
		
		Carrito carrito = (Carrito) request.getSession().getAttribute("carrito");
		
		Factura factura = new Factura();
		
		factura.setFecha(LocalDate.now());
		factura.setCliente(cliente);
		
		for(DetalleCarrito detalle: carrito.getLineas()) {
			factura.getDetallesFactura().add(
					new DetalleFactura(factura, detalle.getProducto(), detalle.getCantidad()));
		}
		
		Config.carritoNegocio.guardarFactura(factura);
		
		request.setAttribute("factura", factura);
		
		request.getRequestDispatcher("/factura").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
