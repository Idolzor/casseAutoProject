package com.cda.menu.action;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.cda.tools.MyConnection;

public class ExportJsonAction extends Action {

	private static final int ID = 15;
	private static final String DESC = "Export json";

	ExportJsonAction() {
		super(ID, DESC);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean executer() {
		Connection c = MyConnection.getConnection();
		try {
			PreparedStatement statement = c.prepareStatement(
					"select count(piece.dateVente) as piece, modele.nomModele as Nom, modele.annneeModele as annee\r\n"
							+ "from vehicule\r\n" + "inner join piece on\r\n"
							+ "vehicule.immatriculation = piece.immatriculation\r\n" + "inner join modele on\r\n"
							+ "vehicule.idModele = modele.idModele\r\n" + "group by nomModele\r\n"
							+ "order by annee desc\r\n" + "limit 3;");
			ResultSet r = statement.executeQuery();
			JSONObject jo = new JSONObject();
			while (r.next()) {			
				jo.put("Piece", r.getString("piece") + "");
				jo.put("Annee", r.getString("Nom") + "");
				jo.put("Nom", r.getString("annee"));
			}

			JSONArray tab = new JSONArray();
			tab.add(jo);
			JSONObject finalJson = new JSONObject();
			finalJson.put("Tableau", tab);
			Path jsonPath = Paths.get("C:/Outils/export.json");

			try (PrintWriter writer = new PrintWriter(jsonPath.toString())) {
				writer.print(finalJson);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Fichier créer");
		return Boolean.TRUE;
	}
}