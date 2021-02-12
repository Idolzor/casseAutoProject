package com.cda.dao.pieces;

import java.util.List;
import java.util.Optional;

import com.cda.model.pieces.Relation;

public interface RelationDAO {

	Relation save(Relation relation);
	Optional<Relation> findByName(String relation);
	boolean removeByName(String nomSuppr, String typePiece);
	List<Relation> getAll();
	
	
	
}
