package it.istat.mec.regedit.domain;
import java.io.Serializable;
public class NoLinkedAddressId implements Serializable {

	private static final long serialVersionUID = -3081876738890956993L;	
	@SuppressWarnings("unused")
	private int progressivo;	
	@SuppressWarnings("unused")
	private int codiceArchivio;
	
	public NoLinkedAddressId(int progressivo, int codiceArchivio) {
        this.progressivo = progressivo;
        this.codiceArchivio = codiceArchivio;
	}
}
