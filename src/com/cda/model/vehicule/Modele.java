package com.cda.model.vehicule;

public class Modele {
	private int id;
	private String nom;
	private int annee;
	private String marque;
	private int idMarque;

	public int getAnnee() {
		return annee;
	}

	public Modele setAnnee(int annee) {
		this.annee = annee;
		return this;
	}

	public String getIdMarque() {
		return marque;
	}

	public Modele setIdMarque(String marque) {
		this.marque = marque;
		return this;
	}

	public Modele() {
		super();
	}

	@Override
	public String toString() {
		return "idModele=" + id + " | nom=" + nom + " | année = " + annee + " Marque = " + marque;
	}

	public int getId() {
		return id;
	}

	public int getId(int i) {
		return id;
	}

	public Modele setId(int id) {
		this.id = id;
		return this;
	}

	public String getNom() {
		return nom;
	}

	public Modele setNom(String nom) {
		this.nom = nom;
		return this;
	}

	public Modele setIdMarque(int int1) {
		this.idMarque = int1;
		return this;
	}
}
