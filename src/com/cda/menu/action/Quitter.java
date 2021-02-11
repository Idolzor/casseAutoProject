package com.cda.menu.action;


final class Quitter extends Action {

	private static final int ID = 0;
	private static final String DESC = "quitter le programme";
	
	Quitter() {
		super(ID, DESC);
	}

	@Override
	public boolean executer() {
		System.out.println("A bientot !");
		return Boolean.FALSE;
	}

}
