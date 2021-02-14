package com.cda.menu.action.pieces;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.cda.dao.pieces.CategorieDAO;
import com.cda.dao.pieces.PieceDAO;
import com.cda.dao.pieces.TypePieceDAO;
import com.cda.dao.vehicule.VehiculeDAO;
import com.cda.dao1.sqlpieces.CategorieDAOImpl;
import com.cda.dao1.sqlpieces.PieceDaoImpl;
import com.cda.dao1.sqlpieces.TypePieceDAOImpl;
import com.cda.dao1.sqlvehicule.VehiculeDaoImpl;
import com.cda.menu.action.Action;
import com.cda.menu.ihm.IHM_INS;
import com.cda.model.pieces.Categorie;
import com.cda.model.pieces.Piece;
import com.cda.model.pieces.TypePiece;
import com.cda.model.vehicule.Vehicule;

public class ActionPiece extends Action {

	private static final int ID = 3;
	private static final String DESC = "Actions sur les pieces";
	private PieceDAO pieceDAO;
	private TypePieceDAO typePieceDAO;
	private VehiculeDAO vehiculeDAO;
	private CategorieDAO categorieDao;

	public ActionPiece() {
		super(ID, DESC);
		this.pieceDAO = new PieceDaoImpl();
		this.typePieceDAO = new TypePieceDAOImpl();
		this.vehiculeDAO = new VehiculeDaoImpl();
		this.categorieDao = new CategorieDAOImpl();
	}

	@Override
	public boolean executer() {
		System.out.println(" 1 : Recuperer une piece d'un véhicule"
				+ "\n 2 : vendre une piece" + "\n 3 : Retour");
		int choix = IHM_INS.lireChoix();
		switch (choix) {
		case 1:
			String categorie = IHM_INS.lireCategorie();

			Optional<Categorie> categorieOtp = this.categorieDao.findByName(categorie);

			if (categorieOtp.isPresent()) {
				String typepiece = IHM_INS.lireDesignationPiece();
				Optional<TypePiece> TypePieceOtp = this.typePieceDAO.findByName(typepiece);

				if (TypePieceOtp.isPresent()) {
					String immat = IHM_INS.lireImmatriculation();
					Optional<Vehicule> vehiculeOtp = this.vehiculeDAO.findByName(immat);
					if (vehiculeOtp.isPresent()) {
						System.out.println("saisir la date de récupération : ");
						int jour = IHM_INS.lireJour();
						int mois = IHM_INS.lireMois();
						int annee = IHM_INS.lireAnnee();
						String date = annee + "-" + mois + "-" +jour ;
						Float prixVente = IHM_INS.lirePrix();

						this.pieceDAO.save(new Piece().setDateRecup(date).setPrixVente(prixVente)
								.setImmatriculation(immat).setIdTypePiece(typepiece));

					} else {
						System.out.println("ce vehicule n'est pas dans la BDD merci de l'ajouter");
					}

				} else {
					System.out.println("cette piece n'est pas encore implementée");
				}
			} else {
				System.out.println("cette categorie n'existe pas, merci de l'ajouter");
			}

			break;
		case 2:
			
					String reference1 = IHM_INS.lireDesignationPiece();
					Optional<TypePiece>typePieceOpt1= this.typePieceDAO.findByName(reference1);
					
					if (typePieceOpt1.isPresent()) {
						System.out.println("Saisir la date de vente : ");
					int jour=IHM_INS.lireJour();
					int mois=IHM_INS.lireMois();
					int annee=IHM_INS.lireAnnee();
					
					String dateVente = annee + "-" + mois + "-" + jour;
					this.pieceDAO.update(new Piece().setDateVente(dateVente).setIdTypePiece(reference1));
					}else {
						System.out.println("Cette piece n'existe pas.");
					}
			
			break;

		case 3:

			break;

		case 4:
			break;
		default:
			break;
		}
		return Boolean.TRUE;
	}

}
