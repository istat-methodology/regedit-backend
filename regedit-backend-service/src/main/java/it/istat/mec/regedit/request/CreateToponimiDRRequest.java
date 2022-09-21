package it.istat.mec.regedit.request;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class CreateToponimiDRRequest implements Serializable {
	
	private static final long serialVersionUID = -6509639945928247724L;
	private int progressivoToponimo;	
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
    private int idRevisore;     
    private int stato;     
	private Date dataIns;    
    private Date dataMod;    
    private int idSupervisor;    
    private String note; 
}

