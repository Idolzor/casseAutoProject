package com.cda.dao1.sqlpieces;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.cda.dao.pieces.PieceDAO;
import com.cda.model.pieces.Piece;
import com.cda.tools.MyConnection;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class PieceDaoImpl implements PieceDAO {
	Logger log = LoggerFactory.getLogger(PieceDaoImpl.class);

	@Override
	public Piece save(Piece piece) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement(
						"insert into Piece (dateRecuperation, prixVente, immatriculation, idTypePiece)"
								+ " values (?,?,?,"
								+ "(select idTypePiece from typepiece where lower(designation) = lower(?)));",
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, piece.getDateRecup());
				ps.setFloat(2, piece.getPrixVente());
				ps.setString(3, piece.getImmatriculation());
				ps.setString(4, piece.getIdTypePiece());
			
				System.out.println(ps);
				ps.executeUpdate();
				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()) {
					piece.getIdPiece(resultat.getInt(1));
					return piece;
				}
			} catch (SQLException e) {
				System.out.println("oops, contacter le dev");
				log.error("erreur", e);
			}
		}
		return null;
	}

	@Override
	public boolean update(Piece piece) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				String request = "update piece set dateVente =? where idTypePiece = (select distinct idTypePiece from typepiece where designation = ?)  order by dateVente limit 1;";

				PreparedStatement statement = c.prepareStatement(request);

				statement.setString(1, piece.getDateVente());
				statement.setString(2,piece.getIdTypePiece());
				
				
				int nbrUpdated = statement.executeUpdate();
				return nbrUpdated == 1;
			} catch (SQLException e) {
				System.out.println("oops, contacter le dev");
				log.error("erreur", e);
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
					piece.add(new Piece());
				}
			} catch (SQLException e) {
				System.out.println("oops, contacter le dev");
				log.error("erreur", e);
			}
		}
		return piece;
	}

	@Override
	public Optional<Piece> findByName(String immat) {
		// TODO Auto-generated method stub
		return null;
	}
}
