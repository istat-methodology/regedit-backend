package it.istat.mec.regedit.dto;
import java.io.Serializable;
import org.springframework.lang.Nullable;



import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ExportToponimiDto implements Serializable {
	private static final long serialVersionUID = 1958222043420954543L;
	@Nullable
	private Double progressivo;
	@Nullable
	private String codice_archivio;
	@Nullable
	private String localita;
	@Nullable
	private String pro_com;	
	@Nullable
	private String indirizzo;	
	@Nullable
	private String civico;	
	@Nullable
	private String indirizzo_dett;	
	@Nullable
	private Integer sottofase;	
	
	public ExportToponimiDto(Double progressivo, String codice_archivio, String localita, String pro_com, String indirizzo, String civico, 
			String indirizzo_dett, Integer sottofase) {
		super();
		this.progressivo = progressivo;
		this.localita = localita;
		this.pro_com = pro_com;
		this.indirizzo = indirizzo;
		this.civico = civico;
		this.indirizzo_dett = indirizzo_dett;
		this.sottofase = sottofase;
	}
	public String getLocalita() {		
		return this.localita == null ? "" :  this.localita;
	}
	public String getPro_com() {
		return this.pro_com == null ? "" :  this.pro_com;
	}
	public String getIndirizzo() {
		return this.indirizzo == null ? "" :  this.indirizzo;
	}
	public String getCivico() {		
		return this.civico == null ? "" :  this.civico;
	}
	public String getIndirizzo_dett() {
		return this.indirizzo_dett == null ? "" :  this.indirizzo_dett;
	}
	

}
