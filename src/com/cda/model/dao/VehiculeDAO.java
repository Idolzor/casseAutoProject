package com.cda.model.dao;

import java.util.List;
import java.util.Optional;

import com.cda.model.Vehicule;

public interface VehiculeDAO {

	Vehicule save(Vehicule vehicule);

	boolean removeByName(String nom);

	List<Vehicule> getAll();

	Optional<Vehicule> findByName(String nom);

	Vehicule modify(Vehicule marque, String ancienNom);

}
