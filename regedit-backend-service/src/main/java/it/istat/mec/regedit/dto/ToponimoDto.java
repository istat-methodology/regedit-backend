package it.istat.mec.regedit.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ToponimoDto implements Serializable {
	private static final long serialVersionUID = -1563709969923106565L;

	private Integer progressivoToponimo;	
	private int codiceArchivio;	
	private String proCom;	
	private String denominazioneComune;	
    private double cdpstrRsbl;    
    private String localitaOrig;    
    private String dugOrig;    
    private String dufOrig;    
    private double cdpstrProb;    
    private String dugProb;      
    private String dufProb; 
    private String localitaProb;
    private String validazione;   
    private String localitaVal;     
    private String dugVal;     
    private String dufVal;   
    private int cdpstrVal;     
    private String dnc;     
    private int flagDug;     
    private String md;     
    private String sogliaW;     
    private int alt;    
    private String tm;   
    private String wmax;    
    private String falsiPositivi;     
    private String falsiNegativi;     
    private int flagVerifica;   
    private Integer idRevisore;     
    private Short stato;     
	private Date dataIns;    
    private Date dataMod;    
    private int idSupervisor;    
    private String note; 
    private String denominazioneProvincia;
    
    public ToponimoDto(String denominazioneComune, String proCom) {
		super();	
		this.denominazioneComune = denominazioneComune;		
		this.proCom = proCom;
	}
}
