package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Singleton.DBConnection;
import modelo.Nave;

public class DAONave {
	private Connection con = null;

	public static DAONave instance = null;

	public DAONave() throws SQLException {
		con = DBConnection.getConnection();
	}

	public static DAONave getInstance() throws SQLException {
		if (instance == null)
			instance = new DAONave();
		return instance;
	}

	public void insert(Nave n) throws SQLException {
		PreparedStatement ps = con
				.prepareStatement("INSERT INTO nave (nombre, capitan, matricula, tipo, foto) VALUES (?,?,?,?,?)");
		ps.setString(1, n.getNombre());
		ps.setString(2, n.getCapitan());
		ps.setString(3, n.getMatricula());
		ps.setString(4, n.getTipo());
		ps.setString(5, n.getFoto());
		ps.executeUpdate();
		ps.close();
	}

	public ArrayList<Nave> listaNave() throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * from nave");
		ResultSet rs = ps.executeQuery();

		ArrayList<Nave> result = null;

		while (rs.next()) {
			if (result == null)
				result = new ArrayList<>();
			result.add(new Nave(rs.getInt("id"), rs.getString("nombre"), rs.getString("capitan"),
					rs.getString("matricula"), rs.getString("tipo"), rs.getString("foto")));
		}
		rs.close();
		ps.close();
		return result;
	}

	public Nave buscarID(int id) throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM nave WHERE id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Nave result = null;
		if (rs.next()) {
			result = new Nave(rs.getInt("id"), rs.getString("nombre"), rs.getString("capitan"),
					rs.getString("matricula"), rs.getString("tipo"), rs.getString("foto"));
		}
		rs.close();
		ps.close();
		return result;
	}

	public void delete(Nave e) throws SQLException {
		delete(e.getId());
	}

	public void delete(int id) throws SQLException {
		if (id <= 0)
			return;

		PreparedStatement ps = con.prepareStatement("DELETE FROM nave WHERE id = ?");
		ps.setInt(1, id);
		ps.executeUpdate();
		ps.close();
	}

	public void update(Nave n) throws SQLException {
		if (n.getId() == 0)
			return;
		PreparedStatement ps = con.prepareStatement(
				"UPDATE nave SET nombre = ?, capitan = ?, matricula = ?, tipo = ?, foto = ? WHERE id = ?");
		ps.setString(1, n.getNombre());
		ps.setString(2, n.getCapitan());
		ps.setString(3, n.getMatricula());
		ps.setString(4, n.getTipo());
		ps.setString(5, n.getFoto());
		ps.setInt(6, n.getId());

		ps.executeUpdate();
		ps.close();
	}

}
