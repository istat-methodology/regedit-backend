package it.istat.mec.regedit.request;
import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateAddressRequest implements Serializable {


	private static final long serialVersionUID = 5939182470433987956L;
	private Long id;	
	private String codiceArchivioOr;	
	private String progressivoIndirizzoOr;	
	private String comuneOr;	
	private String localitaOr;	
	private String indirizzoOriginale;	
	private String localitaSu;	
	private String dugSu;	
	private String dufSu;	
	private String civicoSu;	
	private String esponenteSu;	
	private String validazione;	
	private String dug;	
	private String duf;	
	private String civico;	
	private String esponente;	
	private String localita;	
	private String chiaveStrada;	
	private String chiaveCivico;	
	private String fonte;
}

