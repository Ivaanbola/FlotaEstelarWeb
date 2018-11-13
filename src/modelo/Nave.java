package modelo;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAONave;

public class Nave {
	private int id;
	private String capitan;
	private String nombre;
	private String matricula;
	private String tipo;
	private String foto;

	public Nave() {

	}

	public Nave(String nombre, String capitan, String matricula, String tipo, String foto) {
		this.capitan = capitan;
		this.nombre = nombre;
		this.matricula = matricula;
		this.tipo = tipo;
		this.foto = foto;
	}

	public Nave(int id, String nombre, String capitan, String matricula, String tipo, String foto) {
		this.id = id;
		this.capitan = capitan;
		this.nombre = nombre;
		this.matricula = matricula;
		this.tipo = tipo;
		this.foto = foto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCapitan() {
		return capitan;
	}

	public void setCapitan(String capitan) {
		this.capitan = capitan;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public ArrayList<Nave> listarNaves() {
		ArrayList<Nave> lista = null;
		try {
			lista = DAONave.getInstance().listaNave();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public void buscarID(int id) {
		Nave e = null;
		try {
			e = DAONave.getInstance().buscarID(id);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		if (e != null) {
			this.capitan = e.getCapitan();
			this.foto = e.getFoto();
			this.id = e.getId();
			this.nombre = e.getNombre();
			this.tipo = e.getTipo();
			this.matricula = e.getMatricula();
		}
	}

	public void insertar() {
		try {
			DAONave.getInstance().insert(this);
			System.out.println("Nuevo registro insertado");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void borrar() {
		try {
			DAONave.getInstance().delete(this);
			System.out.println("Registro eliminado");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void actualizar() {
		try {
			DAONave.getInstance().update(this);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
