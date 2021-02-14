package com.cda.model.pieces;

import java.util.Date;

public class Piece {

	private int idPiece;
	private String dateRecup;
	private String dateVente;
	private float prixVente;
	private String immatriculation;
	private String idTypePiece;
	private String categorie;

	public Piece() {
		super();
	}

	@Override
	public String toString() {
		return "Piece [id_piece=" + idPiece + ", reference=" + immatriculation + "]";
	}

	public int getIdPiece() {
		return idPiece;
	}

	public String getDateRecup() {
		return dateRecup;
	}

	public String getDateVente() {
		return dateVente;
	}

	public float getPrixVente() {
		return prixVente;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public String getIdTypePiece() {
		return idTypePiece;
	}

	public Piece setIdPiece(int idPiece) {
		this.idPiece = idPiece;
		return this;
	}

	public Piece setDateRecup(String dateRecup) {
		this.dateRecup = dateRecup;
		return this;
	}

	public Piece setDateVente(String dateVente2) {
		this.dateVente = dateVente2;
		return this;
	}

	public Piece setPrixVente(float prixVente) {
		this.prixVente = prixVente;
		return this;
	}

	public Piece setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
		return this;
	}

	public Piece setIdTypePiece(String typepiece) {
		this.idTypePiece = typepiece;
		return this;
	}

	public Piece setCategorie(String categorie) {
		this.categorie = categorie;
		return this;
	}

	public String getCategorie() {
		return categorie;
	}

	public int getIdPiece(int int1) {
		return int1;
	}

}
