CREATE TABLE asr.applicazione  ( 
	id   	bigserial NOT NULL,
	nome 	varchar(255) NULL,
	sigla	varchar(255) NULL 
	);
INSERT INTO asr.applicazione(id, nome, sigla)
  VALUES(1, 'Cup Regionale', 'CUP');
INSERT INTO asr.applicazione(id, nome, sigla)
  VALUES(2, 'Laboratorio Analisi', 'LA');
INSERT INTO asr.applicazione(id, nome, sigla)
  VALUES(3, 'Nuovo Cup', 'NC');
INSERT INTO asr.applicazione(id, nome, sigla)
  VALUES(4, 'Pronto Soccorso', 'PS');
INSERT INTO asr.applicazione(id, nome, sigla)
  VALUES(5, 'Win Dialisys', 'WD');
INSERT INTO asr.applicazione(id, nome, sigla)
  VALUES(6, 'ARS Passiva Extra', 'ARSPE');
INSERT INTO asr.applicazione(id, nome, sigla)
  VALUES(7, 'ARS Attività Extra', 'ARSAE');
INSERT INTO asr.applicazione(id, nome, sigla)
  VALUES(8, 'ARS Residenti Extra', 'ARSRE');
