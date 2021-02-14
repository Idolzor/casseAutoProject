package com.cda.menu.action;

import com.cda.model.Book;
import com.cda.tools.MyConnection;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

public class ExportExcelAction extends Action {

	private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
		HSSFFont font = workbook.createFont();
		font.setBold(true);
		HSSFCellStyle style = workbook.createCellStyle();
		style.setFont(font);
		return style;
	}

	private static final int ID = 10;
	private static final String DESC = "Export excel";

	ExportExcelAction() {
		super(ID, DESC);
	}

	@Override
	public boolean executer() {
		ArrayList<Book> list = new ArrayList<>();
		Connection c = MyConnection.getConnection();
		try {
			PreparedStatement statement = c.prepareStatement(
					"select count(piece.dateVente) as piece, modele.nomModele as Nom, modele.annneeModele as annee\r\n"
							+ "from vehicule\r\n" + "inner join piece on\r\n"
							+ "vehicule.immatriculation = piece.immatriculation\r\n" + "inner join modele on\r\n"
							+ "vehicule.idModele = modele.idModele\r\n" + "group by nomModele\r\n"
							+ "order by annee desc\r\n" + "limit 3;");
			ResultSet r = statement.executeQuery();
			int i = 0;
			while (r.next()) {
				list.add(new Book(r.getString("piece"), r.getString("Nom"), r.getString("annee")));
			}
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet("Tableau ");

			int rownum = 0;
			Cell cell;
			Row row;
			//

			HSSFCellStyle style = createStyleForTitle(workbook);

			row = sheet.createRow(rownum);

			// Piece
			cell = row.createCell(0, CellType.STRING);
			cell.setCellValue("Piece");
			cell.setCellStyle(style);
			// Nom
			cell = row.createCell(1, CellType.STRING);
			cell.setCellValue("Nom");
			cell.setCellStyle(style);
			// Salaire
			cell = row.createCell(2, CellType.STRING);
			cell.setCellValue("Annee");
			cell.setCellStyle(style);
			
			for (Book car : list) {
	            rownum++;
	            row = sheet.createRow(rownum);
	 
	            // EmpNo (A)
	            cell = row.createCell(0, CellType.STRING);
	            cell.setCellValue(car.getPiece());
	            // EmpName (B)
	            cell = row.createCell(1, CellType.STRING);
	            cell.setCellValue(car.getNom());
	            // Salary (C)
	            cell = row.createCell(2, CellType.STRING);
	            cell.setCellValue(car.getAnnee());
	        }		
			
	        File file = new File("C:/Outils/JavaBooks.xls");
	        file.getParentFile().mkdirs(); 
	        FileOutputStream outFile = new FileOutputStream(file);
	        workbook.write(outFile);
	        System.out.println("Created file: " + file.getAbsolutePath());

		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("Fichier créer");
		return Boolean.TRUE;
	}
}