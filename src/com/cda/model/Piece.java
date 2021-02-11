package com.cda.model;

public class Piece {
	
	private int id_piece;
	private String reference;
	
	public Piece(int PId_Piece, String pReference) {
		this.id_piece = PId_Piece;
		this.reference = pReference;
	}
	
	public Piece() {
		super();
	}

	@Override
	public String toString() {
		return "Piece [id_piece=" + id_piece + ", reference=" + reference + "]";
	}

	public int getId_piece() {
		return id_piece;
	}

	public int getId_piece(int i) {
		return id_piece;
	}

	public void setId_piece(int id_piece) {
		this.id_piece = id_piece;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}
	
	

}
