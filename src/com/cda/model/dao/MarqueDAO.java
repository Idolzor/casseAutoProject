package com.cda.model.dao;

import java.util.List;
import java.util.Optional;

import com.cda.model.Marque;

public interface MarqueDAO {
	
	Marque save(Marque marque);
	boolean removeByName(String nom);
	List<Marque> getAll();
	Optional<Marque> findByName(String nom);
	Marque modify(Marque marque, String ancienNom);

}
