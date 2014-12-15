-- ----------------------------------------------------------
-- MDB Tools - A library for reading MS Access database files
-- Copyright (C) 2000-2011 Brian Bruns and others.
-- Files in libmdb are licensed under LGPL and the utilities under
-- the GPL, see COPYING.LIB and COPYING files respectively.
-- Check out http://mdbtools.sourceforge.net
-- ----------------------------------------------------------

SET client_encoding = 'UTF-8';

CREATE TABLE "discipline"
 (
	"codice_disc"			VARCHAR (510), 
	"codice_disc_2006"			VARCHAR (510), 
	"descrizione"			VARCHAR (510)
);

-- CREATE INDEXES ...


-- CREATE Relationships ...
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('000','00','Non specificata');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('001','01','Allergologia');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('002','02','Day hospital');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('003','03','Anatomia - ist pat');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('005','05','Angiologia');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('006','06','Cardiologia pediatrica');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('007','07','Cardiochirurgia');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('008','08','Cardiologia');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('009','09','Chirurgia generale');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('010','10','Chirurgia maxillo facciale');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('011','11','Chirurgia pediatrica');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('012','12','Chirurgia plastica');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('013','13','Chirurgia toracica');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('014','14','Chirurgia vascolare');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('015','15','Medicina sportiva');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('017','17','Citologia');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('018','18','Ematologia');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('019','19','Malattie endocrine/diabetologia');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('020','20','Immunologia');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('021','21','Geriatria');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('022','22','Residuale manicomiale');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('024','24','Malattie infettive tropicali');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('025','25','Medicina del lavoro');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('026','26','Medicina generale');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('027','27','Medicina legale');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('028','28','Unità spinale');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('029','29','Nefrologia');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('030','30','Neurochirurgia');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('031','31','Nido');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('032','32','Neurologia');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('033','33','Neuropsichiatria infantile');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('034','34','Oculistica');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('035','35','Odontoiatria e stomatologia');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('036','36','Ortopedia e traumatologia');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('037','37','Ostetricia e ginecologia');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('038','38','Otorinolaringoiatria');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('039','39','Pediatria');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('040','40','Psichiatria');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('041','41','Medicina termale');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('042','42','Tossicologia');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('043','43','Urologia');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('045','45','Sert');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('046','46','Grandi ustioni pediatriche');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('047','47','Grandi ustioni');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('048','48','Nefrologia');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('049','49','Terapia intensiva');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('050','50','Unita coronarica');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('051','51','Astanteria');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('052','52','Dermatologia');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('053','53','Analgesia');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('054','54','Emodialisi');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('055','55','Farmacologia clinica');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('056','56','Recupero e riabilitazione funzionale');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('057','57','Fisiopatologia della riproduzione');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('058','58','Gastroenterologia');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('060','60','Lungodegenti');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('061','61','Medicina nucleare');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('062','62','Neonatologia');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('064','64','Oncologia');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('065','65','Oncoematologia pediatrica');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('066','66','Oncoematologia');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('067','67','Pensionati');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('068','68','Pneumologia');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('069','69','Radiologia');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('070','70','Radioterapia');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('071','71','Reumatologia');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('073','73','Terapia intensiva neonatale');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('074','74','Radioterapia oncologica');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('075','75','Neuro riabilitazione');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('076','76','Neurochirurgia pediatrica');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('077','77','Nefrologia pediatrica');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('078','78','Urologia pediatrica');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('082','82','Anestesia');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('088','88','Dietetica nutrizione clinica');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('090','90','Igiene epid. e sanità pubblica');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('091','91','Org. servizi sanitari di base');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('093','93','Fisica sanitaria');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('094','94','Igiene e org. sanitaria ospedaliera');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('097','97','Detenuti');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('100','59','Laboratorio analisi');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('101','79','Virologia');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('102','44','Centro trasfusionale/Immunoematologia');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('103','69','Radiodiagnostica');
INSERT INTO "discipline" ("codice_disc", "codice_disc_2006", "descrizione") VALUES ('104','69','Neuroradiologia');
