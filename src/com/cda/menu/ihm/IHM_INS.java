package com.cda.menu.ihm;

import java.util.Scanner;



public class IHM_INS {

	static Scanner scanner = new Scanner(System.in);

	
	public static int lireChoix() {

		boolean nbTrouve = false;

		while (nbTrouve == false) {
			System.out.println("Saississez une action");
			System.out.print("Choix : ");
			int saisie = scanner.nextInt();

			if (saisie >= 0 && saisie <= 99) {
				nbTrouve = true;
				return saisie;
			} else {
				System.out
						.println("Saisie erronée");
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
						.println(saisie + " l'année renseignée n'est pas correcte, merci de recommencer votre saisie");
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
						.println(saisie + " l'année renseignée n'est pas correcte, merci de recommencer votre saisie");
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
	
		

		return nom.toLowerCase();
	}





}
