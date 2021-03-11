package com.ipartek.formacion.ejemplofinal.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.ejemplofinal.entidades.Usuario;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(Config.PATH_VISTAS + "login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Usuario usuario = new Usuario(null, email, password, null);
		
		if(Config.usuarioNegocio.validarUsuario(usuario)) {
			request.getSession().setAttribute("usuario", usuario);
			request.getRequestDispatcher(Config.PATH_VISTAS + "index.jsp").forward(request, response);
		} else {
			request.setAttribute("usuario", usuario);
			request.getRequestDispatcher(Config.PATH_VISTAS + "login.jsp").forward(request, response);
		}
	}

}
