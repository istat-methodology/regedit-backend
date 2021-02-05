package it.istat.mec.regedit.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ComuneDto implements Serializable {
	
	private static final long serialVersionUID = -4792730443225120417L;
	private String proCom;	
	private String denominazioneComune;	
	
	public ComuneDto(String denominazioneComune, String proCom) {
		super();	
		this.denominazioneComune = denominazioneComune;		
		this.proCom = proCom;
	}
}
