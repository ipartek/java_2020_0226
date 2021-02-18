package com.ipartek.formacion.usuarioservlets.controladores;

import java.io.IOException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.logging.Logger;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.usuarioservlets.accesodatos.UsuarioDao;
import com.ipartek.formacion.usuarioservlets.entidades.Usuario;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger LOG = Logger.getLogger(LoginServlet.class.getName());

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		UsuarioDao dao = Configuracion.daoUsuario;

		Usuario usuario = dao.obtenerPorEmail(email);

		String hash = obtenerHash(password);

		String longitud = String.valueOf(hash.length());

		LOG.info(password);
		LOG.info(hash);
		LOG.info(longitud);

		if (hash.equals(usuario.getPassword())) {
			request.getSession().setAttribute("usuario", usuario);

			if ("ADMIN".equals(usuario.getRol().getNombre())) {
				response.sendRedirect(request.getContextPath() + "/admin/usuarios");
			} else {
				response.sendRedirect(request.getContextPath() + "/");
			}
		} else {
			request.setAttribute("mensaje", "El usuario o la contraseña son incorrectos");
			request.setAttribute("nivel", "danger");

			request.setAttribute("email", email);

			doGet(request, response);
		}
	}

	private String obtenerHash(String texto) {
		try {
//			SecureRandom random = new SecureRandom();
//			byte[] salt = new byte[16];
//			random.nextBytes(salt);

			byte[] salt = new byte[] { 1, 3, 7, -5, 3, 5, -67, -123, 123, 23, 56, 86, -23, 123, 21, 125 };

			KeySpec spec = new PBEKeySpec(texto.toCharArray(), salt, 65536, 128);
			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

			return Base64.getEncoder().encodeToString((factory.generateSecret(spec).getEncoded()));
		} catch (Exception e) {
			throw new ControladoresException("Error no esperado en el hashing del texto", e);
		}
	}
}
