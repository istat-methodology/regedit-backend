
drop database IF EXISTS regedit;
create database regedit;
use regedit;

 
CREATE TABLE `regedit`.`WP1_INDIRIZZI_DA_REVISIONARE` (
  `PROGRESSIVO_INDIRIZZO` integer PRIMARY KEY,
  `CODICE_ARCHIVIO` integer,
  `PRO_COM` text,
  `DENOMINAZIONE_COMUNE` text,
  `LOCALITA_ORIGINALE` text,
  `INDIRIZZO_ORIGINALE` text,
  `LOCALITA_NORM` text,
  `DUG_NORM` text,
  `DUF_NORM` text,
  `CIVICO_NORM` integer,
  `KM_NORM` text,
  `ESPONENTE_NORM` text,
  `VALIDAZIONE` text,  
  `DUG_VAL` text,
  `DUF_VAL` text,
  `CIVICO_VAL` integer,
  `KM_VAL` text,
  `ESPONENTE_VAL` text, 
  `LOCALITA_VAL` text,
  `CDPSTR_EGON` integer,
  `CDPCIV_EGON` integer,
  `ID_FONTE` integer,
  `STRATO_INDIRIZZO` integer,
  `ID_REVISORE` integer,
  `STATO` integer,  
  `DATA_INS` DATE,
  `DATA_MOD` DATE,
  `NOME_FILE` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `regedit`.`DUG` (
  `id` integer ,
  `name` text ,
  `description` text 
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 
