package it.istat.mec.regedit.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "WP1_TOPONIMI_DA_REVISIONARE")
public class ToponimiDaRevisionare extends ToponimoBase implements Serializable {

	
	private static final long serialVersionUID = -4595102097449110502L;
	@Id //@GeneratedValue(strategy=GenerationType.IDENTITY)	
	@Column(name = "PROGRESSIVO_TOPONIMO")
	private Integer progressivoToponimo;
	@Column(name = "DATA_MOD")
	private Date dataMod;

}
