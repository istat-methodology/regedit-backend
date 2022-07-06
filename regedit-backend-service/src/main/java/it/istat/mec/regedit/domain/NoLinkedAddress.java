package it.istat.mec.regedit.domain;
import java.io.Serializable;
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
@IdClass(NoLinkedAddressId.class)
@Table(name = "WP1_INDIRIZZI_NO_LINKED")
public class NoLinkedAddress implements Serializable {

	private static final long serialVersionUID = -5604661140382255332L;
	@Id
	@Column(name = "PROGRESSIVO")
	private int progressivo;
	@Id
	@Column(name = "CODICE_ARCHIVIO")
	private int codiceArchivio;
	@Column(name = "PRO_COM")
	private String proCom;
	@Column(name = "INDIRIZZO_ESTESO")
	private String indirizzoEsteso;
	@Column(name = "INDIRIZZO")
	private String indirizzo;
	@Column(name = "CIVICO")
	private String civico;
	@Column(name = "INDIRIZZO_DETT")
	private String indirizzoDett;
	@Column(name = "DSXPLCSIG_DSXDPT")
	private String dsxplcsigDsxdpt;
	@Column(name = "DSXPLCUFF_DSXDPT")
	private String dsxplcuffDsxdpt;
	@Column(name = "DSXPLCUFF_DSXCNL")
	private String dsxplcuffDsxcnl;
	@Column(name = "DSXPLCUFF_DSXDS1")
	private String dsxplcuffDsxds1;
	@Column(name = "CDXZIP")
	private int cdxzip;
	@Column(name = "DSXSTRUFF_DSXADD")
	private String dsxstruffDsxadd;
	@Column(name = "DSXSTRABB_DSXADD")
	private String dsxstrabbDsxadd;
	@Column(name = "DSXST1_DSXDUG")
	private String dsxst1Dsxdug;
	@Column(name = "DSXST1_DSXVIA")
	private String dsxst1Dsxvia;
	@Column(name = "CIVICOST1_NRPNUMCIV")
	private int civicost1Nrpnumciv;
	@Column(name = "CIVICOST1_DSXESP")
	private String civcost1Dsxesp;
	@Column(name = "DSXEXTURB")
	private String dsxexturb;
	@Column(name = "DSXPREINR")
	private String dsxpreinr;
	@Column(name = "ATT_VLXATT")
	private int attVlxatt;
	@Column(name = "BES_VLXBES")
	private String besVlxbes;
	@Column(name = "BES_1_X_G")
	private String bes1xg;
	@Column(name = "BES_1_Y_G")
	private String bes1yg;
	@Column(name = "BES_1_X_M")
	private String bes1xm;
	@Column(name = "BES_1_Y_M")
	private String bes1ym; 
	@Column(name = "GRIGLIA")
	private String griglia;
	@Column(name = "SEZIONE_2011")
	private String sezione2011;
	@Column(name = "SEZ_2011_HERE_ADDRESS_POINT")
	private String sez2011hereAddressPoint;
	@Column(name = "SEZ_2011_HERE_INTERPOLATE")
	private String sez2011hereInterpolate;
	@Column(name = "CDPDPT")
	private int cdpdpt;
	@Column(name = "CDPCNL")
	private int cdpnl;
	@Column(name = "CDPDS1")
	private int cdpds1;
	@Column(name = "CDPSTR")
	private int cdpstr;
	@Column(name = "CDPCIV")
	private int cdpciv;
	@Column(name = "ERR_620_LOC_FLXSEG")
	private int err620locFlxseg;
	@Column(name = "ERR_620_LOC_CDPSEG")
	private int err620locCdpseg;
	@Column(name = "ERR_620_STR_FLXSEG")
	private int err620strFlxseg;
	@Column(name = "ERR_620_STR_CDPSEG")
	private int err620strCdseg;
	@Column(name = "ERR_620_CIV_FLXSEG")
	private int err620civFlxseg;
	@Column(name = "ERR_620_CIV_CDPSEG")
	private int err620civCdpseg;
	@Column(name = "ANNCSU_COMUNE")
	private String anncsuComune; 
	@Column(name = "ANNCSU_CODICE_NAZIONALE_STRADA")
	private String anncsuCodiceNazionaleStrada;
	@Column(name = "ANNCSU_DUG")
	private String anncsuDug;
	@Column(name = "ANNCSU_STRADA")
	private String anncsuStrada;
	@Column(name = "ANNCSU_CODICE_NAZIONALE_CIVICO")
	private String anncsuCodiceNazionaleCivico;
	@Column(name = "ID_ISTAT")
	private int idIstat;
	@Column(name = "ANNCSU_FRAZIONE")
	private String anncsuFrazione;
	@Column(name = "ANNCSU_CIVICO")
	private String anncsuCivico;
	@Column(name = "ANNCSU_ESPONENTE")
	private String anncsuEsponente;
	@Column(name = "ANNCSU_CODICE_SPECIFICITA")
	private String anncsuCodiceSpecificita;
	@Column(name = "ANNCSU_SISTEMA_METRICO")
	private String anncsuSistemaMetrico;
	@Column(name = "ANNCSU_PROGR_SNC")
	private String anncsuProgrSnc; 
	@Column(name = "ANNCSU_SEZIONE_CENSIMENTO")
	private String anncsuSezioneCensimento;
	@Column(name = "LOCALITA")
	private String localita;
	@Column(name = "SEZIONE_CENSIMENTO")
	private String sezioneensimento; 
	@Column(name = "DUG_TRAT")
	private String dugTrat;
	@Column(name = "DUF_TRAT")
	private String dufTrat;
	@Column(name = "CIVICO_TRAT")
	private String civicoTrat;
	@Column(name = "ESPONENTE_TRAT")
	private String esponenteTrat;
	@Column(name = "SOTTOFASE")
	private int sottofase;
}
