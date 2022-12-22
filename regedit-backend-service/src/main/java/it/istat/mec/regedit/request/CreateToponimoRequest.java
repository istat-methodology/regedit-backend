package it.istat.mec.regedit.request;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class CreateToponimoRequest implements Serializable {
	
	private static final long serialVersionUID = -6509639945928247724L;
	private Long progressivoToponimo;	
	private Integer codiceArchivio;	
	private String proCom;	
	private String denominazioneComune;	
    private Long cdpstrRsbl;    
    private String localitaOrig;    
    private String dugOrig;    
    private String dufOrig;    
    private Long cdpstrProb;    
    private String dugProb;      
    private String dufProb;    
    private String validazione;   
    private String localitaVal;     
    private String dugVal;     
    private String dufVal;   
    private Long cdpstrVal;     
    private String dnc;     
    private Integer flagDug;     
    private String md;     
    private String sogliaW;     
    private Integer alt;    
    private String tm;   
    private String wmax;    
    private String falsiPositivi;     
    private String falsiNegativi;     
    private Integer flagVerifica;   
    private Integer idRevisore;     
    private Integer stato;     
	private Date dataIns;    
    private Date dataMod;    
    private Integer idSupervisor;    
    private String note; 
    private String denominazioneProvincia;
    private String toponimoOrig;	
    private String toponimoProb;	
}

