package com.cda.menu.action.pieces;

import java.util.List;
import java.util.Optional;

import com.cda.dao.pieces.CategorieDAO;
import com.cda.dao.pieces.TypePieceDAO;
import com.cda.dao1.sqlpieces.CategorieDAOImpl;
import com.cda.dao1.sqlpieces.TypePieceDAOImpl;
import com.cda.menu.action.Action;
import com.cda.menu.ihm.IHM_INS;
<<<<<<< HEAD:src/com/cda/menu/action/pieces/TypePieceAction.java
import com.cda.model.pieces.Categorie;
import com.cda.model.pieces.TypePiece;
=======
import com.cda.model.Categorie;
import com.cda.model.TypePiece;

import com.cda.model.dao.CategorieDAO;
import com.cda.model.dao.TypePieceDAO;
import com.cda.model.dao.sql.CategorieDAOImpl;
import com.cda.model.dao.sql.TypePieceDAOImpl;
>>>>>>> 15eeb42 (cr√©ation fichier excel htlml):src/com/cda/menu/action/TypePieceAction.java

public class TypePieceAction extends Action {

	private static final int ID = 2;
	private static final String DESC = "Actions sur les type de piece";
<<<<<<< HEAD:src/com/cda/menu/action/pieces/TypePieceAction.java
=======

>>>>>>> 15eeb42 (cr√©ation fichier excel htlml):src/com/cda/menu/action/TypePieceAction.java
	private TypePieceDAO typePieceDAO;
	private CategorieDAO categorieDAO;

	public TypePieceAction() {
		super(ID, DESC);
		this.typePieceDAO = new TypePieceDAOImpl();
		this.categorieDAO = new CategorieDAOImpl();
	}

	@Override
	public boolean executer() {

		System.out.println(" 1 : Ajouter un type de piece" + "\n 2 : Voir les types de piece"
				+ "\n 3 : Supprimer un type de piece" + "\n 4 : Retour");
		int choix = IHM_INS.lireChoix();
		switch (choix) {
		case 1:
			String categoriePiece = IHM_INS.lireCategorie();

			Optional<Categorie> categorieOtp = this.categorieDAO.findByName(categoriePiece);

			if (categorieOtp.isPresent()) {
				System.out.println("Categorie : " + categoriePiece);
				String designationPiece = IHM_INS.lireDesignationPiece();
				Optional<TypePiece> typePieceOpt = this.typePieceDAO.findByName(designationPiece);
				if (typePieceOpt.isPresent()) {
					System.out.println("Ce type de piece existe dÈja");
				} else {
					this.typePieceDAO
							.save(new TypePiece().setDesignation(designationPiece).setIdCategorie(categoriePiece));
				}

			} else {
				System.out.println("cette categorie n'existe pas");
			}

			break;
		case 2:
			List<TypePiece> typepiece = this.typePieceDAO.getAll();
			if (typepiece.isEmpty()) {
				System.out.println("  aucun type de piece !");
			} else {
				typepiece.stream().forEach(e -> {
					System.out.println(e);
				});
			}
			break;
		case 3:
			String nomSuppr = IHM_INS.lireDesignationPiece();
			Optional<TypePiece> typePieceOptSuppr = this.typePieceDAO.findByName(nomSuppr);

			if (typePieceOptSuppr.isPresent()) {
				this.typePieceDAO.removeByName(nomSuppr);
				System.out.println("suppresion rÈussie");
			} else {
				System.out.println("Cette immatriculation n'existe pas dans la BDD");
			}
			break;

		case 4:
			break;
		default:
			break;
		}
<<<<<<< HEAD:src/com/cda/menu/action/pieces/TypePieceAction.java
=======

>>>>>>> 15eeb42 (cr√©ation fichier excel htlml):src/com/cda/menu/action/TypePieceAction.java
		return Boolean.TRUE;
	}

}
