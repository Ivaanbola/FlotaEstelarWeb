package modelo;

import java.time.LocalDate;

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

}
