
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
  `ID_SUPERVISOR` integer,
  `STATO` integer,  
  `DATA_INS` DATETIME,
  `DATA_MOD` DATETIME,
  `NOME_FILE` text,
  `NOTE` text,
  `FLAG_FITTIZIO` varchar(1)
  
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `regedit`.`WP1_INDIRIZZI_DA_REV_HISTORY` (
  `PROGRESSIVO_INDIRIZZO` integer ,
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
  `ID_SUPERVISOR` integer,
  `STATO` integer,  
  `DATA_INS` DATETIME,
  `DATA_MOD` DATETIME,
  `NOME_FILE` text,
  `NOTE` text,
  `FLAG_FITTIZIO` varchar(1),
  `EDITOR` integer
  
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `regedit`.`WP1_DUG` (
  `id` integer AUTO_INCREMENT PRIMARY KEY,  
  `name` text 
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 