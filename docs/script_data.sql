insert into categorie(libelle) values("MECANIQUE");
insert into categorie(libelle) values("ELECTRIQUE");
insert into categorie(libelle) values("DIESEL");
insert into categorie(libelle) values("ESSENCE");
insert into categorie(libelle) values("HYBRIDE");
insert into categorie(libelle) values("GPL");
insert into categorie(libelle) values("SUPERETHANOL");
insert into categorie(libelle) values("BICARBUTION");
insert into categorie(libelle) values("GAZOLE");
insert into categorie(libelle) values("RECHARGEABLE");

insert into marque(nomMarque) values("RENAULT");
insert into marque(nomMarque) values("BMW");
insert into marque(nomMarque) values("AUDI");
insert into marque(nomMarque) values("PEUGEOT");
insert into marque(nomMarque) values("FORD");
insert into marque(nomMarque) values("TOYOTA");
insert into marque(nomMarque) values("MERCEDES");
insert into marque(nomMarque) values("CHEVROLET");
insert into marque(nomMarque) values("DACIA");
insert into marque(nomMarque) values("PORSCHE");

insert into modele(nomModele, anneeModele, idMarque) values("Laguna", 2003, 1);
insert into modele(nomModele, anneeModele, idMarque) values("Serie2", 2012, 2);
insert into modele(nomModele, anneeModele, idMarque) values("Rs4", 2019, 3);
insert into modele(nomModele, anneeModele, idMarque) values("Traveller", 2014, 4);
insert into modele(nomModele, anneeModele, idMarque) values("Mustang", 1967, 5);
insert into modele(nomModele, anneeModele, idMarque) values("Prius", 2016, 6);
insert into modele(nomModele, anneeModele, idMarque) values("ClasseA", 2008, 7);
insert into modele(nomModele, anneeModele, idMarque) values("Camaro", 2005, 8);
insert into modele(nomModele, anneeModele, idMarque) values("Duster", 2013, 9);
insert into modele(nomModele, anneeModele, idMarque) values("Macan", 2010, 10);

insert into vehicule(immatriculation, idModele) values("za123bf", 1);
insert into vehicule(immatriculation, idModele) values("fr682sh", 2);
insert into vehicule(immatriculation, idModele) values("ne588fg", 3);
insert into vehicule(immatriculation, idModele) values("ce796ju", 4);
insert into vehicule(immatriculation, idModele) values("by592hu", 5);
insert into vehicule(immatriculation, idModele) values("sj789az", 6);
insert into vehicule(immatriculation, idModele) values("sg469hd", 7);
insert into vehicule(immatriculation, idModele) values("ih753ks", 8);
insert into vehicule(immatriculation, idModele) values("jd156iv", 9);
insert into vehicule(immatriculation, idModele) values("dh853wd", 10);

insert into typepiece(designation, idCategorie) values("cardan", 1);
insert into typepiece(designation, idCategorie) values("verin", 2);
insert into typepiece(designation, idCategorie) values("pneu", 3);
insert into typepiece(designation, idCategorie) values("soupape", 4);
insert into typepiece(designation, idCategorie) values("jante", 5);
insert into typepiece(designation, idCategorie) values("frein", 6);
insert into typepiece(designation, idCategorie) values("volant", 7);
insert into typepiece(designation, idCategorie) values("poignet", 8);
insert into typepiece(designation, idCategorie) values("vitre", 9);
insert into typepiece(designation, idCategorie) values("moteur", 10);

insert into piece(dateRecuperation,prixVente,dateVente, immatriculation, idTypePiece) values("2017-04-24", 1254, null,"za123bf", 1);
insert into piece(dateRecuperation,prixVente,dateVente, immatriculation, idTypePiece) values("2012-03-13", 2556, null,"fr682sh", 2);
insert into piece(dateRecuperation,prixVente,dateVente, immatriculation, idTypePiece) values("2009-12-04", 7835, null,"ne588fg", 3);
insert into piece(dateRecuperation,prixVente,dateVente, immatriculation, idTypePiece) values("2020-11-24", 2351, null,"ce796ju", 4);
insert into piece(dateRecuperation,prixVente,dateVente, immatriculation, idTypePiece) values("2019-07-13", 809, null,"by592hu", 5);
insert into piece(dateRecuperation,prixVente,dateVente, immatriculation, idTypePiece) values("2019-04-23", 4534, null,"sj789az", 6);
insert into piece(dateRecuperation,prixVente,dateVente, immatriculation, idTypePiece) values("2015-02-11", 7842, null,"sg469hd", 7);
insert into piece(dateRecuperation,prixVente,dateVente, immatriculation, idTypePiece) values("2012-10-06", 1000, null,"ih753ks", 8);
insert into piece(dateRecuperation,prixVente,dateVente, immatriculation, idTypePiece) values("2013-06-09", 1566, null,"jd156iv", 9);
insert into piece(dateRecuperation,prixVente,dateVente, immatriculation, idTypePiece) values("2020-09-30", 2346, null,"dh853wd", 10);

insert into convenir(idTypePiece, idModele) values(1, 1);
insert into convenir(idTypePiece, idModele) values(2, 2);
insert into convenir(idTypePiece, idModele) values(3, 3);
insert into convenir(idTypePiece, idModele) values(4, 4);
insert into convenir(idTypePiece, idModele) values(5, 5);
insert into convenir(idTypePiece, idModele) values(6, 6);
insert into convenir(idTypePiece, idModele) values(7, 7);
insert into convenir(idTypePiece, idModele) values(8, 8);
insert into convenir(idTypePiece, idModele) values(9, 9);
insert into convenir(idTypePiece, idModele) values(10, 10);

