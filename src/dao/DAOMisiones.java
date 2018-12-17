package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Singleton.DBConnection;
import modelo.Misiones;

public class DAOMisiones {
	private Connection con = null;

	public static DAOMisiones instance = null;

	public DAOMisiones() throws SQLException {
		con = DBConnection.getConnection();
	}

	public static DAOMisiones getInstance() throws SQLException {
		if (instance == null)
			instance = new DAOMisiones();
		return instance;
	}
	
	public void insert(Misiones n) throws SQLException {
		PreparedStatement ps = con
				.prepareStatement("INSERT INTO ussMisiones (nombre, nave, descripcion) VALUES (?,?,?)");
		ps.setString(1, n.getNombre());
		ps.setInt(2, n.getNave());
		ps.setString(3, n.getDescripcion());
		ps.executeUpdate();
		ps.close();
	}
	
	public ArrayList<Misiones> listaMisiones() throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * from ussMisiones");
		ResultSet rs = ps.executeQuery();

		ArrayList<Misiones> result = null;

		while (rs.next()) {
			if (result == null)
				result = new ArrayList<>();
			result.add(new Misiones(rs.getInt("id"), rs.getString("nombre"), rs.getInt("nave"),
					rs.getString("descripcion")));
		}
		rs.close();
		ps.close();
		return result;
	}
	
	public Misiones buscarID(int id) throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM ussMisiones WHERE id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Misiones result = null;
		if (rs.next()) {
			result =new Misiones(rs.getInt("id"), rs.getString("nombre"), rs.getInt("nave"),
					rs.getString("descripcion"));
		}
		rs.close();
		ps.close();
		return result;
	}
	
	public void delete(Misiones e) throws SQLException {
		delete(e.getId());
	}

	public void delete(int id) throws SQLException {
		if (id <= 0)
			return;

		PreparedStatement ps = con.prepareStatement("DELETE FROM ussMisiones WHERE id = ?");
		ps.setInt(1, id);
		ps.executeUpdate();
		ps.close();
	}
	
	public void update(Misiones n) throws SQLException {
		if (n.getId() == 0)
			return;
		PreparedStatement ps = con.prepareStatement(
				"UPDATE ussMisiones SET nombre = ?, nave = ?, descripcion = ? WHERE id = ?");
		ps.setString(1, n.getNombre());
		ps.setInt(2, n.getNave());
		ps.setString(3, n.getDescripcion());
		ps.setInt(4, n.getId());

		ps.executeUpdate();
		ps.close();
	}
	
}
