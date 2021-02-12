package com.cda.dao.vehicule;

import java.util.List;
import java.util.Optional;

import com.cda.model.vehicule.Marque;

public interface MarqueDAO {

	Marque save(Marque marque);

	boolean removeByName(String nom);

	List<Marque> getAll();

	Optional<Marque> findByName(String nom);

	Marque modify(Marque marque, String ancienNom);

}
