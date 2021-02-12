package com.cda.menu.action;

import com.cda.menu.action.pieces.ActionRelation;
import com.cda.menu.action.pieces.CategorieAction;
import com.cda.menu.action.pieces.TypePieceAction;
import com.cda.menu.action.vehicule.MarqueAction;
import com.cda.menu.action.vehicule.ModeleAction;
import com.cda.menu.action.vehicule.VehiculeAction;

public interface LesActions {
	public static final Quitter QUITTER = new Quitter();
	public static final MarqueAction MARQUE_ACTION = new MarqueAction();
	public static final ModeleAction MODELE_ACTION = new ModeleAction();
	public static final TypePieceAction TYPE_PIECE_ACTION = new TypePieceAction();
	public static final VehiculeAction VEHICULE_ACTION = new VehiculeAction();
	public static final CategorieAction CATEGORIE_ACTION = new CategorieAction();
	public static final ActionRelation ACTION_RELATION = new ActionRelation();
	public static final ActionIntrouvable ACTION_INTROUVABLE = new ActionIntrouvable();

}
