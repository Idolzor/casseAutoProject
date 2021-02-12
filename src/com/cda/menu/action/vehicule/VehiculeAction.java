package com.cda.menu.action.vehicule;

import java.util.List;
import java.util.Optional;

import com.cda.dao.vehicule.ModeleDAO;
import com.cda.dao.vehicule.VehiculeDAO;
import com.cda.dao1.sqlvehicule.ModeleDAOImpl;
import com.cda.dao1.sqlvehicule.VehiculeDaoImpl;
import com.cda.menu.action.Action;
import com.cda.menu.ihm.IHM_INS;
import com.cda.model.vehicule.Modele;
import com.cda.model.vehicule.Vehicule;

public class VehiculeAction extends Action {
	private static final int ID = 6;
	private static final String DESC = "Actions sur les vehicules";
	private VehiculeDAO vehiculeDAO;
	private ModeleDAO modeleDAO;

	public VehiculeAction() {
		super(ID, DESC);
		this.vehiculeDAO = new VehiculeDaoImpl();
		this.modeleDAO = new ModeleDAOImpl();
	}

	@Override
	public boolean executer() {

		System.out.println(" 1 : Ajouter un v�hicule" + "\n 2 : Voir les v�hicules" + "\n 3 : Modifier un v�hicule"
				+ "\n 4 : Supprimer un v�hicule" + "\n 5 : Retour");
		int choix = IHM_INS.lireChoix();

		switch (choix) {
		case 1:
			System.out.println("Saississez l'immatriculation");
			String immat = IHM_INS.lireImmatriculation();
			Optional<Vehicule> vehiculeOpt = this.vehiculeDAO.findByName(immat);

			if (vehiculeOpt.isPresent()) {
				System.out.println("Erreur : Cette immatriculation : " + immat + " existe d�ja");
			} else {
				System.out.println("Modele et ann�e associ� au v�hicule");
				String modele = IHM_INS.lireModele();
				int annee = IHM_INS.lireAnnee();
				Optional<Modele> modeleOpt = this.modeleDAO.findByName(modele);
				if (modeleOpt.isPresent()) {
					this.vehiculeDAO
							.save(new Vehicule().setImmatriculation(immat).setIdModele(modele).setAnneeModele(annee));
					System.out.println("V�hicule : " + immat + " ajout�e");
				}
			}

			break;

		case 2:
			List<Vehicule> vehicule = this.vehiculeDAO.getAll();
			System.out.println(vehicule.size() + " vehicules dans la BDD");
			vehicule.forEach(m -> System.out.println(m));

			break;
		case 3:
			System.out.println("Saisir l'immatriculation � modifier");
			String ancienImmat = IHM_INS.lireImmatriculation();
			System.out.println("Saisir le nouveau nom");
			String nouveauImmat = IHM_INS.lireImmatriculation();

			Optional<Vehicule> VehiculeOptModif = this.vehiculeDAO.findByName(ancienImmat);
			Optional<Vehicule> VehiculeOptModif2 = this.vehiculeDAO.findByName(nouveauImmat);

			if (VehiculeOptModif.isPresent()) {
				if (VehiculeOptModif2.isPresent()) {
					System.out.println("Vous ne pouvez pas renommer car la nouvelle immatriculation est d�ja pr�sente");
				} else {
					this.vehiculeDAO.modify(new Vehicule().setImmatriculation(nouveauImmat), ancienImmat);
					System.out.println("Immatriculation : " + ancienImmat + " modifi�e en : " + nouveauImmat);
				}
			} else {
				System.out.println("Vous ne pouvez pas modifier une immatriculation qui n'existe pas !!");
			}
			break;

		case 4:
			String nomSuppr = IHM_INS.lireMarque();
			Optional<Vehicule> marqueOptSuppr = this.vehiculeDAO.findByName(nomSuppr);

			if (marqueOptSuppr.isPresent()) {
				this.vehiculeDAO.removeByName(nomSuppr);
				System.out.println("suppresion r�ussie");
			} else {
				System.out.println("Cette immatriculation n'existe pas dans la BDD");
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
