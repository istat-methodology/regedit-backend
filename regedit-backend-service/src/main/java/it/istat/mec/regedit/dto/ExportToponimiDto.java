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
	private String localita_prob;
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
	
	public ExportToponimiDto(Double progressivo, String localita_prob, String pro_com, String indirizzo, String civico, 
			String indirizzo_dett, Integer sottofase) {
		super();
		this.progressivo = progressivo;
		this.localita_prob = localita_prob;
		this.pro_com = pro_com;
		this.indirizzo = indirizzo;
		this.civico = civico;
		this.indirizzo_dett = indirizzo_dett;
		this.sottofase = sottofase;
	}
}
