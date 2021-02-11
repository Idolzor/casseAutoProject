package com.cda.model;

public class Marque {
	
	private int id_marque;
	private String nom_marque;
	
	public Marque(int pId_marque, String pNom_marque) {
		this.id_marque = pId_marque;
		this.nom_marque = pNom_marque;
	}
	
	public Marque() {
		super();
	}

	@Override
	public String toString() {
		return "Marque [id_marque=" + id_marque + ", nom_marque=" + nom_marque + "]";
	}

	public int getId_marque() {
		return id_marque;
	}

	public int getId_marque(int i) {
		return id_marque;
	}

	public void setId_marque(int id_marque) {
		this.id_marque = id_marque;
	}

	public String getNom_marque() {
		return nom_marque;
	}

	public void setNom_marque(String nom_marque) {
		this.nom_marque = nom_marque;
	}
	
	

}
