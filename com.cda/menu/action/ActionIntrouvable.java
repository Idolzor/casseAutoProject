package menu.action;
import static menu.ihm.Ihm.IHM_INS;


final class ActionIntrouvable extends Action {

	private static final int ID = 99;
	private static final String DESC = "action introuvable";
	
	ActionIntrouvable() {
		super(ID, DESC);
	}

	@Override
	public boolean executer() {
		IHM_INS.afficher("> votre saisie est incorrecte.");
		return Boolean.TRUE;
	}
}
