package com.cda.menu.action;

import java.util.List;
import java.util.Optional;

import com.cda.menu.ihm.IHM_INS;
import com.cda.model.Categorie;
import com.cda.model.Marque;
import com.cda.model.dao.CategorieDAO;
import com.cda.model.dao.sql.CategorieDAOImpl;

public class CategorieAction extends Action {

	private static final int ID = 1;
	private static final String DESC = "Actions sur les categories";
	private CategorieDAO categorieDao;

	protected CategorieAction() {
		super(ID, DESC);
		this.categorieDao = new CategorieDAOImpl();
	}

	@Override
	public boolean executer() {
		System.out.println(" 1 : Ajouter une categorie" + "\n 2 : Voir les categories" + "\n 3 : Modifier une categorie"
				+ "\n 4 : Supprimer une categorie" + "\n 5 : Retour");
		int choix = IHM_INS.lireChoix();

		switch (choix) {
		case 1:
			String nom = IHM_INS.lireCategorie();
			Optional<Categorie> CategorieOpt = this.categorieDao.findByName(nom);

			if (CategorieOpt.isPresent()) {
				System.out.println("Erreur : Cettecategorie : " + nom + " existe déja");
			} else {
				this.categorieDao.save(new Categorie().setLibelle(nom));
				System.out.println("Marque : " + nom + " ajoutée");
			}

			break;

		case 2:

			List<Categorie> categorie = this.categorieDao.getAll();
			System.out.println(categorie.size() + " Categories dans la BDD");
			categorie.forEach(m -> System.out.println(m));

			break;

		case 3:

			System.out.println("Saisir le nom de la categorie à modifier");
			String ancienNom = IHM_INS.lireCategorie();
			System.out.println("Saisir le nouveau nom");
			String nouveauNom = IHM_INS.lireCategorie();

			Optional<Categorie> marqueOptModif = this.categorieDao.findByName(ancienNom);
			Optional<Categorie> marqueOptModif2 = this.categorieDao.findByName(nouveauNom);

			if (marqueOptModif.isPresent()) {
				if (marqueOptModif2.isPresent()) {
					System.out.println("Vous ne pouvez pas renommer car le nouveau nom est déja présent");
				} else {
					this.categorieDao.modify(new Categorie().setLibelle(nouveauNom), ancienNom);
					System.out.println("Categorie : " + ancienNom + " modifiée en : " + nouveauNom);
				}
			} else {
				System.out.println("Vous ne pouvez pas modifier une categorie qui n'existe pas !!");
			}
			break;

		case 4:

			String nomSuppr = IHM_INS.lireCategorie();
			Optional<Categorie> categorieOptSuppr = this.categorieDao.findByName(nomSuppr);

			if (categorieOptSuppr.isPresent()) {
				this.categorieDao.removeByName(nomSuppr);
				System.out.println("suppresion réussie");
			} else {
				System.out.println("Cette categorie n'existe pas dans la BDD");
			}
			break;

		case 5:
			break;

		default:
			break;
		}

		return Boolean.TRUE;
	}

}
