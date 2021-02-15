package com.cda.dao1.sqlpieces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.cda.dao.pieces.RelationDAO;
import com.cda.model.pieces.Relation;
import com.cda.model.pieces.TypePiece;
import com.cda.tools.MyConnection;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class RelationDAOImpl implements RelationDAO {
	Logger log = LoggerFactory.getLogger(RelationDAOImpl.class);

	@Override
	public Relation save(Relation relation) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("insert into convenir(idTypePiece, idModele) values "
						+ "((select idTypePiece from typepiece where lower(designation) = lower(?) and idCategorie = "
						+ "(select idCategorie from categorie where upper(libelle) = upper(?))),"
						+ "(select idModele from modele where upper(nomModele) = upper(?) and anneeModele = ?)); ",
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, relation.getDesignation());
				ps.setString(2, relation.getIdCategorie());
				ps.setString(3, relation.getNomModele());
				ps.setInt(4, relation.getAnneeModele());
				System.out.println(ps);
				ps.executeUpdate();
				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()) {
					relation.getIdTypePiece(resultat.getInt(1));
					return relation;
				}
			} catch (SQLException e) {
				System.out.println("oops, contacter le dev");
				log.error("erreur", e);
			}
		}
		return null;
	}

	@Override
	public Optional<Relation> findByName(String immat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Relation> getAll() {
		List<Relation> relation = new ArrayList<>();
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement statement = c.prepareStatement(
						"SELECT convenir.idTypePiece, typepiece.designation, modele.nomModele, modele.anneeModele FROM convenir"
								+ " inner join typepiece on convenir.idTypePiece = typepiece.idTypePiece "
								+ "inner join modele on convenir.idModele = modele.idModele");
				ResultSet r = statement.executeQuery();

				while (r.next()) {
					relation.add(new Relation().setIdTypePiece(r.getInt("convenir.idTypePiece"))
							.setDesignation(r.getString("typepiece.designation"))
							.setNomModele(r.getString("modele.nomModele"))
							.setAnneeModele(r.getInt("modele.anneeModele")));

				}
			} catch (SQLException e) {
				System.out.println("oops, contacter le dev");
				log.error("erreur", e);
			}
		}
		return relation;
	}

	@Override
	public boolean removeByName(String categoriePieceSuppr, String typePiece) {

		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement(
						"DELETE FROM convenir WHERE idTypePiece= (select idTypePiece from typepiece where lower(designation) = lower(?) and idCategorie = (select idCategorie from categorie where upper(libelle) = upper(?))) ");
				ps.setString(1, typePiece);
				ps.setString(2, categoriePieceSuppr);
				int nbDeleted = ps.executeUpdate();
				return nbDeleted == 1;
			} catch (SQLException e) {
				System.out.println("oops, contacter le dev");
				log.error("erreur", e);
			}
		}
		return false;
	}

}
