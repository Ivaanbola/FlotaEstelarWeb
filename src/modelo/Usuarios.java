package modelo;

import java.sql.SQLException;

import dao.DAOUsuarios;

public class Usuarios {
	private String usuario;
	private String contraseña;

	public Usuarios() {

	}
	
	public Usuarios( String usuario, String contraseña) {
		this.usuario = usuario;
		this.contraseña = contraseña;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public static boolean buscar(String nombre, String contraseña) {
		Usuarios e = null;
		try {
			e = DAOUsuarios.getInstance().buscar(nombre, contraseña);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		if (e == null) {
			return false;
		} else
			return true;
	}

}
