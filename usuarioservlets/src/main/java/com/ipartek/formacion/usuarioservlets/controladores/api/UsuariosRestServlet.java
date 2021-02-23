package com.ipartek.formacion.usuarioservlets.controladores.api;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ipartek.formacion.usuarioservlets.accesodatos.UsuarioDao;
import com.ipartek.formacion.usuarioservlets.controladores.Configuracion;
import com.ipartek.formacion.usuarioservlets.entidades.Usuario;

@WebServlet("/api/usuarios/*")
public class UsuariosRestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final Logger LOG = Logger.getLogger(UsuariosRestServlet.class.getName());
	private static final Gson gson = new Gson();
	
	private static final UsuarioDao dao = Configuracion.daoUsuario;
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = gson.fromJson(request.getReader(), Usuario.class);
		
		LOG.info(usuario.toString());
		LOG.info(usuario.getRol().toString());
		
		dao.modificarSinPassword(usuario);
	}
}
