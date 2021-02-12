package com.cda.model.pieces;

public class Relation {

	// trouver idModele
	private String nomModele;
	private int anneeModele;
	// trouver idTypePiece
	private String designation;
	private String idCategorie;
	private int idTypePiece;

	public String getNomModele() {
		return nomModele;
	}

	public int getAnneeModele() {
		return anneeModele;
	}

	public String getDesignation() {
		return designation;
	}

	public String getIdCategorie() {
		return idCategorie;
	}

	public Relation setNomModele(String nomModele) {
		this.nomModele = nomModele;
		return this;
	}

	public Relation setAnneeModele(int anneeModele) {
		this.anneeModele = anneeModele;
		return this;
	}

	public Relation setDesignation(String designation) {
		this.designation = designation;
		return this;
	}

	public Relation setIdCategorie(String categoriePiece) {
		this.idCategorie = categoriePiece;
		return this;
	}

	public int getIdTypePiece(int int1) {
		return int1;
	}
	
	public Relation setIdTypePiece(int idTypePiece) {
		this.idTypePiece = idTypePiece;
		return this;
	}

	@Override
	public String toString() {
		return  "idPiece : " + idTypePiece + " Ref : "  + designation +" Modele :"+ nomModele+ anneeModele;
	}

}
