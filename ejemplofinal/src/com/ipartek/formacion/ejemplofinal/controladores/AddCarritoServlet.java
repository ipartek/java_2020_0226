package com.ipartek.formacion.ejemplofinal.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.ejemplofinal.entidades.Carrito;
import com.ipartek.formacion.ejemplofinal.entidades.Producto;

@WebServlet("/add-carrito")
public class AddCarritoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		
		Producto producto = Config.carritoNegocio.productoPorId(Long.parseLong(id));
		
		Carrito carrito = (Carrito) session.getAttribute("carrito");
		
		carrito.addProducto(producto, 1);
		
		request.getRequestDispatcher(Config.PATH_VISTAS + "carrito.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
