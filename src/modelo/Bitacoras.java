package modelo;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;


import dao.DAOBitacoras;

public class Bitacoras {
	private int id;
	private int nave;
	private LocalDate fecha;
	private String audio;

	public Bitacoras() {

	}

	public Bitacoras(int id, int nave, LocalDate fecha, String audio) {
		this.id = id;
		this.nave = nave;
		this.fecha = fecha;
		this.audio = audio;
	}

	public Bitacoras(int nave, LocalDate fecha, String audio) {
		this.nave = nave;
		this.fecha = fecha;
		this.audio = audio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNave() {
		return nave;
	}

	public void setNave(int nave) {
		this.nave = nave;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getAudio() {
		return audio;
	}

	public void setAudio(String audio) {
		this.audio = audio;
	}

	public ArrayList<Bitacoras> listarBitacoras() {
		ArrayList<Bitacoras> lista = null;
		try {
			lista = DAOBitacoras.getInstance().listaBitacoras();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public void buscarID(int id) {
		Bitacoras e = null;
		try {
			e = DAOBitacoras.getInstance().buscarID(id);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		if (e != null) {
			this.id = e.getId();
			this.nave = e.getNave();
			this.fecha = e.getFecha();
			this.audio = e.getAudio();
		}
	}

	public void insertar() {
		try {
			DAOBitacoras.getInstance().insert(this);
			System.out.println("Nuevo registro insertado");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void borrar() {
		try {
			DAOBitacoras.getInstance().delete(this);
			System.out.println("Registro eliminado");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void actualizar() {
		try {
			DAOBitacoras.getInstance().update(this);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
