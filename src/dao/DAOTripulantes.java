package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Singleton.DBConnection;
import modelo.Tripulantes;

public class DAOTripulantes {
	private Connection con = null;

	public static DAOTripulantes instance = null;

	public DAOTripulantes() throws SQLException {
		con = DBConnection.getConnection();
	}

	public static DAOTripulantes getInstance() throws SQLException {
		if (instance == null)
			instance = new DAOTripulantes();
		return instance;
	}

	public void insert(Tripulantes t) throws SQLException {
		PreparedStatement ps = con.prepareStatement("INSERT INTO tripulantes"
				+ " (nombre, cargo, sexo, experiencia, origen, raza, edad, foto, nave) VALUES (?,?,?,?,?,?,?,?,?)");
		ps.setString(1, t.getNombre());
		ps.setString(2, t.getCargo());
		ps.setInt(3, t.getSexo());
		ps.setInt(4, t.getExperiencia());
		ps.setString(5, t.getOrigen());
		ps.setString(6, t.getRaza());
		ps.setInt(7, t.getEdad());
		ps.setString(8, t.getFoto());
		ps.setInt(9, t.getNave());
		ps.executeUpdate();
		ps.close();
	}

	public ArrayList<Tripulantes> listaTripulantes() throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * from tripulantes");
		ResultSet rs = ps.executeQuery();

		ArrayList<Tripulantes> result = null;

		while (rs.next()) {
			if (result == null)
				result = new ArrayList<>();
			result.add(new Tripulantes(rs.getInt("id"), rs.getString("nombre"), rs.getString("cargo"),
					rs.getInt("sexo"), rs.getInt("experiencia"), rs.getString("origen"), rs.getString("raza"),
					rs.getInt("edad"), rs.getString("foto"), rs.getInt("nave")));
		}
		rs.close();
		ps.close();
		return result;
	}

	public Tripulantes buscarID(int id) throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM tripulantes WHERE id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Tripulantes result = null;
		if (rs.next()) {
			result = new Tripulantes(rs.getInt("id"), rs.getString("nombre"), rs.getString("cargo"), rs.getInt("sexo"),
					rs.getInt("experiencia"), rs.getString("origen"), rs.getString("raza"), rs.getInt("edad"),
					rs.getString("foto"), rs.getInt("nave"));
		}
		rs.close();
		ps.close();
		return result;
	}

	public void delete(Tripulantes e) throws SQLException {
		delete(e.getId());
	}

	public void delete(int id) throws SQLException {
		if (id <= 0)
			return;

		PreparedStatement ps = con.prepareStatement("DELETE FROM tripulantes WHERE id = ?");
		ps.setInt(1, id);
		ps.executeUpdate();
		ps.close();
	}

	public void update(Tripulantes t) throws SQLException {
		if (t.getId() == 0)
			return;
		PreparedStatement ps = con
				.prepareStatement("UPDATE tripulantes SET nombre = ?, cargo = ?, sexo = ?, experiencia = ?, origen = ?,"
						+ "raza = ?, edad = ?,foto = ?,nave = ? WHERE id = ?");
		ps.setString(1, t.getNombre());
		ps.setString(2, t.getCargo());
		ps.setInt(3, t.getSexo());
		ps.setInt(4, t.getExperiencia());
		ps.setString(5, t.getOrigen());
		ps.setString(6, t.getRaza());
		ps.setInt(7, t.getEdad());
		ps.setString(8, t.getFoto());
		ps.setInt(9, t.getNave());
		ps.setInt(10, t.getId());

		ps.executeUpdate();
		ps.close();
	}

}
