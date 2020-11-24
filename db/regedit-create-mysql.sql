
drop database IF EXISTS regedit;
create database regedit;
use regedit;

CREATE TABLE `regedit`.`addresses` (
  `id` integer PRIMARY KEY,
  `codice_archivio_or` text,
  `progressivo_indirizzo_or` text,
  `comune_or` text,
  `localita_or` text,
  `indirizzo_originale` text,
  `localita_su` text,
  `dug_su` text,
  `duf_su` text,
  `civico_su` text,
  `esponente_su` text,
  `validazione` text,
  `dug` text,
  `duf` text,
  `civico` text,
  `esponente` text,
  `localita` text,
  `chiave_strada` text,
  `chiave_civico` text,
  `fonte` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `regedit`.`edit_address` (
  `user` integer ,
  `address` integer ,
  `state` text,
  `date_time` TIMESTAMP 
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 
