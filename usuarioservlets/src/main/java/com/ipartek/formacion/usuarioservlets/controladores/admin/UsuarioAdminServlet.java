package com.ipartek.formacion.usuarioservlets.controladores.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.usuarioservlets.bibliotecas.Password;
import com.ipartek.formacion.usuarioservlets.controladores.Configuracion;
import com.ipartek.formacion.usuarioservlets.entidades.Usuario;

@WebServlet("/admin/usuario")
public class UsuarioAdminServlet extends HttpServlet {

	private static final long serialVersionUID = 6834979262616546726L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");

		if (id != null) {
			Usuario usuario = Configuracion.daoUsuario.obtenerPorId(Long.parseLong(id));

			request.setAttribute("usuario", usuario);
		}

		request.setAttribute("roles", Configuracion.daoRol.obtenerTodos());
		request.getRequestDispatcher("/WEB-INF/vistas/admin/usuario.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String rol = request.getParameter("rol");

		Usuario usuario;

		// TODO añadir borrado por POST

		if (id == null || id.trim().length() == 0 || id.trim().equals("0")) {
			// Inserción
			usuario = new Usuario(email, Password.obtenerHash(password), rol);
			
			Configuracion.daoUsuario.insertar(usuario);
		} else {
			usuario = new Usuario(id, email, Password.obtenerHash(password), rol);
			
			Configuracion.daoUsuario.modificar(usuario);
		}
		
		request.getRequestDispatcher("/admin/usuarios").forward(request, response);
	}

}
