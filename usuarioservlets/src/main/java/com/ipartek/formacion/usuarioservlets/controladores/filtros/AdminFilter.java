package com.ipartek.formacion.usuarioservlets.controladores.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.usuarioservlets.entidades.Usuario;

@WebFilter("/admin/*")
public class AdminFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");
			
		if(usuario != null && usuario.getRol() != null && "ADMIN".equals(usuario.getRol().getNombre())) {
			chain.doFilter(request, response);
		} else {
			request.setAttribute("mensaje", "Se necesita un usuario con privilegios administrativos para poder entrar en la zona de administración");
			request.setAttribute("nivel", "danger");
			
			req.getRequestDispatcher("/login").forward(request, response);
		}
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {}
	
	@Override
	public void destroy() {}
}
