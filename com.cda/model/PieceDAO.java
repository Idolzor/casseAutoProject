package model;

import java.util.List;

public interface PieceDAO {
	
	Piece save(Piece piece);
	boolean removeById(int id);
	boolean update(Piece piece);
	Piece findById(int id);
	List<Piece> getAll();

}
