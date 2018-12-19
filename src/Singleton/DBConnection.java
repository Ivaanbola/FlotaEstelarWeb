package Singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	private static final String JDBC_URL = "jdbc:mysql://halifaxtraining.es:3306/ciberkaos003";
	private static Connection instance = null;

	private DBConnection() {
	}

	public static Connection getConnection() throws SQLException {

		if (instance == null) {
			Properties props = new Properties();
			props.put("user", "uss003");
			props.put("pasword", "pass003");
			instance = DriverManager.getConnection(JDBC_URL, props);
			crearTablas();
		}
		return instance;
	}

	public static void crearTablas() throws SQLException {
		tablaTripu();
		tablaNave();
		tablaMisiones();
		tablaSexo();
		tablaUsuarios();
		tablaBitacoras();
		inserts();
	}

	public static void tablaTripu() throws SQLException {
		PreparedStatement ps = getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS ussTripulantes ("
				+ "id int auto_increment primary key ," + "nombre varchar(255)," + "cargo varchar(255)," + "sexo int,"
				+ "experiencia int," + "origen varchar(255)," + "raza varchar(255)," + "edad int,"
				+ "foto varchar(255)," + "nave int" + ");");
		ps.executeUpdate();
		ps.close();
	}

	public static void tablaUsuarios() throws SQLException {
		PreparedStatement ps = getConnection()
				.prepareStatement("CREATE TABLE IF NOT EXISTS ussUsuarios (" + "  id int auto_increment primary key,"
						+ "  nombre varchar(255) NOT NULL," + "  contrasena varchar(255) NOT NULL" + ");");
		ps.executeUpdate();
		ps.close();
	}

	public static void tablaNave() throws SQLException {
		PreparedStatement ps = getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS ussNave ("
				+ "  id int auto_increment primary key ," + "  nombre varchar(255) NOT NULL,"
				+ "  capitan varchar(255) NOT NULL," + "  matricula varchar(255) NOT NULL,"
				+ "  tipo varchar(255) NOT NULL," + "  foto varchar(255) NOT NULL" + ");");
		ps.executeUpdate();
		ps.close();
	}

	public static void tablaBitacoras() throws SQLException {
		PreparedStatement ps = getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS ussBitacoras ("
				+ "  id int auto_increment primary key," + "  nave int(11) NOT NULL," + "  fecha date NOT NULL,"
				+ "  audio varchar(255) NOT NULL" + ");");
		ps.executeUpdate();
		ps.close();
	}

	public static void tablaMisiones() throws SQLException {
		PreparedStatement ps = getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS ussMisiones ("
				+ "  id int auto_increment primary key," + "  nombre varchar(255) NOT NULL,"
				+ "  nave int(11) NOT NULL," + "  descripcion text NOT NULL" + ");");
		ps.executeUpdate();
		ps.close();
	}

	public static void tablaSexo() throws SQLException {
		PreparedStatement ps = getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS ussSexo ("
				+ "  id int auto_increment primary key," + "  nombre varchar(255) NOT NULL" + "); ");
		ps.executeUpdate();
		ps.close();

	}

	public static void inserts() throws SQLException {
		insertHombre();
		insertMujer();
		insertUsuario();
	}

	public static void insertHombre() throws SQLException {
		PreparedStatement ps = getConnection().prepareStatement(
				"INSERT INTO usssexo (nombre) SELECT * FROM (SELECT 'Hombre') as tmp WHERE NOT EXISTS (SELECT nombre FROM usssexo WHERE nombre = 'Hombre') LIMIT 1;");
		ps.executeUpdate();
		ps.close();
	}

	public static void insertMujer() throws SQLException {
		PreparedStatement ps = getConnection().prepareStatement(
				"INSERT INTO usssexo (nombre) SELECT * FROM (SELECT 'Mujer') as tmp WHERE NOT EXISTS (SELECT nombre FROM usssexo WHERE nombre = 'Mujer') LIMIT 1; ");
		ps.executeUpdate();
		ps.close();
	}

	public static void insertUsuario() throws SQLException {

		PreparedStatement ps = getConnection().prepareStatement(
				"INSERT INTO ussusuarios (nombre, contrasena) SELECT * FROM (SELECT 'admin', '1234' ) as tmp WHERE NOT EXISTS (SELECT nombre FROM ussusuarios WHERE nombre = 'admin') LIMIT 1;  ");

		ps.executeUpdate();
		ps.close();
	}

}
