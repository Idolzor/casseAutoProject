package com.cda.model.dao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cda.model.Categorie;
import com.cda.model.dao.CategorieDAO;
import com.cda.tools.MyConnection;

public class CategorieDAOImpl implements CategorieDAO {
	
	@Override
	public Categorie save(Categorie categorie) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("insert into Categorie (id_piece,reference) values (?,?); ",
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setInt(1, categorie.getId_categorie());
				ps.setString(2, categorie.getLibelle());
				ps.executeUpdate();
				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()) {
					categorie.getId_categorie(resultat.getInt(1));
					return categorie;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Categorie findById(int id) {
		Categorie personne = null;
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("select * from Categorie where id_piece = ?; ");
				ps.setInt(1, id);
				ResultSet r = ps.executeQuery();
				if (r.next()) {
					personne = new Categorie(r.getInt("id_categorie"), r.getString("libelle"));
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
				PreparedStatement ps = c.prepareStatement("DELETE FROM Categorie WHERE NUM=?");
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
	public boolean update(Categorie categorie) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				String request = "UPDATE Piece SET id_categorie=?, libelle=? WHERE Categorie=?";

				PreparedStatement statement = c.prepareStatement(request);
				statement.setInt(1, categorie.getId_categorie());
				statement.setString(2, categorie.getLibelle());
				int nbrUpdated = statement.executeUpdate();
				return nbrUpdated == 1;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public List<Categorie> getAll() {
		List<Categorie> categorie = new ArrayList<>();
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement statement = c.prepareStatement("SELECT * FROM Categorie");
				ResultSet r = statement.executeQuery();

				while (r.next()) {
					categorie.add(new Categorie(r.getInt("id_categorie"), r.getString("libelle")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return categorie;
	}

}
