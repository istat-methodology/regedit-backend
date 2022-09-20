package it.istat.mec.regedit.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "WP1_TOPONIMI_DA_REVISIONARE")
public class ToponimiDaRevisionare implements Serializable {

	
	private static final long serialVersionUID = -4595102097449110502L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)	
	@Column(name = "PROGRESSIVO_TOPONIMO")
	private int progressivoToponimo;
	@Column(name = "CODICE_ARCHIVIO")
	private int codiceArchivio;
	@Column(name = "PRO_COM")
	private String proCom;
	@Column(name = "DENOMINAZIONE_COMUNE")
	private String denominazioneComune;
	@Column(name = "CDPSTR_RSBL")
    private int cdpstrRsbl;
    @Column(name = "LOCALITA_ORIG")
    private String localitaOrig;
    @Column(name = "DUG_ORIG")
    private String dugOrig;
    @Column(name = "DUF_ORIG")
    private String dufOrig;
    @Column(name = "CDPSTR_PROB")
    private int cdpstrProb;
    @Column(name = "DUG_PROB")
    private String dugProb;  
    @Column(name = "DUF_PROB")
    private String dufProb;
    @Column(name = "VALIDAZIONE")
    private String validazione;
    
    @Column(name = "LOCALITA_VAL")
    private String localitaVal; 
    @Column(name = "DUG_VAL")
    private String dugVal; 
    @Column(name = "DUF_VAL")
    private String dufVal;
    @Column(name = "CDPSTR_VAL")
    private int cdpstrVal; 
    
    @Column(name = "DNC")
    private String dnc; 
    @Column(name = "FLAG_DUG")
    private int flagDug; 
    @Column(name = "MD")
    private String md; 
    @Column(name = "SOGLIA_W")
    private String sogliaW; 
    @Column(name = "ALT")
    private int alt;
    @Column(name = "TM")
    private String tm;
    @Column(name = "WMAX")
    private String wmax;
    @Column(name = "FALSI_POSITIVI")
    private String falsiPositivi; 
    @Column(name = "FALSI_NEGATIVI")
    private String falsiNegativi; 
    @Column(name = "FLAG_VERIFICA")
    private int flagVerifica;
    
    @Column(name = "ID_REVISORE")
    private int idRevisore; 
    @Column(name = "STATO")
    private int stato; 
    @Column(name = "DATA_INS")
	private Date dataIns; 
    @Column(name = "DATA_MOD")
    private Date dataMod;
    @Column(name = "ID_SUPERVISOR")
    private int idSupervisor;
    @Column(name = "NOTE")
    private String note; 

}
