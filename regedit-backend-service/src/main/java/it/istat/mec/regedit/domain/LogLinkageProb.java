package it.istat.mec.regedit.domain;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "LOG_LINKAGE_PROBABILISTICO")
@JsonIgnoreProperties(ignoreUnknown=true)
public class LogLinkageProb implements Serializable {


	private static final long serialVersionUID = -1229262707015198477L;
	@Id	
	@Column(name = "ID_PROCESSO")
	private String idProcesso;
	@Column(name = "CODICE_ARCHIVIO")
	private String codiceArchivio;	
	@Column(name = "CODICI_PROVINCIA")
	private String codiciProvincia;	
	@Column(name = "SOGLIA")
	private String soglia;	
	@Column(name = "DATA_INIZIO")
	private Date dataInizio;	
	@Column(name = "DATA_FINE")
	private Date dataFine;	
	@Column(name = "STATO")
	private Short stato;	
	@Column(name = "ESITO")
	private String esito;	
}
