package com.ipartek.formacion.usuarioservlets.controladores.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ipartek.formacion.usuarioservlets.controladores.Configuracion;

@WebServlet("/api/roles/*")
public class RolesRestServlet extends HttpServlet {
	private static final Logger LOG = Logger.getLogger(RolesRestServlet.class.getName());
	
	private static final long serialVersionUID = 1L;
    
	private static final Gson gson = new Gson();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String ruta = request.getPathInfo();
		
		if(ruta == null || "/".equals(ruta)) {
			// /api/roles
			
			out.write(gson.toJson(Configuracion.daoRol.obtenerTodos()));
		} else {
			// /api/roles/1/usuarios
			
			String[] datos = ruta.split("/");
			
			for(String dato: datos) {
				LOG.info(dato);
			}
			
			String id = datos[1];
			String conjunto = datos[2];
			
			if(datos.length == 3 && id.matches("\\d+") && "usuarios".equals(conjunto)) {
				out.write(gson.toJson(Configuracion.daoUsuario.obtenerPorIdRol(Long.parseLong(id))));
			}
		}
	}
}
