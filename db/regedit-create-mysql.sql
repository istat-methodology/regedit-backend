
drop database IF EXISTS regedit;
create database regedit;
use regedit;

 
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

CREATE TABLE `regedit`.`DUG` (
  `id` integer ,
  `name` text ,
  `description` text 
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 
