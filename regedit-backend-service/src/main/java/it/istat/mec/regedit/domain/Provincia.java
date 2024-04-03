package it.istat.mec.regedit.domain;

import java.io.Serializable;

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
@Table(name = "PROVINCE")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Provincia implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id	
	@Column(name = "COD_PROV")
	private String cod_prov;
	@Column(name = "PROVINCIA")
	private String provincia;	
}