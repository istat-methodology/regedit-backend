package it.istat.mec.regedit.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class AddressBackupEditedID implements Serializable {

	private static final long serialVersionUID = 1017941611791401267L;

	private Integer editor;
	private Integer progressivoIndirizzo;

	public AddressBackupEditedID(Integer editor, Integer progressivoIndirizzo) {
		super();
		this.editor = editor;
		this.progressivoIndirizzo = progressivoIndirizzo;
	}

	public AddressBackupEditedID() {
		super();

	}

}