package com.cda.model.dao;
import java.util.List;

import com.cda.model.TypePiece;

public interface TypePieceDAO {
	TypePiece save(TypePiece typepiece);
	List<TypePiece> getAll();
}
