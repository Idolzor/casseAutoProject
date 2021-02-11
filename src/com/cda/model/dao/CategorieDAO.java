package com.cda.model.dao;

import java.util.List;

import com.cda.model.Categorie;

public interface CategorieDAO {
	
	Categorie save(Categorie categorie);
	boolean removeById(int id);
	boolean update(Categorie categorie);
	Categorie findById(int id);
	List<Categorie> getAll();

}
