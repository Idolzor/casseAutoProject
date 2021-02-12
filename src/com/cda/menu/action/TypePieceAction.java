package com.cda.menu.action;

import java.util.List;

import com.cda.menu.ihm.IHM_INS;
import com.cda.model.TypePiece;

public class TypePieceAction extends Action {

	private static final int ID = 2;
	private static final String DESC = "Actions sur les type de piece";
	
	TypePieceAction(){
		super(ID, DESC);
	}

	@Override
	public boolean executer() {
	
		System.out.println(" 1 : Ajouter une type de piece"
				+ "\n 2 : Voir les types de piece"
				+ "\n 3 : Modifier une type de piece"
				+ "\n 4 : Supprimer une type de piece");
		int choix = IHM_INS.lireChoix();
		switch (choix) {
		case 1 :
				
			break;
		case 2 :
			List<TypePiece> typepiece = this.typepiece.getAll();
			if (typepiece.isEmpty()) {
				System.out.println("  > aucune personne !");
			} else {
				typepiece.stream().forEach(e -> {
					System.out.println("  > " + e);
				});
			}		
			break;
		}
	}
	
}
