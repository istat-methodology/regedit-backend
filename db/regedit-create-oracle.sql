CREATE TABLE WP1_INDIRIZZI_DA_REVISIONARE
   (
    PROGRESSIVO_INDIRIZZO NUMBER NOT NULL ENABLE,  
	CODICE_ARCHIVIO NUMBER(3,0) NOT NULL ENABLE, 
	PRO_COM VARCHAR2(6 BYTE) NOT NULL ENABLE,   
	DENOMINAZIONE_COMUNE VARCHAR2(100 BYTE) NOT NULL ENABLE,  
	LOCALITA_ORIGINALE VARCHAR2(100 BYTE), si
	INDIRIZZO_ORIGINALE VARCHAR2(500 BYTE) NOT NULL ENABLE, 
	
	LOCALITA_NORM VARCHAR2(100 BYTE),  
	DUG_NORM VARCHAR2(100 BYTE), 
	DUF_NORM VARCHAR2(400 BYTE), 
	CIVICO_NORM NUMBER, 
	KM_NORM VARCHAR2(100 CHAR), 
	ESPONENTE_NORM VARCHAR2(100 BYTE), 
	
	VALIDAZIONE VARCHAR2(2 BYTE),   
	
	DUG_VAL VARCHAR2(100 BYTE),  
	DUF_VAL VARCHAR2(400 BYTE),        
	CIVICO_VAL NUMBER,  
	KM_VAL VARCHAR2(100 CHAR), 
	ESPONENTE_VAL VARCHAR2(100 BYTE),  
	LOCALITA_VAL VARCHAR2(100 BYTE),  
	
	CDPSTR_EGON NUMBER(12,0), 
	CDPCIV_EGON NUMBER(15,0), 
	
	ID_FONTE NUMBER(3,0),   
	STRATO_INDIRIZZO NUMBER(3,0), 
	ID_REVISORE NUMBER(3,0), 
	STATO NUMBER(3,0),  
	DATA_INS DATE NOT NULL ENABLE, 
	DATA_MOD DATE NOT NULL ENABLE, 
	NOME_FILE VARCHAR2(500 BYTE), 
	 CONSTRAINT PK$WP1_IND_DA_REVISIONARE PRIMARY KEY (PROGRESSIVO_INDIRIZZO)
   ) ;
