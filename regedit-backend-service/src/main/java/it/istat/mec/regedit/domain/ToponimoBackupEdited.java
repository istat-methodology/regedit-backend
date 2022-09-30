package it.istat.mec.regedit.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "WP1_TOPONIMI_DA_REV_HISTORY")
@IdClass(ToponimoBackupEditedID.class)
public class ToponimoBackupEdited extends ToponimiDaRevisionare implements Serializable {

	
	private static final long serialVersionUID = -3804798835339548060L;
	@Id
	@Column(name = "editor")
	private Integer editor;

	@Id
	@Column(name = "PROGRESSIVO_TOPONIMO")
	private Long progressivoToponimo;

	@Id
	@Column(name = "DATA_MOD")
	private Date dataMod;

}
