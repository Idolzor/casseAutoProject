package com.cda.model;

public class Book {
	
	private String piece;
	private String nom;
	private int annee;
	
	public Book(String pPiece, String pNom, int pAnnee) {
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

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

}
