package com.ipartek.formacion.usuarioservlets.controladores.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.usuarioservlets.accesodatos.Dao;
import com.ipartek.formacion.usuarioservlets.accesodatos.UsuarioDaoMySql;
import com.ipartek.formacion.usuarioservlets.entidades.Usuario;

@WebServlet("/admin/usuarios")
public class UsuariosAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dao<Usuario> dao = new UsuarioDaoMySql();
		
		request.setAttribute("usuarios", dao.obtenerTodos());
		
		request.getRequestDispatcher("/WEB-INF/vistas/admin/usuarios.jsp").forward(request, response);
		
		// KISS: Keep It Simple Stupid
		// DRY: Don't Repeat Yourself
		// https://tantacom.com/principios-diseno-software-kiss-dry-solid/
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
