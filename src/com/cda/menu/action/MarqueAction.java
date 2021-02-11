package com.cda.menu.action;

import java.util.List;
import java.util.Optional;

import com.cda.menu.ihm.IHM_INS;
import com.cda.model.Marque;
import com.cda.model.dao.MarqueDAO;
import com.cda.model.dao.sql.MarqueDAOImpl;

public class MarqueAction extends Action {

	private static final int ID = 1;
	private static final String DESC = "Actions sur les marques";

	private MarqueDAO marqueDAO;
	
	MarqueAction() {
		super(ID, DESC);
		this.marqueDAO = new MarqueDAOImpl();
	}

	@Override
	public boolean executer() {

		
		System.out.println(" 1 : Ajouter une marque"
				+ "\n 2 : Voir les marques"
				+ "\n 3 : Modifier une marque"
				+ "\n 4 : Supprimer une marque");
		int choix = IHM_INS.lireChoix();
		
		
		switch (choix) {
		case 1:
			String nom = IHM_INS.lireMarque();		
			Optional<Marque> marqueOpt = this.marqueDAO.findByName(nom);
			
			if (marqueOpt.isPresent()) {
				System.out.println("Erreur : Cette marque : " +nom +" existe déja");
			}else {
				this.marqueDAO.save(new Marque().setNom(nom));
				System.out.println("Marque : " +nom +" ajoutée");
			}
						
			break;

		case 2:

			List<Marque> marque = this.marqueDAO.getAll();
			System.out.println(marque.size() +" Marques dans la BDD");
			marque.forEach(m ->
			System.out.println(m));
			
			break;

		case 3:
			System.out.println("Saisir le nom de la marque à modifier");
			String ancienNom = IHM_INS.lireMarque();
			System.out.println("Saisir le nouveau nom");
			String nouveauNom = IHM_INS.lireMarque();
			
			Optional<Marque> marqueOptModif = this.marqueDAO.findByName(ancienNom);
			Optional<Marque> marqueOptModif2 = this.marqueDAO.findByName(nouveauNom);
			
			if (marqueOptModif.isPresent()) {				
				if (marqueOptModif2.isPresent()) {
					System.out.println("Vous ne pouvez pas renommer car le nouveau nom est déja présent");
				}else {
					this.marqueDAO.modify(new Marque().setNom(nouveauNom), ancienNom);
					System.out.println("Marque : " + ancienNom + " modifiée en : " + nouveauNom);
				}				
			}else {				
				System.out.println("Vous ne pouvez pas modifier une marque qui n'existe pas !!");
			}			
			break;

		case 4:

		String nomSuppr = IHM_INS.lireMarque();
			Optional<Marque> marqueOptSuppr = this.marqueDAO.findByName(nomSuppr);
			
			if (marqueOptSuppr.isPresent()) {		
				this.marqueDAO.removeByName(nomSuppr);		
				System.out.println("suppresion réussie");	
			}else {
				System.out.println("Cette marque n'existe pas dans la BDD");
			}			
			break;
		default:
			break;
		}

		return Boolean.TRUE;
	}
}
