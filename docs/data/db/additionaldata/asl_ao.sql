-- ----------------------------------------------------------
-- MDB Tools - A library for reading MS Access database files
-- Copyright (C) 2000-2011 Brian Bruns and others.
-- Files in libmdb are licensed under LGPL and the utilities under
-- the GPL, see COPYING.LIB and COPYING files respectively.
-- Check out http://mdbtools.sourceforge.net
-- ----------------------------------------------------------

SET client_encoding = 'UTF-8';

CREATE TABLE "asl_ao"
 (
	"codice_usl"			VARCHAR (6), 
	"denominazione"			VARCHAR (60), 
	"provincia_corrispondente"			VARCHAR (100)
);

-- CREATE INDEXES ...
ALTER TABLE "asl_ao" ADD CONSTRAINT "asl_ao_pkey" PRIMARY KEY ("codice_usl");


-- CREATE Relationships ...
INSERT INTO "asl_ao" ("codice_usl", "denominazione", "provincia_corrispondente") VALUES ('101','PESARO','Pesaro');
INSERT INTO "asl_ao" ("codice_usl", "denominazione", "provincia_corrispondente") VALUES ('102','URBINO','Pesaro');
INSERT INTO "asl_ao" ("codice_usl", "denominazione", "provincia_corrispondente") VALUES ('103','FANO','Pesaro');
INSERT INTO "asl_ao" ("codice_usl", "denominazione", "provincia_corrispondente") VALUES ('104','SENIGALLIA','Ancona');
INSERT INTO "asl_ao" ("codice_usl", "denominazione", "provincia_corrispondente") VALUES ('105','IESI','Ancona');
INSERT INTO "asl_ao" ("codice_usl", "denominazione", "provincia_corrispondente") VALUES ('106','FABRIANO','Ancona');
INSERT INTO "asl_ao" ("codice_usl", "denominazione", "provincia_corrispondente") VALUES ('107','ANCONA','Ancona');
INSERT INTO "asl_ao" ("codice_usl", "denominazione", "provincia_corrispondente") VALUES ('108','CIVITANOVA MARCHE','Macerata');
INSERT INTO "asl_ao" ("codice_usl", "denominazione", "provincia_corrispondente") VALUES ('109','MACERATA','Macerata');
INSERT INTO "asl_ao" ("codice_usl", "denominazione", "provincia_corrispondente") VALUES ('110','CAMERINO-SAN SEVERINO','Macerata');
INSERT INTO "asl_ao" ("codice_usl", "denominazione", "provincia_corrispondente") VALUES ('111','FERMO','Ascoli Piceno');
INSERT INTO "asl_ao" ("codice_usl", "denominazione", "provincia_corrispondente") VALUES ('112','SAN BENEDETTO','Ascoli Piceno');
INSERT INTO "asl_ao" ("codice_usl", "denominazione", "provincia_corrispondente") VALUES ('113','ASCOLI PICENO','Ascoli Piceno');
INSERT INTO "asl_ao" ("codice_usl", "denominazione", "provincia_corrispondente") VALUES ('901','SAN SALVATORE','Pesaro');
INSERT INTO "asl_ao" ("codice_usl", "denominazione", "provincia_corrispondente") VALUES ('902','G.M. LANCISI','Ancona');
INSERT INTO "asl_ao" ("codice_usl", "denominazione", "provincia_corrispondente") VALUES ('903','G. SALESI','Ancona');
INSERT INTO "asl_ao" ("codice_usl", "denominazione", "provincia_corrispondente") VALUES ('904','UMBERTO I - TORRETTE','Ancona');
INSERT INTO "asl_ao" ("codice_usl", "denominazione", "provincia_corrispondente") VALUES ('905','UMBERTO I - TORRETTE','Ancona');
INSERT INTO "asl_ao" ("codice_usl", "denominazione", "provincia_corrispondente") VALUES ('921','INRCA - ANCONA','Ancona');
INSERT INTO "asl_ao" ("codice_usl", "denominazione", "provincia_corrispondente") VALUES ('922','INRCA - APPIGNANO','Macerata');
INSERT INTO "asl_ao" ("codice_usl", "denominazione", "provincia_corrispondente") VALUES ('923','INRCA - FERMO','Ascoli Piceno');
