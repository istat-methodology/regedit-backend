package it.istat.mec.regedit.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class ToponimoBackupEditedID implements Serializable {
	
	private static final long serialVersionUID = -2324836111238155886L;
	
	private Integer editor;
	private Long progressivoToponimo;
	private Date dataMod;

	public ToponimoBackupEditedID(Integer editor, Long progressivoToponimo, Date dataMod) {
		super();
		this.editor = editor;
		this.progressivoToponimo = progressivoToponimo;
		this.dataMod = dataMod;
	}

	public ToponimoBackupEditedID() {
		super();

	}
}
