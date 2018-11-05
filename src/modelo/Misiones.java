package modelo;

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

}
