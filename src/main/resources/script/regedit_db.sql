
drop database regedit;
create database regedit;
use regedit;

CREATE TABLE `addresses` (
  `id` integer,
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

ALTER TABLE `regedit`.`addresses` 
CHANGE COLUMN `id` `id` TEXT NOT NULL ,
ADD PRIMARY KEY (`id`);