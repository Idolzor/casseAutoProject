package model;

import java.util.List;

public interface CategorieDAO {
	
	Categorie save(Categorie categorie);
	boolean removeById(int id);
	boolean update(Categorie categorie);
	Categorie findById(int id);
	List<Categorie> getAll();

}
