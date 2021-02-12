package com.cda.zprog;

import java.util.TreeMap;

import com.cda.menu.action.Action;
import com.cda.menu.action.LesActions;
import com.cda.menu.ihm.IHM_INS;

public class zprog {

	public static void main(String[] args) {
		TreeMap<Integer, Action> actions = new TreeMap<>();
		ajouterAction(actions, LesActions.ACTION_INTROUVABLE);
		ajouterAction(actions, LesActions.QUITTER);
		ajouterAction(actions, LesActions.CATEGORIE_ACTION);
		ajouterAction(actions, LesActions.MARQUE_ACTION);
		ajouterAction(actions, LesActions.MODELE_ACTION);
		ajouterAction(actions, LesActions.TYPE_PIECE_ACTION);
		ajouterAction(actions, LesActions.VEHICULE_ACTION);
		ajouterAction(actions, LesActions.ACTION_RELATION);

		boolean vContinuer;
		int vActionSaisie;
		do {
			for (Action action : actions.values()) {
				System.out.println("\t" + action.getId() + ")- " + action.getDescription());
			}
			vActionSaisie = IHM_INS.lireChoix();
			vContinuer = actions.getOrDefault(vActionSaisie, LesActions.ACTION_INTROUVABLE).executer();
		} while (vContinuer);
	}

	private static void ajouterAction(TreeMap<Integer, Action> actions, Action pAction) {
		actions.put(pAction.getId(), pAction);
	}
}