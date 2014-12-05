-- ----------------------------------------------------------
-- MDB Tools - A library for reading MS Access database files
-- Copyright (C) 2000-2011 Brian Bruns and others.
-- Files in libmdb are licensed under LGPL and the utilities under
-- the GPL, see COPYING.LIB and COPYING files respectively.
-- Check out http://mdbtools.sourceforge.net
-- ----------------------------------------------------------

SET client_encoding = 'UTF-8';

CREATE TABLE "regioni"
 (
	"codreg"			VARCHAR (6), 
	"descriz"			VARCHAR (100)
);

-- CREATE INDEXES ...
ALTER TABLE "regioni" ADD CONSTRAINT "regioni_pkey" PRIMARY KEY ("codreg");


-- CREATE Relationships ...
INSERT INTO "regioni" ("codreg", "descriz") VALUES ('010','PIEMONTE');
INSERT INTO "regioni" ("codreg", "descriz") VALUES ('020','VALLE D''AOSTA');
INSERT INTO "regioni" ("codreg", "descriz") VALUES ('030','LOMBARDIA');
INSERT INTO "regioni" ("codreg", "descriz") VALUES ('041','PROV. AUTON. BOLZANO');
INSERT INTO "regioni" ("codreg", "descriz") VALUES ('042','PROV. AUTON. TRENTO');
INSERT INTO "regioni" ("codreg", "descriz") VALUES ('050','VENETO');
INSERT INTO "regioni" ("codreg", "descriz") VALUES ('060','FRIULI VENEZIA GIULIA');
INSERT INTO "regioni" ("codreg", "descriz") VALUES ('070','LIGURIA');
INSERT INTO "regioni" ("codreg", "descriz") VALUES ('080','EMILIA ROMAGNA');
INSERT INTO "regioni" ("codreg", "descriz") VALUES ('090','TOSCANA');
INSERT INTO "regioni" ("codreg", "descriz") VALUES ('100','UMBRIA');
INSERT INTO "regioni" ("codreg", "descriz") VALUES ('110','MARCHE');
INSERT INTO "regioni" ("codreg", "descriz") VALUES ('120','LAZIO');
INSERT INTO "regioni" ("codreg", "descriz") VALUES ('121','IST.BAMBIN GESU''');
INSERT INTO "regioni" ("codreg", "descriz") VALUES ('122','ACISMOM');
INSERT INTO "regioni" ("codreg", "descriz") VALUES ('130','ABRUZZO');
INSERT INTO "regioni" ("codreg", "descriz") VALUES ('140','MOLISE');
INSERT INTO "regioni" ("codreg", "descriz") VALUES ('150','CAMPANIA');
INSERT INTO "regioni" ("codreg", "descriz") VALUES ('160','PUGLIA');
INSERT INTO "regioni" ("codreg", "descriz") VALUES ('170','BASILICATA');
INSERT INTO "regioni" ("codreg", "descriz") VALUES ('180','CALABRIA');
INSERT INTO "regioni" ("codreg", "descriz") VALUES ('190','SICILIA');
INSERT INTO "regioni" ("codreg", "descriz") VALUES ('200','SARDEGNA');
