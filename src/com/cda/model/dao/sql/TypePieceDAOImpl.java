package com.cda.model.dao.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
						"insert into typepiece(designation, idCategorie) values (?,?); ",
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, typepiece.getDesignation());
				ps.setInt(2, typepiece.getIdCategorie());
				ps.executeUpdate();
				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()) {
					typepiece.getIdCategorie(resultat.getInt(1));
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
				PreparedStatement statement = c.prepareStatement("SELECT * FROM TypePiece");
				ResultSet r = statement.executeQuery();

				while (r.next()) {
					typepiece.add(new TypePiece(r.getString("designation"), r.getInt("idCategorie")));

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return typepiece;
	}
}
