package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Singleton.DBConnection;
import modelo.Sexo;

public class DAOSexo {

	private Connection con = null;

	public static DAOSexo instance = null;

	public DAOSexo() throws SQLException {
		con = DBConnection.getConnection();
	}

	public static DAOSexo getInstance() throws SQLException {
		if (instance == null)
			instance = new DAOSexo();
		return instance;
	}

	public ArrayList<Sexo> listaSexo() throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * from ussSexo");
		ResultSet rs = ps.executeQuery();

		ArrayList<Sexo> result = null;

		while (rs.next()) {
			if (result == null)
				result = new ArrayList<>();
			result.add(new Sexo(rs.getInt("id"), rs.getString("nombre")));
		}
		rs.close();
		ps.close();
		return result;
	}

	public Sexo buscarID(int id) throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM ussSexo WHERE id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Sexo result = null;
		if (rs.next()) {
			result = new Sexo(rs.getInt("id"), rs.getString("nombre"));
		}
		rs.close();
		ps.close();
		return result;
	}

}
