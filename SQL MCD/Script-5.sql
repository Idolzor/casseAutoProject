create database casse_auto_projet;

use casse_auto_projet;

CREATE TABLE Categorie(
   idCategorie INT NOT NULL AUTO_INCREMENT,
   libelle VARCHAR(20) NOT NULL,
   PRIMARY KEY(idCategorie)
);
CREATE TABLE Marque(
   idMarque INT NOT NULL AUTO_INCREMENT,
   nomMarque VARCHAR(20) NOT NULL,
   PRIMARY KEY(idMarque)
);
CREATE TABLE TypePiece(
   idTypePiece INT NOT NULL AUTO_INCREMENT,
   designation VARCHAR(20) NOT NULL,
   idCategorie INT NOT NULL,
   PRIMARY KEY(idTypePiece),
   FOREIGN KEY(idCategorie) REFERENCES Categorie(idCategorie)
);
CREATE TABLE Modele(
   idModele INT NOT NULL AUTO_INCREMENT,
   nomModele VARCHAR(20) NOT NULL,
   annneeModele DATE NOT NULL,
   idMarque INT NOT NULL,
   PRIMARY KEY(idModele),
   FOREIGN KEY(idMarque) REFERENCES Marque(idMarque)
);

CREATE TABLE Vehicule(
   immatriculation VARCHAR(15),
   idModele INT NOT NULL,
   PRIMARY KEY(immatriculation),
   FOREIGN KEY(idModele) REFERENCES Modele(idModele)
);
CREATE TABLE Piece(
   idPiece INT NOT NULL AUTO_INCREMENT,
   dateRecuperation DATE NOT NULL,
   prixVente FLOAT(10,2),
   dateVente DATE,
   immatriculation VARCHAR(15) NOT NULL,
   idTypePiece INT NOT NULL,
   PRIMARY KEY(idPiece),
   FOREIGN KEY(immatriculation) REFERENCES Vehicule(immatriculation),
   FOREIGN KEY(idTypePiece) REFERENCES TypePiece(idTypePiece)
);
CREATE TABLE Convenir(
   idTypePiece INT NOT NULL AUTO_INCREMENT,
   idModele INT,
   PRIMARY KEY(idTypePiece, idModele),
   FOREIGN KEY(idTypePiece) REFERENCES TypePiece(idTypePiece),
   FOREIGN KEY(idModele) REFERENCES Modele(idModele)
);
