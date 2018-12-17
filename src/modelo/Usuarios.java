package modelo;

import java.sql.SQLException;

import dao.DAOUsuarios;

public class Usuarios {
	private String usuario;
	private String contrasena;

	public Usuarios() {

	}
	
	public Usuarios( String usuario, String contraseña) {
		this.usuario = usuario;
		this.contrasena = contraseña;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public static boolean buscar(String nombre, String contrasena) {
		Usuarios e = null;
		try {
			e = DAOUsuarios.getInstance().buscar(nombre, contrasena);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		if (e == null) {
			return false;
		} else
			return true;
	}

}
