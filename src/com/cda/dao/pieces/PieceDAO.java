package com.cda.dao.pieces;

import java.util.List;
import java.util.Optional;

import com.cda.model.pieces.Piece;
import com.cda.model.pieces.TypePiece;

public interface PieceDAO {
	
	Piece save(Piece piece);
	boolean update(Piece piece);
	Optional<Piece> findByName(String immat);
	List<Piece> getAll();

}
