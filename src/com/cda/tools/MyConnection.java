package com.cda.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	String url = "jdbc:mysql://localhost:3306/casse_auto_projet?useSSL=false&serverTimezone=UTC";
	String utilisateur = "root";
	String motDePasse = "1598753";
	private static Connection connexion = null;

	private MyConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		if (connexion == null) {
			new MyConnection();
		}
		return connexion;
	}

	public static void stop() {
		if (connexion != null) {
			try {
				connexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
