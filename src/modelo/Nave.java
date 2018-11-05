package modelo;

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

}
