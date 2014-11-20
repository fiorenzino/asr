CREATE TABLE asr.configurazione  ( 
	id             	bigserial NOT NULL,
	folder         	varchar(255) NULL,
	nome           	varchar(255) NULL,
	orderby        	int4 NOT NULL,
	postfisso      	varchar(255) NULL,
	tipologiaflusso	varchar(255) NULL 
	);
INSERT INTO asr.configurazione(id, folder, nome, orderby, postfisso, tipologiaflusso)
  VALUES(1, '/home/stefano/work/workspaces/asur/asr/docs/data/flussi/', 'A1', 4, '*-a1.txt', 'A1');
INSERT INTO asr.configurazione(id, folder, nome, orderby, postfisso, tipologiaflusso)
  VALUES(2, '/home/stefano/work/workspaces/asur/asr/docs/data/flussi/', 'A2', 5, '*-a2.txt', 'A2');
INSERT INTO asr.configurazione(id, folder, nome, orderby, postfisso, tipologiaflusso)
  VALUES(3, '/home/stefano/work/workspaces/asur/asr/docs/data/flussi/', 'C1', 1, '*-c1.txt', 'C1');
INSERT INTO asr.configurazione(id, folder, nome, orderby, postfisso, tipologiaflusso)
  VALUES(4, '/home/stefano/work/workspaces/asur/asr/docs/data/flussi/', 'C2', 2, '*-c2.txt', 'C2');
INSERT INTO asr.configurazione(id, folder, nome, orderby, postfisso, tipologiaflusso)
  VALUES(5, '/home/stefano/work/workspaces/asur/asr/docs/data/flussi/', 'C2R', 3, '*-c2r.txt', 'C2R');
INSERT INTO asr.configurazione(id, folder, nome, orderby, postfisso, tipologiaflusso)
  VALUES(6, '/home/stefano/work/workspaces/asur/asr/docs/data/flussi/', 'A2R', 6, '*-a2r.txt', 'A2R');
