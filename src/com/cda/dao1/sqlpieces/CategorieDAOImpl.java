package com.cda.dao1.sqlpieces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.cda.dao.pieces.CategorieDAO;
import com.cda.model.pieces.Categorie;
import com.cda.tools.MyConnection;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class CategorieDAOImpl implements CategorieDAO {

	Logger logger = LoggerFactory.getLogger(CategorieDAOImpl.class);

	@Override
	public Categorie save(Categorie categorie) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("insert into Categorie (libelle) values (?); ",
						PreparedStatement.RETURN_GENERATED_KEYS);

				ps.setString(1, categorie.getLibelle());
				ps.executeUpdate();
				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()) {
					categorie.getId_categorie(resultat.getInt(1));
					return categorie;
				}
			} catch (SQLException e) {
				System.out.println("oops, contacter le dev");
				logger.error("erreur", e);
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
				System.out.println("oops, contacter le dev");
				logger.error("erreur", e);
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
				System.out.println("oops, contacter le dev");
				logger.error("erreur", e);
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
				System.out.println("oops, contacter le dev");
				logger.error("erreur", e);
			}
		}
		return false;
	}

	public List<Categorie> getAll() {
		List<Categorie> categorie = new ArrayList<>();
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement statement = c.prepareStatement("SELECT * FROM categorie");
				ResultSet r = statement.executeQuery();
				while (r.next()) {
					categorie.add(new Categorie(r.getInt("idCategorie"), r.getString("libelle")));
				}
			} catch (SQLException e) {
				System.out.println("oops, contacter le dev");
				logger.error("erreur", e);
			}
		}
		return categorie;
	}

	@Override
	public Optional<Categorie> findByName(String nom) {
		Connection c = MyConnection.getConnection();
		Categorie res = null;
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("select * from categorie where upper(libelle) = upper(?)");
				ps.setString(1, nom);
				ResultSet r = ps.executeQuery();
				if (r.next()) {
					res = new Categorie().setLibelle(r.getString("libelle"));
				}
			} catch (SQLException e) {
				System.out.println("oops, contacter le dev");
				logger.error("erreur", e);
			}
		}
		return Optional.ofNullable(res);
	}

	@Override
	public boolean removeByName(String nomSuppr) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("DELETE FROM categorie WHERE libelle=?");
				ps.setString(1, nomSuppr);
				int nbDeleted = ps.executeUpdate();
				return nbDeleted == 1;
			} catch (SQLException e) {
				System.out.println("oops, contacter le dev");
				logger.error("erreur", e);
			}
		}
		return false;
	}

	@Override
	public Categorie modify(Categorie categorie, String ancienNom) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("update categorie set libelle = (?) where libelle = (?);",
						PreparedStatement.RETURN_GENERATED_KEYS);

				ps.setString(1, categorie.getLibelle());
				ps.setString(2, ancienNom);
				ps.executeUpdate();
				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()) {
					categorie.getId_categorie(resultat.getInt(1));
					return categorie;
				}
			} catch (SQLException e) {
				System.out.println("oops, contacter le dev");
				logger.error("erreur", e);
			}
		}
		return null;

	}

}
