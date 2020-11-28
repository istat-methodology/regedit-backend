
drop database IF EXISTS regedit;
create database regedit;
use regedit;

CREATE TABLE `regedit`.`addresses` (
  `id_address` integer PRIMARY KEY,
  `codice_archivio_or` text,
  `progressivo_indirizzo_or` text,
  `pro_com_or` text,
  `denominazione_com` text,
  `localita_or` text,
  `indirizzo_originale` text,
  `localita_su` text,
  `dug_su` text,
  `duf_su` text,
  `civico_su` text,
  `km_suggerito` text,
  `esponente_su` text,
  `validazione` text,
  `localita_rev` text,
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
 
