CREATE SCHEMA eserciziolibri;

CREATE TABLE eserciziolibri.Autori (
AutoreID int auto_increment, 
Nome VARCHAR (50) NOT NULL,
Cognome VARCHAR (50) NOT NULL,
AnnoN int,
AnnoM int,
Sesso VARCHAR (1),
Nazione VARCHAR (50),
PRIMARY KEY (AutoreID)
);

CREATE TABLE eserciziolibri.`libri` (
  `LibroID` INT auto_increment,
  `Titolo` varchar(150) NOT NULL,
  `numPag` int DEFAULT NULL,
  `Anno` int DEFAULT NULL,
  `AutoreID` int NOT NULL,
  PRIMARY KEY (`LibroID`),
  KEY `AutoreID` (`AutoreID`),
  CONSTRAINT `libri_ibfk_1` FOREIGN KEY (`AutoreID`) REFERENCES `autori` (`AutoreID`)
);


INSERT INTO eserciziolibri.autori (Nome, Cognome, AnnoN, AnnoM, Sesso, Nazione)
VALUES 
('Alessandro', 'Manzoni', 1785, 1873, 'M', 'Italia'),
('Lev', 'Tolstoi', 1828, 1910, 'M', 'Russia'),
('Bruno', 'Vespa', 1944 , NULL, 'M', 'Italia'),
('Stephen', 'King', 1947, NULL, 'M', 'America'),
('Ernest', 'Hemingway', 1899, 1961, 'M', 'America'),
('Umberto', 'Eco', 1932, 2016, 'm', 'Italia'),
('Susanna', 'Tamaro', 1957, NULL, 'F', 'Italia'),
('Virginia', 'Woolf', 1882, 1941, 'F', 'Inghilterra'),
('Agatha', 'Christie', 1890, 1976, 'F', 'Inghilterra');

INSERT INTO eserciziolibri.libri (Titolo, numPag, Anno, AutoreID)
VALUES 
('I promessi sposi', 1064, 1840, 1),
('Storia della colonna infame', 650, 1840, 1),
('Guerra e pace', 1463, 1865, 2),
('Anna Karenina', 895, 1877, 2),
('Donne al potere', 336, 2022, 3),
('La grande tempesta', 408, 2022, 3),
('Misery', 400, 1987, 4),
('It', 1012, 1986, 4),
('Shining', 592, 1977, 4),
('Il vecchio e il mare', 204, 1952, 5),
('Per chi suona la campana', 518, 1940, 5),
('Fiesta', 288, 1926, 5),
('Il nome della rosa', 624, 1980, 6),
('Il pendolo di Foucault', 430, 1988, 6),
('Va dove ti porta il cuore', 268, 1994, 7),
('Gita al faro', 370, 1927, 7),
('Orlando', 680, 1928, 8),
("Assassinio sull'Orient Express", 350, 1934, 9),
('Sipario', 204, 1975, 9);

INSERT INTO eserciziolibri.genere (Tipo)
VALUES
('Gialli'),
('Horror'),
('Storici'),
('Romanzi');


alter table eserciziolibri.libri add CodiceG int;
alter table eserciziolibri.libri add foreign key (CodiceG) references genere(CodiceG);

UPDATE eserciziolibri.libri
SET CodiceG = 1
WHERE AutoreID = 3 or AutoreID = 9;

UPDATE eserciziolibri.libri
SET CodiceG = 2
WHERE AutoreID = 4;

UPDATE eserciziolibri.libri
SET CodiceG = 3
WHERE AutoreID = 2 OR AutoreID = 6;

UPDATE eserciziolibri.libri
SET CodiceG = 4
WHERE AutoreID = 8 OR AutoreID = 1 OR AutoreID = 7 OR AutoreID = 5;

CREATE TABLE eserciziolibri.editori (
  CodiceE int auto_increment,
  Nome varchar(50),
  PRIMARY KEY (CodiceE)
) ;

INSERT INTO eserciziolibri.editori (Nome)
VALUES
('Mondadori'),
('Rizzoli');

ALTER TABLE eserciziolibri.libri 
ADD CodiceE int,
ADD FOREIGN KEY (CodiceE) REFERENCES editori (CodiceE);

UPDATE eserciziolibri.libri
SET CodiceE = 1
WHERE AutoreID = 9 OR AutoreID = 3 OR AutoreID = 4;

UPDATE eserciziolibri.libri
SET CodiceE = 2
WHERE AutoreID = 6 OR AutoreID = 2 OR AutoreID = 8 OR AutoreID = 1 OR AutoreID = 7 OR AutoreID = 5;

