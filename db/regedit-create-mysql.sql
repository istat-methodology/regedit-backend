
drop database IF EXISTS regedit;
create database regedit;
use regedit;

CREATE TABLE WP1_INDIRIZZI_DA_REVISIONARE
   (
    PROGRESSIVO_INDIRIZZO NUMBER NOT NULL ENABLE,  si
	CODICE_ARCHIVIO NUMBER(3,0) NOT NULL ENABLE, si
	PRO_COM VARCHAR2(6 BYTE) NOT NULL ENABLE,  si
	DENOMINAZIONE_COMUNE VARCHAR2(100 BYTE) NOT NULL ENABLE, si
	LOCALITA_ORIGINALE VARCHAR2(100 BYTE), si
	INDIRIZZO_ORIGINALE VARCHAR2(500 BYTE) NOT NULL ENABLE, si
	
	LOCALITA_NORM VARCHAR2(100 BYTE), si
	DUG_NORM VARCHAR2(100 BYTE), 
	DUF_NORM VARCHAR2(400 BYTE), 
	CIVICO_NORM NUMBER, 
	KM_NORM VARCHAR2(100 CHAR), 
	ESPONENTE_NORM VARCHAR2(100 BYTE), 
	
	VALIDAZIONE VARCHAR2(2 BYTE),   NULL,'SI','NO'
	
	DUG_VAL VARCHAR2(100 BYTE),  combo (excel), obbligatorio
	DUF_VAL VARCHAR2(400 BYTE),                  obbligatorio
	CIVICO_VAL NUMBER,  non obbligatorio
	KM_VAL VARCHAR2(100 CHAR), 
	ESPONENTE_VAL VARCHAR2(100 BYTE), (regola) non obbligatorio
	LOCALITA_VAL VARCHAR2(100 BYTE),  non obbligatorio
	
	CDPSTR_EGON NUMBER(12,0), 
	CDPCIV_EGON NUMBER(15,0), 
	
	ID_FONTE NUMBER(3,0),  combo 1 egon,2 google maps,3 revisore 
	STRATO_INDIRIZZO NUMBER(3,0),  da non visualizzare
	ID_REVISORE NUMBER(3,0), 
	FLAG_ESTRATTO NUMBER(3,0), da sostuire con STATO = NULL da assegnare  , 1 assegnato, 2 lavorato, 3 skipped
	DATA_INS DATE NOT NULL ENABLE, 
	DATA_MOD DATE NOT NULL ENABLE, 
	NOME_FILE VARCHAR2(500 BYTE), 
	 CONSTRAINT PK$WP1_IND_DA_REVISIONARE PRIMARY KEY (PROGRESSIVO_INDIRIZZO)
   ) ;
 
CREATE TABLE `regedit`.`WP1_INDIRIZZI_DA_REVISIONARE` (
  `PROGRESSIVO_INDIRIZZO` integer PRIMARY KEY,
  `CODICE_ARCHIVIO` text,
  `PRO_COM` text,
  `DENOMINAZIONE_COMUNE` text,
  `LOCALITA_ORIGINALE` text,
  `INDIRIZZO_ORIGINALE` text,
  `LOCALITA_NORM` text,
  `DUG_NORM` text,
  `DUF_NORM` text,
  `CIVICO_NORM` text,
  `KM_VAL` text,
  `ESPONENTE_VAL` text,
  `validazione` text,
  `LOCALITA_VAL` text,
  `dug_rev` text,
  `duf_rev` text,
  `civico_rev` text,
  `km_rev` text,
  `esponente_rev` text,  
  `chiave_strada` text,
  `chiave_civico` text,
  `id_fonte` text,
  `id_revisore` integer
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `regedit`.`edit_address` (
  `user` integer ,
  `address` integer ,
  `state` text,
  `date_time` TIMESTAMP 
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 
