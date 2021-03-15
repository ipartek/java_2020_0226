package com.ipartek.formacion.ejemplofinal.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.ejemplofinal.entidades.Cliente;
import com.ipartek.formacion.ejemplofinal.entidades.Usuario;

@WebServlet("/confirmar-compra")
public class ConfirmarCompraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String raiz = request.getContextPath() + "/";
		
		final Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
		
		// Usuario anónimo
		if(usuario == null) {
			response.sendRedirect(raiz + "cliente");
		} else {
			Cliente cliente = usuario.getCliente();
			
			if(cliente == null) {
				response.sendRedirect(raiz + "cliente");
			} else {
				response.sendRedirect(raiz + "crear-factura");
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
