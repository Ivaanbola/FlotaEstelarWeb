package modelo;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAOMisiones;

public class Misiones {
	private int id;
	private String nombre;
	private int nave;
	private String descripcion;

	public Misiones() {

	}

	public Misiones(int id, String nombre, int nave, String descripcion) {
		this.id = id;
		this.nombre = nombre;
		this.nave = nave;
		this.descripcion = descripcion;
	}

	public Misiones(String nombre, int nave, String descripcion) {
		this.nombre = nombre;
		this.nave = nave;
		this.descripcion = descripcion;
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

	public int getNave() {
		return nave;
	}

	public void setNave(int nave) {
		this.nave = nave;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public ArrayList<Misiones> listarMisiones() {
		ArrayList<Misiones> lista = null;
		try {
			lista = DAOMisiones.getInstance().listaMisiones();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public void buscarID(int id) {
		System.out.println("Búsqueda de una nave");
		Misiones e = null;
		try {
			e = DAOMisiones.getInstance().buscarID(id);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		if (e != null) {
			this.id = e.getId();
			this.nave = e.getNave();
			this.nombre=e.getNombre();
			this.descripcion = e.getDescripcion();
		}
	}
	
	public void insertar() {
		try {
			DAOMisiones.getInstance().insert(this);
			System.out.println("Nuevo registro insertado");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void borrar() {
		try {
			DAOMisiones.getInstance().delete(this);
			System.out.println("Registro eliminado");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void actualizar() {
		try {
			DAOMisiones.getInstance().update(this);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
