package it.istat.mec.regedit.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProvinciaDto implements Serializable {
	
	private static final long serialVersionUID = -4792730443225120417L;
	//private String proCom;	
	private String denominazioneProvincia;	
	
	public ProvinciaDto(String denominazioneProvincia) {
		super();	
		this.denominazioneProvincia = denominazioneProvincia;		
		//this.proCom = proCom;
	}
}
