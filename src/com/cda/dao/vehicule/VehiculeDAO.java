package com.cda.dao.vehicule;

import java.util.List;
import java.util.Optional;

import com.cda.model.vehicule.Vehicule;

public interface VehiculeDAO {

	Vehicule save(Vehicule vehicule);

	boolean removeByName(String nom);

	List<Vehicule> getAll();

	Optional<Vehicule> findByName(String nom);

	Vehicule modify(Vehicule marque, String ancienNom);

}
