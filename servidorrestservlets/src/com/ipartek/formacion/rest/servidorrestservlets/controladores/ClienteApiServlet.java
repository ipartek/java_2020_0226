package com.ipartek.formacion.rest.servidorrestservlets.controladores;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ipartek.formacion.rest.servidorrestservlets.accesodatos.ClienteDaoTreeMap;
import com.ipartek.formacion.rest.servidorrestservlets.accesodatos.Dao;
import com.ipartek.formacion.rest.servidorrestservlets.entidades.Cliente;

@WebServlet({ "/api/clientes", "/api/clientes/*" })
public class ClienteApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Gson gson = new Gson();

	private static Dao<Cliente> dao = new ClienteDaoTreeMap();
	
	// /api/clientes	Todos los registros
	// /api/clientes/1	Registro con id concreto
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		Long id = obtenerId(request);

		if (id == null) {
			out.write(gson.toJson(dao.obtenerTodos()));
		} else {
			Cliente cliente = dao.obtenerPorId(id);
			
			if(cliente != null) {
				out.write(gson.toJson(cliente));
			} else {
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			}
		}
	}

	// /api/clientes	Crear nuevo registro
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cliente cliente = gson.fromJson(request.getReader(), Cliente.class);
		
		cliente = dao.insertar(cliente);
		
		response.getWriter().write(gson.toJson(cliente));
		
		response.setStatus(HttpServletResponse.SC_CREATED);
	}

	// /api/clientes/1	Modificar registro existente
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cliente cliente = gson.fromJson(request.getReader(), Cliente.class);
		
		Long id = obtenerId(request);
		
		if(id == cliente.getId()) {
			dao.modificar(cliente);
			
			response.getWriter().write(gson.toJson(cliente));
		} else {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}

	// /api/clientes/1	Borrar registro existente
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long id = obtenerId(request);
		
		try {
			dao.borrar(id);
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		} catch(Exception e) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
	}

	private Long obtenerId(HttpServletRequest request) {
		String path = request.getPathInfo();

		if (path == null || path.length() <= 1) {
			return null;
		}

		return Long.parseLong(path.substring(1));
	}
}
