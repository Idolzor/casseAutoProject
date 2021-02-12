package com.cda.menu.action;

import java.util.List;
import java.util.Optional;

import com.cda.menu.ihm.IHM_INS;
import com.cda.model.Marque;
import com.cda.model.Modele;
import com.cda.model.dao.MarqueDAO;
import com.cda.model.dao.ModeleDAO;
import com.cda.model.dao.sql.MarqueDAOImpl;
import com.cda.model.dao.sql.ModeleDAOImpl;

public class ModeleAction extends Action {

	private static final int ID = 2;
	private static final String DESC = "Actions sur les modeles";

	private ModeleDAO modeleDAO;
	private MarqueDAO marqueDAO;

	ModeleAction() {
		super(ID, DESC);
		this.modeleDAO = new ModeleDAOImpl();
		this.marqueDAO = new MarqueDAOImpl();
	}

	@Override
	public boolean executer() {

		System.out.println(" 1 : Ajouter un modele" + "\n 2 : Voir les modeles" + "\n 3 : Modifier un modele"
				+ "\n 4 : Supprimer un modele" + "\n 5 : retour");
		int choix = IHM_INS.lireChoix();

		switch (choix) {
		case 1:
			String nom = IHM_INS.lireModele();
			int annee = IHM_INS.lireAnnee();
			String marque = IHM_INS.lireMarque();
			System.out.println(marque);

			Optional<Modele> modeleOpt = this.modeleDAO.findByName(nom);
			Optional<Modele> modeleOptAnnee = this.modeleDAO.findByAnnee(annee);
			Optional<Marque> marqueOpt = this.marqueDAO.findByName(marque);

			if (!marqueOpt.isPresent()) {
				System.out.println("Cette marque n'existe pas/plus");
			} else {

				if (modeleOpt.isPresent()) {
					if (modeleOptAnnee.isPresent()) {
						System.out.println(
								"Ce modèle : " + nom + " combiné a cette année : " + annee + " est déja dans la BDD");
					} else {
						this.modeleDAO.save(new Modele().setNom(nom).setAnnee(annee).setIdMarque(marque));
					}
				} else {
					this.modeleDAO.save(new Modele().setNom(nom).setAnnee(annee).setIdMarque(marque));
					System.out.println("Marque : " + nom + " ajoutée");
				}

			}
			break;

		case 2:
			List<Modele> modele = this.modeleDAO.getAll();
			System.out.println(modele.size() + " Modeles dans la BDD");
			modele.forEach(m -> System.out.println(m));

			break;

		case 3:
			System.out.println(
					" 1 : Modifier le modèle du véhicule" + "\n 2 : Modifier l'année du véhicule" + "\n 3 : Retour");
			int choixModifier = IHM_INS.lireChoix();
			switch (choixModifier) {
			case 1:

				System.out.println("Choix du modèle à modifier : ");
				String nomModeleActuel = IHM_INS.lireModele();
				int anneeModele = IHM_INS.lireAnnee();

				Optional<Modele> modeleOptModif = this.modeleDAO.findByName(nomModeleActuel);
				Optional<Modele> modeleOptAnneeModif = this.modeleDAO.findByAnnee(anneeModele);

				if (modeleOptModif.isPresent()) {

					if (modeleOptAnneeModif.isPresent()) {

						String nouveauNom = IHM_INS.lireModele();
						this.modeleDAO.modify(new Modele().setNom(nouveauNom), nomModeleActuel);

					} else {
						System.out.println("Ce modèle n'existe pas");
					}
				} else {
					System.out.println("Ce modèle n'existe pas");
				}

				break;

			case 2:

				System.out.println("Choix du modèle à modifier : ");
				String nomModeleActuelA = IHM_INS.lireModele();
				int anneeModeleA = IHM_INS.lireAnnee();

				Optional<Modele> modeleOptModifA = this.modeleDAO.findByName(nomModeleActuelA);
				Optional<Modele> modeleOptAnneeModifA = this.modeleDAO.findByAnnee(anneeModeleA);

				if (modeleOptModifA.isPresent()) {

					if (modeleOptAnneeModifA.isPresent()) {

						int nouvelleAnnee = IHM_INS.lireAnnee();
						this.modeleDAO.modifyAnnee(new Modele().setAnnee(nouvelleAnnee), anneeModeleA);

					} else {
						System.out.println("Ce modèle n'existe pas");
					}
				} else {
					System.out.println("Ce modèle n'existe pas");
				}
				
				
				
				break;

			case 3:
				break;

			default:
				break;
			}
			break;

		case 4:

			
			String nomSuppr = IHM_INS.lireModele();
			Optional<Modele> modeleOptSuppr = this.modeleDAO.findByName(nomSuppr);
			
			if (modeleOptSuppr.isPresent()) {		
				this.modeleDAO.removeByName(nomSuppr);		
				System.out.println("suppresion réussie");	
			}else {
				System.out.println("Ce modèle n'existe pas dans la BDD");
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
