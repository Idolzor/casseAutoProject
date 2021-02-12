package com.cda.dao1.sqlvehicule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.cda.dao.vehicule.VehiculeDAO;
import com.cda.model.vehicule.Vehicule;
import com.cda.tools.MyConnection;

public class VehiculeDaoImpl implements VehiculeDAO {

	@Override
	public Vehicule save(Vehicule vehicule) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement(
						"insert into vehicule (immatriculation, idModele ) values (?,(select idModele from modele where upper(nomModele) = upper(?) and anneeModele = ?));",
						PreparedStatement.RETURN_GENERATED_KEYS);

				ps.setString(1, vehicule.getImmatriculation());
				ps.setString(2, vehicule.getIdModele());
				ps.setInt(3, vehicule.getAnneeModele());
				ps.executeUpdate();
				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()) {
					vehicule.getImmatriculation(resultat.getString(1));
					return vehicule;
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
				PreparedStatement ps = c.prepareStatement("DELETE FROM vehicule WHERE immatriculation=?");
				ps.setString(1, nom);
				int nbDeleted = ps.executeUpdate();
				return nbDeleted == 1;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public List<Vehicule> getAll() {
		List<Vehicule> vehicule = new ArrayList<>();
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement statement = c.prepareStatement(
						"select immatriculation, modele.nomModele, modele.anneeModele, marque.nomMarque from vehicule inner join modele on vehicule.idModele = modele.idModele inner join marque on modele.idMarque = marque.idMarque;");
				ResultSet r = statement.executeQuery();

				while (r.next()) {
					vehicule.add(new Vehicule().setImmatriculation(r.getString("immatriculation"))
							.setNomModele(r.getString("modele.nomModele"))
							.setAnneeModele(r.getInt("modele.anneeModele"))
							.setNomMarque(r.getString("marque.nomMarque")));

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return vehicule;
	}

	@Override
	public Optional<Vehicule> findByName(String nom) {
		Connection c = MyConnection.getConnection();
		Vehicule res = null;
		if (c != null) {
			try {
				PreparedStatement ps = c
						.prepareStatement("select * from vehicule where upper(immatriculation) = upper(?)");
				ps.setString(1, nom);
				ResultSet r = ps.executeQuery();
				if (r.next()) {
					res = new Vehicule().setImmatriculation(r.getString("immatriculation"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return Optional.ofNullable(res);
	}

	@Override
	public Vehicule modify(Vehicule vehicule, String ancienNom) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement(
						"update vehicule set immatriculation = (?) where immatriculation = (?);",
						PreparedStatement.RETURN_GENERATED_KEYS);

				ps.setString(1, vehicule.getImmatriculation());
				ps.setString(2, ancienNom);
				ps.executeUpdate();
				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()) {
					vehicule.getImmatriculation(resultat.getString(1));
					return vehicule;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
