package com.cda.model.dao;

import java.util.List;
import java.util.Optional;

import com.cda.model.Categorie;
import com.cda.model.Marque;

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
