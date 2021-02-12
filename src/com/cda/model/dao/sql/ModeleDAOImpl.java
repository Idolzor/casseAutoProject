package com.cda.model.dao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.cda.model.Marque;
import com.cda.model.Modele;
import com.cda.model.dao.ModeleDAO;
import com.cda.tools.MyConnection;

public class ModeleDAOImpl implements ModeleDAO {

	@Override
	public Modele save(Modele modele) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement(
						"insert into modele (nomModele, anneeModele, idMarque) values (?,?,(select idMarque from marque where upper(nomMarque) = upper(?)))",
						PreparedStatement.RETURN_GENERATED_KEYS);

				ps.setString(1, modele.getNom());
				ps.setInt(2, modele.getAnnee());
				ps.setString(3, modele.getIdMarque());
				ps.executeUpdate();
				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()) {
					modele.getId(resultat.getInt(1));
					return modele;
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
				PreparedStatement ps = c.prepareStatement("DELETE FROM modele WHERE nomModele=?");
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
	public List<Modele> getAll() {
		List<Modele> modele = new ArrayList<>();
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement statement = c
						.prepareStatement("SELECT idModele, nomModele, anneeModele, m.nomMarque FROM modele\r\n"
								+ "inner join marque m\r\n" + "where modele.idMarque = m.idMarque\r\n"
								+ "group by idmodele ;");
				ResultSet r = statement.executeQuery();

				while (r.next()) {
					modele.add(new Modele().setId(r.getInt("idModele")).setNom(r.getString("nomModele"))
							.setAnnee(r.getInt("anneeModele")).setIdMarque(r.getString("nomMarque")));

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return modele;
	}

	@Override
	public Optional<Modele> findByName(String nom) {
		Connection c = MyConnection.getConnection();
		Modele res = null;
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("select * from modele where upper(nomModele) = upper(?)");
				ps.setString(1, nom);
				ResultSet r = ps.executeQuery();
				if (r.next()) {
					res = new Modele().setNom(r.getString("nomModele"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return Optional.ofNullable(res);
	}

	@Override
	public Modele modify(Modele modele, String ancienNom) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("update modele set nomModele = (?) where nomModele = (?); ",
						PreparedStatement.RETURN_GENERATED_KEYS);

				ps.setString(1, modele.getNom());
				ps.setString(2, ancienNom);
				ps.executeUpdate();
				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()) {
					modele.getId(resultat.getInt(1));
					return modele;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Optional<Modele> findByAnnee(int annee) {
		Connection c = MyConnection.getConnection();
		Modele res = null;
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("select * from modele where upper(anneeModele) = (?)");
				ps.setInt(1, annee);
				ResultSet r = ps.executeQuery();
				if (r.next()) {
					res = new Modele().setAnnee(r.getInt("anneeModele"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return Optional.ofNullable(res);
	}

@Override
	public Modele modifyAnnee(Modele modele, int ancienneAnnee) {
	
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("update modele set anneeModele = (?) where anneeModele = (?); ",
						PreparedStatement.RETURN_GENERATED_KEYS);

				ps.setInt(1, modele.getAnnee());
				ps.setInt(2, ancienneAnnee);
				ps.executeUpdate();
				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()) {
					modele.getId(resultat.getInt(1));
					return modele;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
