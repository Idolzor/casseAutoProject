package com.cda.menu.action.pieces;

import java.util.List;
import java.util.Optional;

import com.cda.dao.pieces.CategorieDAO;
import com.cda.dao.pieces.RelationDAO;
import com.cda.dao.pieces.TypePieceDAO;
import com.cda.dao.vehicule.ModeleDAO;
import com.cda.dao1.sqlpieces.CategorieDAOImpl;
import com.cda.dao1.sqlpieces.RelationDAOImpl;
import com.cda.dao1.sqlpieces.TypePieceDAOImpl;
import com.cda.dao1.sqlvehicule.ModeleDAOImpl;
import com.cda.menu.action.Action;
import com.cda.menu.ihm.IHM_INS;
import com.cda.model.pieces.Categorie;
import com.cda.model.pieces.Relation;
import com.cda.model.pieces.TypePiece;
import com.cda.model.vehicule.Modele;

public class ActionRelation extends Action {

	private static final int ID = 4;
	private static final String DESC = "Actions sur les relations pieces/vehicule";

	private RelationDAO relationDAO;
	private TypePieceDAO typePieceDAO;
	private ModeleDAO modeleDAO;
	private CategorieDAO categorieDAO;

	public ActionRelation() {
		super(ID, DESC);
		this.relationDAO = new RelationDAOImpl();
		this.modeleDAO = new ModeleDAOImpl();
		this.typePieceDAO = new TypePieceDAOImpl();
		this.categorieDAO = new CategorieDAOImpl();
	}

	@Override
	public boolean executer() {
		System.out.println(" 1 : Ajouter une relation piece/vehicule " + "\n 2 : Voir les relations existantes"
				+ "\n 3 : Supprimer une relation via le type de pièce" + "\n 4 : Retour");
		int choix = IHM_INS.lireChoix();
		switch (choix) {
		case 1:
			System.out.println("Pièce a ajouter : ");
			String categoriePiece = IHM_INS.lireCategorie();

			Optional<Categorie> categorieOtp = this.categorieDAO.findByName(categoriePiece);

			if (categorieOtp.isPresent()) {

				String typePiece = IHM_INS.lireDesignationPiece();

				Optional<TypePiece> typePieceOptOtp = this.typePieceDAO.findByName(typePiece);

				if (typePieceOptOtp.isPresent()) {
					System.out.println("Piece : " + typePiece);
					String nomModele = IHM_INS.lireModele();
					Optional<Modele> modeleOpt = this.modeleDAO.findByName(nomModele);

					if (modeleOpt.isPresent()) {
						int anneemodele = IHM_INS.lireAnnee();
						Optional<Modele> modeleAnneeOpt = this.modeleDAO.findByAnnee(anneemodele);
						if (modeleAnneeOpt.isPresent()) {
							this.relationDAO
									.save(new Relation().setDesignation(typePiece).setIdCategorie(categoriePiece)
											.setNomModele(nomModele).setAnneeModele(anneemodele));
						} else {
							System.out.println("cette annee n'existe pas");
						}
					} else {
						System.out.println("Ce modele n'existe pas");
					}
				} else {
					System.out.println("cette pièce n'existe pas");
				}
			} else {
				System.out.println("cette categorie n'existe pas");
			}

			break;
		case 2:
			List<Relation> typepiece = this.relationDAO.getAll();
			if (typepiece.isEmpty()) {
				System.out.println("  aucun type de piece !");
			} else {
				typepiece.stream().forEach(e -> {
					System.out.println(e);
				});
			}
			break;

		case 3:

			System.out.println("Pièce a ajouter : ");
			String categoriePieceSuppr = IHM_INS.lireCategorie();

			Optional<Categorie> categorieOtpSuppr = this.categorieDAO.findByName(categoriePieceSuppr);

			if (categorieOtpSuppr.isPresent()) {

				String typePiece = IHM_INS.lireDesignationPiece();

				Optional<TypePiece> typePieceOpt = this.typePieceDAO.findByName(typePiece);
				if (typePieceOpt.isPresent()) {

					this.relationDAO.removeByName(categoriePieceSuppr, typePiece);

				} else {
					System.out.println("cette piece n'existe pas");
				}

			} else {
				System.out.println("cette categorie n'existe pas");
			}

			break;

		case 4:
			break;
		default:
			break;
		}
		return Boolean.TRUE;
	}

}
