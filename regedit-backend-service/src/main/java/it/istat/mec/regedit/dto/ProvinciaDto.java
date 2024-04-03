package it.istat.mec.regedit.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProvinciaDto implements Serializable {
	
	private static final long serialVersionUID = -1137487682445048643L;
	private String cod_prov;
	private String provincia;	
	
	public ProvinciaDto(String cod_prov, String provincia) {
		super();	
		this.cod_prov = cod_prov;		
		this.provincia = provincia;
	}
}
