package com.cda.model.dao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.cda.model.Marque;
import com.cda.model.dao.MarqueDAO;
import com.cda.tools.MyConnection;

public class MarqueDAOImpl implements MarqueDAO {

	@Override
	public Marque save(Marque marque) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("insert into marque (nomMarque) values (?);",
						PreparedStatement.RETURN_GENERATED_KEYS);

				ps.setString(1, marque.getNom());
				ps.executeUpdate();
				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()) {
					marque.getId(resultat.getInt(1));
					return marque;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Marque modify(Marque marque, String ancienNom) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("update marque set nomMarque = (?) where nomMarque = (?);",
						PreparedStatement.RETURN_GENERATED_KEYS);

				ps.setString(1, marque.getNom());
				ps.setString(2, ancienNom);
				ps.executeUpdate();
				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()) {
					marque.getId(resultat.getInt(1));
					return marque;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public boolean removeByName(String nom) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("DELETE FROM marque WHERE nomMarque=?");
				ps.setString(1, nom);
				int nbDeleted = ps.executeUpdate();
				return nbDeleted == 1;
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
				PreparedStatement statement = c.prepareStatement("SELECT * FROM marque");
				ResultSet r = statement.executeQuery();

				while (r.next()) {
					marque.add(new Marque().setId(r.getInt("idMarque")).setNom(r.getString("nomMarque")));

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return marque;
	}

	@Override
	public Optional<Marque> findByName(String nom) {

		Connection c = MyConnection.getConnection();
		Marque res = null;
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("select * from marque where upper(nomMarque) = upper(?)");
				ps.setString(1, nom);
				ResultSet r = ps.executeQuery();
				if (r.next()) {
					res = new Marque().setNom(r.getString("nomMarque"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return Optional.ofNullable(res);
	}
}
