package it.istat.mec.regedit.dto;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ExportToponimiDto implements Serializable {
	private static final long serialVersionUID = 1958222043420954543L;
	
	private Integer progressivo;
	private String localita_prob;
	private String pro_com;	
	private String indirizzo;	
	private int civico;	
	private String indirizzo_dett;	
	private int sottofase;	   
}
