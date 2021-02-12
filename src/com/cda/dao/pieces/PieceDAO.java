package com.cda.dao.pieces;

import java.util.List;

import com.cda.model.pieces.Piece;

public interface PieceDAO {
	
	Piece save(Piece piece);
	boolean removeById(int id);
	boolean update(Piece piece);
	Piece findById(int id);
	List<Piece> getAll();

}
