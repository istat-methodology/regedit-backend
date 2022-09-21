CREATE TABLE WP1_INDIRIZZI_NO_LINKED 
   (	
    `PROGRESSIVO` INT(10),
	`CODICE_ARCHIVIO` INT(10),
    `PRO_COM` TEXT(6), 
	`INDIRIZZO_ESTESO` TEXT(900), 
	`INDIRIZZO` TEXT(900), 
	`CIVICO` TEXT(100), 
	`INDIRIZZO_DETT` TEXT(900), 
	`DSXPLCSIG_DSXDPT` TEXT(4), 
	`DSXPLCUFF_DSXDPT` TEXT(900), 
	`DSXPLCUFF_DSXCNL` TEXT(900), 
	`DSXPLCUFF_DSXDS1` TEXT(100), 
	`CDXZIP` INT(10), 
	`DSXSTRUFF_DSXADD` TEXT(900), 
	`DSXSTRABB_DSXADD` TEXT(900), 
	`DSXST1_DSXDUG` TEXT(100), 
	`DSXST1_DSXVIA` TEXT(100), 
	`CIVICOST1_NRPNUMCIV` INT(10), 
	`CIVICOST1_DSXESP` TEXT(80), 
	`DSXEXTURB` TEXT(100), 
	`DSXPREINR` TEXT(100), 
	`ATT_VLXATT` INT(4), 
	`BES_VLXBES` TEXT(10), 
	`BES_1_X_G` TEXT(20), 
	`BES_1_Y_G` TEXT(20), 
	`BES_1_X_M` TEXT(20), 
	`BES_1_Y_M` TEXT(20), 
	`GRIGLIA` TEXT(20), 
	`SEZIONE_2011` TEXT(52), 
	`SEZ_2011_HERE_ADDRESS_POINT` TEXT(52), 
	`SEZ_2011_HERE_INTERPOLATE` TEXT(52), 
	`CDPDPT` INT(12), 
	`CDPCNL` INT(12), 
	`CDPDS1` INT(12), 
	`CDPSTR` INT(12), 
	`CDPCIV` INT(15), 
	`ERR_620_LOC_FLXSEG` INT(4), 
	`ERR_620_LOC_CDPSEG` INT(4), 
	`ERR_620_STR_FLXSEG` INT(4), 
	`ERR_620_STR_CDPSEG` INT(4), 
	`ERR_620_CIV_FLXSEG` INT(4), 
	`ERR_620_CIV_CDPSEG` INT(4), 
	`ANNCSU_COMUNE` TEXT(320), 
	`ANNCSU_CODICE_NAZIONALE_STRADA` TEXT(60), 
	`ANNCSU_DUG` TEXT(120), 
	`ANNCSU_STRADA` TEXT(320), 
	`ANNCSU_CODICE_NAZIONALE_CIVICO` TEXT(12), 
	`ID_ISTAT` INT(10), 
	`ANNCSU_FRAZIONE` TEXT(320), 
	`ANNCSU_CIVICO` TEXT(6), 
	`ANNCSU_ESPONENTE` TEXT(60), 
	`ANNCSU_CODICE_SPECIFICITA` TEXT(20), 
	`ANNCSU_SISTEMA_METRICO` TEXT(24), 
	`ANNCSU_PROGR_SNC` TEXT(20), 
	`ANNCSU_SEZIONE_CENSIMENTO` TEXT(17), 
	`LOCALITA` TEXT(60), 
	`SEZIONE_CENSIMENTO` TEXT(13), 
	`DUG_TRAT` TEXT(60), 
	`DUF_TRAT` TEXT(300), 
	`CIVICO_TRAT` TEXT(12), 
	`ESPONENTE_TRAT` TEXT(20), 
	`SOTTOFASE` INT(1), 
    constraint PK$WP1_INDIRIZZI_NO_LINKED primary key (PROGRESSIVO, CODICE_ARCHIVIO)
   );

   CREATE TABLE WP1_TOPONIMI_DA_REVISIONARE
(	
    PROGRESSIVO_TOPONIMO INT NOT NULL AUTO_INCREMENT PRIMARY KEY, -- sequence seq_wp1_toponimi_da_revisionare
    CODICE_ARCHIVIO INT(3) NOT NULL, -- 156 per ora
    PRO_COM TEXT(6),  -- per ora per il filtro della provincia usaimo i primi 3 caratteri del pro_com
    DENOMINAZIONE_COMUNE TEXT(300), 
    -- TOPONIMO ORIGINALE
    -- CDPSTR_RSBL INT(12), -- Codice strada Egon degli indirizzi riconosciuti in egon con l'ultima normalizzazione -- Trasfomato in DOUBLE per errori durante l'inserimento dei dati
    CDPSTR_RSBL DOUBLE,
	LOCALITA_ORIG TEXT(300),  -- Località Originale
    DUG_ORIG TEXT(300), -- Dug Originale
    DUF_ORIG TEXT(300), -- Duf Originale
    -- TOPONIMO PROBABIBILISTICO
    -- CDPSTR_PROB INT(12), -- Codice strada Egon estratto dal probabilistico -- Trasfomato in DOUBLE per errori durante l'inserimento dei dati
    CDPSTR_PROB DOUBLE,
    LOCALITA_PROB  TEXT(300), -- Località Suggerita
    DUG_PROB  TEXT(300), -- Dug Suggerita
    DUF_PROB  TEXT(300), -- Duff Suggerita
    
    VALIDAZIONE TEXT(2), -- SI,NO
    
    -- TOPONIMO REVISIONATO
	LOCALITA_VAL TEXT(300), -- Località revisionata
    DUG_VAL TEXT(300),  -- Dug revisionata
    DUF_VAL TEXT(300), -- Duf revisionata
	CDPSTR_VAL INT(12), -- Codice strada Egon toponimo revisionato
    
    -- CAMPI PROPRI PROCEDURA PROBABILISTICA
    DNC TEXT(15), -- output probabilistico
    FLAG_DUG INT(1),  -- output probabilistico
    MD TEXT(15),   -- output probabilistico
    SOGLIA_W TEXT(15), -- soglia (w) da utilizzare per valutare il sopra e sotto soglia 
    ALT INT(12), -- output probabilistico
    TM TEXT(15), -- output probabilistico
    WMAX TEXT(15), -- output probabilistico
    FALSI_POSITIVI TEXT(15), -- output probabilistico
    FALSI_NEGATIVI TEXT(15), -- output probabilistico
    FLAG_VERIFICA INT,-- output probabilistico
    
    -- CAMPI GESTIONE REGEDIT
    ID_REVISORE INT(3), -- id revisore assegnato al toponimo (WP1_REVISORI)
	STATO INT(3), -- stato di lavorazione: null --> non visibile, 1--> da lavorare , 2--> lavorato, 3--> sospeso
	-- DATA_INS DATE NOT NULL, -- data sistema -- Rimosso il NOT NULL per errori durante l'inserimento dei dati
	DATA_INS DATE, -- data sistema
	DATA_MOD TIMESTAMP (6),  -- data sistema
	ID_SUPERVISOR INT(3),  -- id eventuale supervisore (WP1_REVISORI)
	NOTE TEXT(4000) 
);