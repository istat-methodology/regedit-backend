package it.istat.mec.regedit.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class ToponimoBase {
	@Column(name = "CODICE_ARCHIVIO")
	private Integer codiceArchivio;
	@Column(name = "PRO_COM")
	private String proCom;
	@Column(name = "DENOMINAZIONE_COMUNE")
	private String denominazioneComune;
	@Column(name = "CDPSTR_RSBL")
    private Long cdpstrRsbl;
    @Column(name = "LOCALITA_ORIG")
    private String localitaOrig;
    @Column(name = "DUG_ORIG")
    private String dugOrig;
    @Column(name = "DUF_ORIG")
    private String dufOrig;
    @Column(name = "CDPSTR_PROB")
    private Long cdpstrProb;
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
    private Long cdpstrVal; 
    
    @Column(name = "DNC")
    private String dnc; 
    @Column(name = "FLAG_DUG")
    private Integer flagDug; 
    @Column(name = "MD")
    private String md; 
    @Column(name = "SOGLIA_W")
    private String sogliaW; 
    @Column(name = "ALT")
    private Integer alt;
    @Column(name = "TM")
    private String tm;
    @Column(name = "WMAX")
    private String wmax;
    @Column(name = "FALSI_POSITIVI")
    private String falsiPositivi; 
    @Column(name = "FALSI_NEGATIVI")
    private String falsiNegativi; 
    @Column(name = "FLAG_VERIFICA")
    private Integer flagVerifica;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_REVISORE")
	private UsersEntity idRevisore;     
    @Column(name = "STATO")
	private Short stato;
    @Column(name = "DATA_INS")
	private Date dataIns; 
    
    @Column(name = "ID_SUPERVISOR")
    private Integer idSupervisor;
    @Column(name = "NOTE")
    private String note; 
    @Column(name = "DENOMINAZIONE_PROVINCIA")
    private String denominazioneProvincia; 
    
}
