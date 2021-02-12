package com.cda.model.vehicule;

public class Vehicule {
	private String immatriculation;
	private String nom;
	private String nomMarque;
	private String nomModele;
	@Override
	public String toString() {
		return nomMarque + " " +nomModele + " " + anneeModele + " immatriculée : "+ immatriculation;
	}

	private int anneeModele;
	private String idModele;

	public String getImmatriculation() {
		return immatriculation;
	}

	public Vehicule setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
		return this;
	}

	public String getNom() {
		return nom;
	}

	public Vehicule setNom(String nom) {
		this.nom = nom;
		return this;
	}

	public String getIdModele() {
		return idModele;
	}

	public Vehicule setIdModele(String idModele) {
		this.idModele = idModele;
		return this;
	}

	public String getImmatriculation(String string) {
		return immatriculation;

	}

	public int getAnneeModele() {
		return anneeModele;
	}

	public Vehicule setAnneeModele(int anneeModele) {
		this.anneeModele = anneeModele;
		return this;
	}

	public Vehicule setNomMarque(String nomMarque) {
		this.nomMarque = nomMarque;
		return this;
	}

	public Vehicule setNomModele(String nomModele) {
		this.nomModele = nomModele;
		return this;
	}
}
