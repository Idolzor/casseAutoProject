package com.cda.model;

public class Book {
	
	private String piece;
	private String nom;
	private String annee;
	
	public Book(String pPiece, String pNom, String pAnnee) {
		this.piece = pPiece;
		this.nom = pNom;
		this.annee = pAnnee;
	}

	public String getPiece() {
		return piece;
	}

	public void setPiece(String piece) {
		this.piece = piece;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

}
