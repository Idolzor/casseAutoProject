package com.cda.model.dao;
import java.util.List;
import java.util.Optional;

import com.cda.model.TypePiece;

public interface TypePieceDAO {
	TypePiece save(TypePiece typepiece);
	List<TypePiece> getAll();
	Optional<TypePiece> findByName(String immat);
	boolean removeByName(String nomSuppr);
}
