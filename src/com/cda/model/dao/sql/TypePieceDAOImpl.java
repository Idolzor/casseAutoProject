package com.cda.model.dao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.cda.model.TypePiece;
import com.cda.model.dao.TypePieceDAO;
import com.cda.tools.MyConnection;

public class TypePieceDAOImpl implements TypePieceDAO {

	@Override
	public TypePiece save(TypePiece typepiece) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement(
						"insert into typepiece(designation, idCategorie) values (?,(select idCategorie from categorie where upper(libelle) = upper(?))); ",
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, typepiece.getDesignation());
				ps.setString(2, typepiece.getIdCategorie());
				ps.executeUpdate();
				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()) {
					typepiece.getIdTypePiece(resultat.getInt(1));
					return typepiece;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<TypePiece> getAll() {
		List<TypePiece> typepiece = new ArrayList<>();
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement statement = c
						.prepareStatement("SELECT idTypePiece, designation, categorie.libelle FROM TypePiece"
								+ " inner join categorie on typepiece.idCategorie = categorie.idCategorie");
				ResultSet r = statement.executeQuery();

				while (r.next()) {
					typepiece.add(new TypePiece().setIdTypePiece(r.getInt("idTypePiece"))
							.setDesignation(r.getString("designation"))
							.setIdCategorie(r.getString("categorie.libelle")));

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return typepiece;
	}

	@Override
	public Optional<TypePiece> findByName(String nom) {
		Connection c = MyConnection.getConnection();
		TypePiece res = null;
		if (c != null) {
			try {
				PreparedStatement ps = c
						.prepareStatement("select * from typepiece where upper(designation) = upper(?)");
				ps.setString(1, nom);
				ResultSet r = ps.executeQuery();
				if (r.next()) {
					res = new TypePiece().setDesignation(r.getString("designation"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return Optional.ofNullable(res);
	}

	@Override
	public boolean removeByName(String nomSuppr) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("DELETE FROM typepiece WHERE designation=?");
				ps.setString(1, nomSuppr);
				int nbDeleted = ps.executeUpdate();
				return nbDeleted == 1;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
