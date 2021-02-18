package com.ipartek.formacion.usuarioservlets.controladores.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.usuarioservlets.controladores.Configuracion;

@WebServlet("/admin/usuario")
public class UsuarioAdminServlet extends HttpServlet {

	private static final long serialVersionUID = 6834979262616546726L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("roles", Configuracion.daoRol.obtenerTodos());
		request.getRequestDispatcher("/WEB-INF/vistas/admin/usuario.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
