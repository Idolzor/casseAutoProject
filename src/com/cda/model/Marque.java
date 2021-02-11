package com.cda.model;

public class Marque {
	
	private int id;
	private String nom;
	
		
	public Marque() {
		super();
	}

	@Override
	public String toString() {
		return "id=" + id + " | nom=" + nom ;
	}

	public int getId() {
		return id;
	}

	public int getId(int i) {
		return id;
	}

	public Marque setId(int id) {
		this.id = id;
		return this;
	}

	public String getNom() {
		return nom;
	}

	public Marque setNom(String nom) {
		this.nom = nom;
		return this;
	}
	
	

}
