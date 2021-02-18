package com.ipartek.formacion.usuarioservlets.controladores.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.usuarioservlets.accesodatos.UsuarioDao;
import com.ipartek.formacion.usuarioservlets.controladores.Configuracion;

@WebServlet("/admin/borrar")
public class UsuariosBorrarAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		Long i = Long.parseLong(id);
		
		UsuarioDao dao = Configuracion.daoUsuario;
		
		dao.borrar(i);
		
		response.sendRedirect(request.getContextPath() + "/admin/usuarios");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
