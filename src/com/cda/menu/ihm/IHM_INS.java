package com.cda.menu.ihm;

import java.util.Scanner;
import org.slf4j.LoggerFactory;

import org.slf4j.Logger;

public class IHM_INS {
	static Logger logger = LoggerFactory.getLogger(IHM_INS.class);

	static Scanner scanner = new Scanner(System.in);

	public static int lireChoix() {

		boolean isNumber = true;
		int y;
		while (isNumber) {
			System.out.println("Choix : ");

			try {
				y = (int) Integer.valueOf(scanner.next());
				isNumber = false;
				return y;
			} catch (Exception e) {
				System.out.println("veuillez entrer un nombre");
				logger.error("erreur", e);
			}

		}

		return 0;
	}

	public static String lireMarque() {
		System.out.print("Saississez la marque du véhicule : ");
		String saisie = scanner.next();

		return saisie.toUpperCase();
	}

	public static String lireModele() {
		System.out.print("Saississez le modele du véhicule : ");
		String saisie = scanner.next();

		return upperCaseFirst(saisie);
	}

	public static String lireTypePiece() {
		System.out.println("Saisissez le type de piece :");
		String saisie = scanner.next();
		return saisie.toUpperCase();
	}

	public static int lireAnnee() {

		boolean nbTrouve = false;
		while (nbTrouve == false) {
			System.out.print("Année : ");
			int saisie = scanner.nextInt();

			if (saisie >= 1900 && saisie <= 3000) {
				nbTrouve = true;
				return saisie;
			} else {
				System.out
						.println(saisie + " l'année renseignée n'est pas correcte, merci de recommencer votre saisie");
			}
		}
		return 0;
	}

	public static int lireJour() {

		boolean nbTrouve = false;

		while (nbTrouve == false) {
			System.out.print("Jour : ");
			int saisie = scanner.nextInt();

			if (saisie >= 0 && saisie <= 31) {
				nbTrouve = true;
				return saisie;
			} else {
				System.out
						.println(saisie + " le jour renseignée n'est pas correcte, merci de recommencer votre saisie");
			}
		}
		return 0;
	}

	public static int lireMois() {

		boolean nbTrouve = false;

		while (nbTrouve == false) {
			System.out.print("Mois : ");
			int saisie = scanner.nextInt();

			if (saisie >= 0 && saisie <= 12) {
				nbTrouve = true;
				return saisie;
			} else {
				System.out
						.println(saisie + " le mois renseignée n'est pas correcte, merci de recommencer votre saisie");
			}
		}
		return 0;
	}

	public static String lireCategorie() {
		System.out.print("Saississez la categorie : ");
		String saisie = scanner.next();

		return saisie.toUpperCase();
	}

	public static String lireImmatriculation() {
		System.out.print("Saississez l'immatriculation du véhicule : ");
		String saisie = scanner.next();

		return saisie.toLowerCase();
	}

	public static String upperCaseFirst(String val) {
		String val1 = val.toLowerCase();
		char[] arr = val1.toCharArray();
		arr[0] = Character.toUpperCase(arr[0]);
		return new String(arr);
	}

	public static String lireDesignationPiece() {
		System.out.print("Designation de la piece : ");
		String nom = scanner.next();
		System.out.println("référence : ");
		String reference = scanner.next();

		return nom.toLowerCase() + "|ref:" + reference.toLowerCase();
	}

	public static Float lirePrix() {

		System.out.println("Saississez le prix de vente : ");
		Float PDV = scanner.nextFloat();

		return PDV;
	}

}
