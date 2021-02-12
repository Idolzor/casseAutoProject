package com.cda.menu.action;


final class ActionIntrouvable extends Action {

	private static final int ID = 99;
	private static final String DESC = "action introuvable";
	
	ActionIntrouvable() {
		super(ID, DESC);
	}

	@Override
	public boolean executer() {
		System.out.println("votre saisie est incorrecte.");
		return Boolean.TRUE;
	}
}
