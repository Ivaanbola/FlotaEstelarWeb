package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Singleton.DBConnection;
import modelo.Bitacoras;

public class DAOBitacoras {
	private Connection con = null;

	public static DAOBitacoras instance = null;

	public DAOBitacoras() throws SQLException {
		con = DBConnection.getConnection();
	}

	public static DAOBitacoras getInstance() throws SQLException {
		if (instance == null)
			instance = new DAOBitacoras();
		return instance;
	}
	
	public void insert(Bitacoras n) throws SQLException {
		PreparedStatement ps = con
				.prepareStatement("INSERT INTO ussBitacoras (nave, fecha, audio) VALUES (?,?,?)");
		ps.setInt(1, n.getNave());
		ps.setDate(2, Date.valueOf(n.getFecha()));
		ps.setString(3, n.getAudio());
		ps.executeUpdate();
		ps.close();
	}
	
	public ArrayList<Bitacoras> listaBitacoras() throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * from ussBitacoras");
		ResultSet rs = ps.executeQuery();

		ArrayList<Bitacoras> result = null;

		while (rs.next()) {
			if (result == null)
				result = new ArrayList<>();
			result.add(new Bitacoras(rs.getInt("id"), rs.getInt("nave"), rs.getDate("fecha").toLocalDate(),
					rs.getString("audio")));
		}
		rs.close();
		ps.close();
		return result;
	}
	
	public Bitacoras buscarID(int id) throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM ussBitacoras WHERE id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Bitacoras result = null;
		if (rs.next()) {
			result = new Bitacoras(rs.getInt("id"), rs.getInt("nave"), rs.getDate("fecha").toLocalDate(),
					rs.getString("audio"));
		}
		rs.close();
		ps.close();
		return result;
	}
	
	public void delete(Bitacoras e) throws SQLException {
		delete(e.getId());
	}

	public void delete(int id) throws SQLException {
		if (id <= 0)
			return;

		PreparedStatement ps = con.prepareStatement("DELETE FROM ussBitacoras WHERE id = ?");
		ps.setInt(1, id);
		ps.executeUpdate();
		ps.close();
	}

	public void update(Bitacoras n) throws SQLException {
		if (n.getId() == 0)
			return;
		PreparedStatement ps = con.prepareStatement(
				"UPDATE ussBitacoras SET nave = ?, fecha = ?, audio = ? WHERE id = ?");
		ps.setInt(1, n.getNave());
		ps.setDate(2, Date.valueOf(n.getFecha()));
		ps.setString(3, n.getAudio());
		ps.setInt(4, n.getId());

		ps.executeUpdate();
		ps.close();
	}
	
}
