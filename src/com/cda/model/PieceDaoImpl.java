package com.cda.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cda.tools.MyConnection;

public class PieceDaoImpl implements PieceDAO {

	@Override
	public Piece save(Piece piece) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("insert into Piece (id_piece,reference) values (?,?); ",
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setInt(1, piece.getId_piece());
				ps.setString(2, piece.getReference());
				ps.executeUpdate();
				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()) {
					piece.getId_piece(resultat.getInt(1));
					return piece;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Piece findById(int id) {
		Piece personne = null;
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("select * from Piece where id_piece = ?; ");
				ps.setInt(1, id);
				ResultSet r = ps.executeQuery();
				if (r.next()) {
					personne = new Piece(r.getInt("id_piece"), r.getString("reference"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return personne;
	}

	@Override
	public boolean removeById(int id) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("DELETE FROM Piece WHERE NUM=?");
				ps.setInt(1, id);
				int nbDeleted = ps.executeUpdate();
				return nbDeleted == 1;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean update(Piece piece) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				String request = "UPDATE Piece SET id_piece=?, reference=? WHERE Piece=?";

				PreparedStatement statement = c.prepareStatement(request);
				statement.setInt(1, piece.getId_piece());
				statement.setString(2, piece.getReference());
				int nbrUpdated = statement.executeUpdate();
				return nbrUpdated == 1;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public List<Piece> getAll() {
		List<Piece> piece = new ArrayList<>();
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement statement = c.prepareStatement("SELECT * FROM Piece");
				ResultSet r = statement.executeQuery();

				while (r.next()) {
					piece.add(new Piece(r.getInt("id_piece"), r.getString("reference")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return piece;
	}
}
