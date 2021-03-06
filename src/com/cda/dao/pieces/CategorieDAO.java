package com.cda.dao.pieces;

import java.util.List;
import java.util.Optional;

import com.cda.model.pieces.Categorie;
import com.cda.model.vehicule.Marque;

public interface CategorieDAO {
	
	Categorie save(Categorie categorie);
	boolean removeById(int id);
	boolean update(Categorie categorie);
	Categorie findById(int id);
	List<Categorie> getAll();
	Optional<Categorie> findByName(String nom);
	boolean removeByName(String nomSuppr);
	Categorie modify(Categorie setLibelle, String ancienNom);


}
