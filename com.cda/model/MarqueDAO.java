package model;

import java.util.List;

public interface MarqueDAO {
	
	Marque save(Marque marque);
	boolean removeById(int id);
	boolean update(Marque marque);
	Piece findById(int id);
	List<Marque> getAll();

}
