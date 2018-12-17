package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Singleton.DBConnection;
import modelo.Usuarios;

public class DAOUsuarios {
	private Connection con = null;

	public static DAOUsuarios instance = null;

	public DAOUsuarios() throws SQLException {
		con = DBConnection.getConnection();
	}

	public static DAOUsuarios getInstance() throws SQLException {
		if (instance == null)
			instance = new DAOUsuarios();
		return instance;
	}

	public Usuarios buscar(String nombre, String contraseña) throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM ussUsuarios WHERE nombre = ? and contrasena = ?");
		ps.setString(1, nombre);
		ps.setString(2, contraseña);
		ResultSet rs = ps.executeQuery();
		Usuarios result = null;
		if (rs.next()) {
			result = new Usuarios(rs.getString("nombre"), rs.getString("contrasena"));
		}
		rs.close();
		ps.close();
		return result;
	}

}
