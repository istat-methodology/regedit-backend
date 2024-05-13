package it.istat.mec.regedit.domain; 
import java.io.Serializable; 
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "IND_PROBAB_PROVA")
public class IndirizzoProbab implements Serializable  {
	
	private static final long serialVersionUID = 2985962201906130543L;
	@Id
	@Column(name = "ROWNAMES")
	private Long rownames;
	@Column(name = "PRO_COM")
	private String proCom;		
	@Column(name = "INDIRIZZO")
	private String indirizzo;
	@Column(name = "CDPSDR")
	private String cdpsdr;
	@Column(name = "LOCALITAX")
	private String localitax;
	@Column(name = "DUGX")
	private String dugx;
	@Column(name = "DUFX")
	private String dufx;
	@Column(name = "CDPSTR")
	private String cdpstr;
	@Column(name = "COMUNE")
	private String comune;
	@Column(name = "LOCALITAY")
	private String localitay;
	@Column(name = "DUGY")
	private String dugy;
	@Column(name = "DUFY")
	private String dufy;	
	@Column(name = "DNC")
	private String dnc;
	@Column(name = "DUG")
	private String dug;
	@Column(name = "MD")
	private String md;
	@Column(name = "W")
	private String w;
//	@Column(name = "ALTER")
//	private String alter;
	@Column(name = "WMAX")
	private String wmax;
	@Column(name = "FALSIPOSITIVI")
	private String falsipositivi;
	@Column(name = "FALSINEGATIVI")
	private String falsinegativi;
	@Column(name = "DENOM_PROV")
	private String denomProv;
	@Column(name = "COD_PROV")
	private String codProv;
	@Column(name = "ORDINE")
	private String ordine;
	@Column(name = "ID_PROCESSO")
	private String idProcesso;
}
