package com.ipartek.formacion.usuarioservlets.entidades;

import java.io.Serializable;

public class Usuario implements Serializable {

	private static final long serialVersionUID = 5009408407679518258L;
	
	private Long id;
	private String email;
	private String password;
	
	private Rol rol;
	
	/**
	 * Constructor de conveniencia para recibir datos de una capa de presentación, directamente en formato String
	 * @param id id en formato String
	 * @param email igual que lo pasaríamos al constructor principal
	 * @param password igual que lo pasaríamos al contructor principal
	 * @param rol sólo el id de rol, sin más información (en formato texto)
	 */
	public Usuario(String id, String email, String password, String rol) {
		this(Long.parseLong(id), email, password, new Rol(Long.parseLong(rol), null, null));
	}
	
	public Usuario(String email, String password, String rol) {
		this(null, email, password, new Rol(Long.parseLong(rol), null, null));
	}
	
	
	public Usuario(Long id, String email, String password, Rol rol) {
		setId(id);
		setEmail(email);
		setPassword(password);
		setRol(rol);
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", password=" + password + "]";
	}
	
	
}
