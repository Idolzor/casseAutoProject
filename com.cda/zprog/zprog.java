package zprog;
import static menu.ihm.Ihm.IHM_INS;
import java.util.TreeMap;

import menu.action.Action;
import menu.action.LesActions;


public class zprog {

	public static void main(String[] args) {
		TreeMap<Integer, Action> actions = new TreeMap<>();
		ajouterAction(actions, LesActions.ACTION_INTROUVABLE);
		ajouterAction(actions, LesActions.QUITTER);

		boolean vContinuer;
		int vActionSaisie;
		do {
			IHM_INS.afficher("\n*******************\nsaisissez une action");
			for (Action action : actions.values()) {
				IHM_INS.afficher("\t" + action.getId() + ")- " + action.getDescription());
			}
			vActionSaisie = IHM_INS.lireEntier();
			vContinuer = actions.getOrDefault(vActionSaisie, LesActions.ACTION_INTROUVABLE).executer();
		} while (vContinuer);
	}

	private static void ajouterAction(TreeMap<Integer, Action> actions, Action pAction) {
		actions.put(pAction.getId(), pAction);
	}
}