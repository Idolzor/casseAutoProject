package com.cda.model;

public class TypePiece {
	
	private int idTypePiece;
	private String designation;
	private int idCategorie;
	
	public TypePiece(String pDesignation, int pIdCategorie) {
		this.designation = pDesignation;
		this.idCategorie = pIdCategorie;
	}
	
	public TypePiece() {
		super();
	}

	@Override
	public String toString() {
		return "TypePiece [idTypePiece=" + idTypePiece + ", designation=" + designation + ", idCategorie=" + idCategorie
				+ "]";
	}

	public int getIdTypePiece() {
		return idTypePiece;
	}

	public void setIdTypePiece(int idTypePiece) {
		this.idTypePiece = idTypePiece;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getIdCategorie() {
		return idCategorie;
	}
	
	public int getIdCategorie(int i) {
		return idCategorie;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}
	
	

}
