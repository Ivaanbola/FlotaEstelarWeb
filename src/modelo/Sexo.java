package modelo;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAONave;
import dao.DAOSexo;

public class Sexo {

	private String nombre;
	private int id;

	public Sexo() {
	}

	public Sexo(int id, String sexo) {
		this.nombre = sexo;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Sexo> listarSexo() {
		ArrayList<Sexo> lista = null;
		try {
			lista = DAOSexo.getInstance().listaSexo();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public void buscarID(int id) {
		Sexo e = null;
		try {
			e = DAOSexo.getInstance().buscarID(id);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		if (e != null) {
			this.id = e.getId();
			this.nombre = e.getNombre();
		}
	}

}
