package com.cda.model;

public class TypePiece {

	private int idTypePiece;
	private String designation;
	private String idCategorie;
	private int idCategorint;

	public TypePiece() {
		super();
	}

	@Override
	public String toString() {
		return "Categorie : " + idCategorie + " désignation : " + designation + " id : " + idTypePiece;

	}

	public int getIdTypePiece(int i) {
		return idTypePiece;
	}

	public TypePiece setIdTypePiece(int idTypePiece) {
		this.idTypePiece = idTypePiece;
		return this;
	}

	public String getDesignation() {
		return designation;
	}

	public TypePiece setDesignation(String designation) {
		this.designation = designation;
		return this;
	}

	public String getIdCategorie() {
		return idCategorie;
	}

	public String getIdCategorie(int i) {
		return idCategorie;
	}

	public TypePiece setIdCategorie(String idCategorie) {
		this.idCategorie = idCategorie;
		return this;
	}

	public TypePiece setIdCategorint(int int1) {
		this.idCategorint = int1;
		return this;
	}

}
