package modelo;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAOTripulantes;

public class Tripulantes {
	private int id;
	private String nombre;
	private String cargo;
	private int sexo;
	private int experiencia;
	private String origen;
	private String raza;
	private int edad;
	private String foto;
	private int nave;

	public Tripulantes() {

	}

	public Tripulantes(int id, String nombre, String cargo, int sexo, int experiencia, String origen, String raza,
			int edad, String foto, int nave) {
		this.id = id;
		this.nombre = nombre;
		this.cargo = cargo;
		this.sexo = sexo;
		this.experiencia = experiencia;
		this.origen = origen;
		this.raza = raza;
		this.edad = edad;
		this.foto = foto;
		this.nave = nave;
	}

	public Tripulantes(String nombre, String cargo, int sexo, int experiencia, String origen, String raza, int edad,
			String foto, int nave) {
		this.nombre = nombre;
		this.cargo = cargo;
		this.sexo = sexo;
		this.experiencia = experiencia;
		this.origen = origen;
		this.raza = raza;
		this.edad = edad;
		this.foto = foto;
		this.nave = nave;
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

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public int getSexo() {
		return sexo;
	}

	public void setSexo(int sexo) {
		this.sexo = sexo;
	}

	public int getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public int getNave() {
		return nave;
	}

	public void setNave(int nave) {
		this.nave = nave;
	}

	public ArrayList<Tripulantes> listarTripulantes() {
		ArrayList<Tripulantes> lista = null;
		try {
			lista = DAOTripulantes.getInstance().listaTripulantes();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public void buscarID(int id) {
		Tripulantes e = null;
		try {
			e = DAOTripulantes.getInstance().buscarID(id);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		if (e != null) {
			this.id = e.getId();
			this.nombre = e.getNombre();
			this.cargo = e.getCargo();
			this.sexo = e.getSexo();
			this.experiencia = e.getExperiencia();
			this.origen = e.getOrigen();
			this.raza = e.getRaza();
			this.edad = e.getEdad();
			this.foto = e.getFoto();
			this.nave = e.getNave();
		}
	}

	public void insertar(){
		try {
			DAOTripulantes.getInstance().insert(this);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void borrar() {
		try {
			DAOTripulantes.getInstance().delete(this);
			System.out.println("Registro eliminado");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void actualizar() {
		try {
			DAOTripulantes.getInstance().update(this);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
