SET datestyle TO "ISO, DMY";

DROP TABLE IF EXISTS reservations;
DROP TABLE IF EXISTS defclasses;
DROP TABLE IF EXISTS vols;
DROP TABLE IF EXISTS clients;
DROP TABLE IF EXISTS pilotes;
DROP TABLE IF EXISTS avions;

CREATE TABLE avions
(
	NumAv INTEGER PRIMARY KEY,
	NomAv VARCHAR(20),
	CapAv INTEGER,
	VilleAv VARCHAR(20)
);   


CREATE TABLE pilotes
(
	NumPil INTEGER PRIMARY KEY,
	NomPil VARCHAR(20),
	NaisPil INTEGER,
	VillePil VARCHAR(20)
);


CREATE TABLE clients
(
	NumCl INTEGER PRIMARY KEY,
	NomCl VARCHAR(20),
	NumRueCl INTEGER,
	NomRueCl VARCHAR(20),
	CodePostaleCl INTEGER,
	VilleCl VARCHAR (20)
);      


CREATE TABLE vols
(
	NumVol VARCHAR(15) PRIMARY KEY,
	VilleD VARCHAR(20),
	VilleA VARCHAR(20),
	DateD DATE,
	HD TIME,
	DateA DATE,
	HA TIME,
	NumPil INTEGER,
	NumAv INTEGER
);   


CREATE TABLE defclasses
(
	NumVol VARCHAR(15) REFERENCES vols(NumVol),
	Classe VARCHAR(20),
	CoeffPrix INTEGER,
	PRIMARY KEY (NumVol, Classe)
);   


CREATE TABLE reservations
(
	NumCl INTEGER REFERENCES clients(NumCl),
	NumVol VARCHAR(15),
	Classe VARCHAR(20),
	NbPlaces INTEGER,
	PRIMARY KEY (NumCl, NumVol, Classe),
	FOREIGN KEY (NumVol, Classe) REFERENCES defclasses(NumVol,Classe)
);  


\copy avions FROM AVIONS.txt
\copy pilotes FROM PILOTES.txt
\copy clients FROM CLIENTS.txt
\copy vols FROM VOLS.txt
