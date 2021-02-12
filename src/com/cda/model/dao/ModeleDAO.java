package com.cda.model.dao;

import java.util.List;
import java.util.Optional;

import com.cda.model.Modele;



public interface ModeleDAO {

	Modele save(Modele modele);
	boolean removeByName(String nom);
	List<Modele> getAll();
	Optional<Modele> findByName(String nom);
	Modele modify(Modele modele, String ancienNom);
	Optional<Modele> findByAnnee(int annee);
	Modele modifyAnnee(Modele modele, int nouvelleAnnee);
	
}
