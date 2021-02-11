package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MarqueDAOImpl implements MarqueDAO {

	@Override
	public Marque save(Marque marque) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("insert into Marque (id_piece,reference) values (?,?); ",
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setInt(1, marque.getId_marque());
				ps.setString(2, marque.getNom_marque());
				ps.executeUpdate();
				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()) {
					marque.getId_marque(resultat.getInt(1));
					return marque;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Marque findById(int id) {
		Marque personne = null;
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("select * from Marque where id_piece = ?; ");
				ps.setInt(1, id);
				ResultSet r = ps.executeQuery();
				if (r.next()) {
					personne = new Marque(r.getInt("id_marque"), r.getString("libelle"));
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
				PreparedStatement ps = c.prepareStatement("DELETE FROM Marque WHERE NUM=?");
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
	public boolean update(Marque piece) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				String request = "UPDATE Marque SET id_piece=?, reference=? WHERE Marque=?";

				PreparedStatement statement = c.prepareStatement(request);
				statement.setInt(1, piece.getId_marque());
				statement.setString(2, piece.getNom_marque());
				int nbrUpdated = statement.executeUpdate();
				return nbrUpdated == 1;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public List<Marque> getAll() {
		List<Marque> marque = new ArrayList<>();
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement statement = c.prepareStatement("SELECT * FROM Piece");
				ResultSet r = statement.executeQuery();

				while (r.next()) {
					marque.add(new Marque(r.getInt("id_piece"), r.getString("reference")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return marque;
	}

}
