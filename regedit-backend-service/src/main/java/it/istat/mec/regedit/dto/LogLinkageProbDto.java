package it.istat.mec.regedit.dto;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LogLinkageProbDto implements Serializable {
	 
	private static final long serialVersionUID = -6759179050749499519L;
	
	private String idProcesso;	
	private String codiceArchivio;		
	private String codiciProvincia;		
	private String soglia;		
	private Date dataInizio;		
	private Date dataFine;		
	private Short stato;	
	private String esito;	
	
	public LogLinkageProbDto(String idProcesso, String codiceArchivio, String codiciProvincia, String soglia, Date dataInizio, 
			Date dataFine, Short stato, String esito) {
		super();	
		this.idProcesso = idProcesso;		
		this.codiceArchivio = codiceArchivio;
		this.codiciProvincia = codiciProvincia;
		this.soglia = soglia;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.stato = stato;
		this.esito = esito;
	}
}
