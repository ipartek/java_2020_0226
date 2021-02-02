package com.ipartek.formacion.rest.servidorrestservlets.controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ipartek.formacion.rest.servidorrestservlets.entidades.Cliente;

@WebServlet({ "/api/clientes", "/api/clientes/*" })
public class ClienteApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static TreeMap<Long, Cliente> clientes = new TreeMap<>();
	private static Gson gson = new Gson();

	static {
		clientes.put(1L, new Cliente(1L, "Javier", LocalDate.now()));
		clientes.put(2L, new Cliente(2L, "Pepe", LocalDate.now()));
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		Long id = obtenerId(request);

		if (id == null) {
			out.write(gson.toJson(clientes.values()));
		} else {
			out.write(gson.toJson(clientes.get(id)));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cliente cliente = gson.fromJson(request.getReader(), Cliente.class);
		
		Long id = clientes.lastKey() + 1;
		
		cliente.setId(id);
		
		clientes.put(cliente.getId(), cliente);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cliente cliente = gson.fromJson(request.getReader(), Cliente.class);
		
		clientes.put(cliente.getId(), cliente);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long id = obtenerId(request);
		
		clientes.remove(id);
	}

	private Long obtenerId(HttpServletRequest request) {
		String path = request.getPathInfo();

		if (path == null || path.length() <= 1) {
			return null;
		}

		return Long.parseLong(path.substring(1));
	}
}
