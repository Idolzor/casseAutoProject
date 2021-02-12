package com.cda.model;

public class Categorie {

	private int id_categorie;
	private String libelle;

	public Categorie(int pId_Caterogie, String pLibelle) {
		this.id_categorie = pId_Caterogie;
		this.libelle = pLibelle;
	}

	public Categorie() {
		super();
	}

	@Override
	public String toString() {
		return "Categorie : " +libelle + " | id : " +id_categorie ;
	}

	public int getId_categorie() {
		return id_categorie;
	}

	public int getId_categorie(int i) {
		return id_categorie;
	}

	public Categorie setId_categorie(int id_categorie) {
		this.id_categorie = id_categorie;
		return this;
	}

	public String getLibelle() {
		return libelle;
	}

	public Categorie setLibelle(String libelle) {
		this.libelle = libelle;
		return this;
	}

}
