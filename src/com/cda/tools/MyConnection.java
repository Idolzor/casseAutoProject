package com.cda.tools;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

public class MyConnection {

	String url = "jdbc:mysql://localhost:3306/casse_auto_projet?useSSL=false&serverTimezone=UTC";
	String utilisateur = "root";
	String motDePasse = "";
	private static Connection connexion = null;

	private MyConnection() {
		DataSource dataSource = MyDataSourceFactory.getMySQLDataSource();
		try {
			connexion = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		if (connexion == null) {
			new MyConnection();
		}
		return connexion;
	}
}