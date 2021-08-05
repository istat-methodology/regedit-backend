package it.istat.mec.regedit.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class AddressBackupEditedID implements Serializable {

	private static final long serialVersionUID = 1017941611791401267L;

	private Integer editor;
	private Long progressivoIndirizzo;
	private Date dataMod;

	public AddressBackupEditedID(Integer editor, Long progressivoIndirizzo,Date dataMod) {
		super();
		this.editor = editor;
		this.progressivoIndirizzo = progressivoIndirizzo;
		this.dataMod = dataMod;
	}

	public AddressBackupEditedID() {
		super();

	}

}