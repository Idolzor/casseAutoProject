package com.cda.menu.action;

import java.util.List;
import java.util.Optional;

import com.cda.menu.ihm.IHM_INS;
import com.cda.model.Categorie;
import com.cda.model.TypePiece;
<<<<<<< HEAD
import com.cda.model.dao.CategorieDAO;
import com.cda.model.dao.TypePieceDAO;
import com.cda.model.dao.sql.CategorieDAOImpl;
import com.cda.model.dao.sql.TypePieceDAOImpl;
=======
import com.cda.model.dao.TypePieceDAO;
>>>>>>> 369da76 (création action export excel)

public class TypePieceAction extends Action {

	private static final int ID = 2;
	private static final String DESC = "Actions sur les type de piece";
<<<<<<< HEAD
	private TypePieceDAO typePieceDAO;
	private CategorieDAO categorieDAO;
=======
	private TypePieceDAO typepieceDAO;
>>>>>>> 369da76 (création action export excel)

	TypePieceAction() {
		super(ID, DESC);
		this.typePieceDAO = new TypePieceDAOImpl();
		this.categorieDAO = new CategorieDAOImpl();
	}

	@Override
	public boolean executer() {

<<<<<<< HEAD
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
					System.out.println("Ce type de piece existe d�ja");
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
=======
		System.out.println(" 1 : Ajouter une type de piece" + "\n 2 : Voir les types de piece"
				+ "\n 3 : Modifier une type de piece" + "\n 4 : Supprimer une type de piece");
		int choix = IHM_INS.lireChoix();
		switch (choix) {
		case 1:

			break;
		case 2:
			List<TypePiece> typepiece = this.typepieceDAO.getAll();
>>>>>>> 369da76 (création action export excel)
			if (typepiece.isEmpty()) {
				System.out.println("  aucun type de piece !");
			} else {
				typepiece.stream().forEach(e -> {
					System.out.println(e);
				});
			}
<<<<<<< HEAD
			break;

		case 3:
			String nomSuppr = IHM_INS.lireDesignationPiece();
			Optional<TypePiece> typePieceOptSuppr = this.typePieceDAO.findByName(nomSuppr);

			if (typePieceOptSuppr.isPresent()) {
				this.typePieceDAO.removeByName(nomSuppr);
				System.out.println("suppresion r�ussie");
			} else {
				System.out.println("Cette immatriculation n'existe pas dans la BDD");
			}
			break;

		case 4:
			break;
		default:
			break;
		}
=======
			break;
		}

>>>>>>> 369da76 (création action export excel)
		return Boolean.TRUE;
	}

}
