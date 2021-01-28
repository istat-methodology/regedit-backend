/**
 * Copyright 2020 ISTAT
 *
 * Licensed under the EUPL, Version 1.1 or – as soon they will be approved by
 * the European Commission - subsequent versions of the EUPL (the "Licence");
 * You may not use this work except in compliance with the Licence. You may
 * obtain a copy of the Licence at:
 *
 * http://ec.europa.eu/idabc/eupl5
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the Licence is distributed on an "AS IS" basis, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * Licence for the specific language governing permissions and limitations under
 * the Licence.
 *
 * @author Francesco Amato <framato @ istat.it>
 * @author Mauro Bruno <mbruno @ istat.it>
 * @author Renzo Iannacone <iannacone @ istat.it>
 * @author Stefano Macone <macone @ istat.it>
 * @version 1.0
 */
package it.istat.mec.regedit.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class AddressBase {

	@Column(name = "CODICE_ARCHIVIO")
	private Integer codiceArchivio;
	@Column(name = "PRO_COM")
	private String proCom;
	@Column(name = "DENOMINAZIONE_COMUNE")
	private String denominazioneComune;
	@Column(name = "LOCALITA_ORIGINALE")
	private String localitaOriginale;
	@Column(name = "INDIRIZZO_ORIGINALE")
	private String indirizzoOriginale;
	@Column(name = "LOCALITA_NORM")
	private String localitaNorm;
	@Column(name = "DUG_NORM")
	private String dugNorm;
	@Column(name = "DUF_NORM")
	private String dufNorm;
	@Column(name = "CIVICO_NORM")
	private Integer civicoNorm;
	@Column(name = "KM_NORM")
	private String kmNorm;
	@Column(name = "ESPONENTE_NORM")
	private String esponenteNorm;
	@Column(name = "VALIDAZIONE")
	private String validazione;
	@Column(name = "DUG_VAL")
	private String dugVal;
	@Column(name = "DUF_VAL")
	private String dufVal;
	@Column(name = "CIVICO_VAL")
	private Integer civicoVal;
	@Column(name = "KM_VAL")
	private String kmVal;
	@Column(name = "ESPONENTE_VAL")
	private String esponenteVal;
	@Column(name = "LOCALITA_VAL")
	private String localitaVal;
	@Column(name = "CDPSTR_EGON")
	private Long cdpstrEgon;
	@Column(name = "CDPCIV_EGON")
	private Long cdpcivEgon;
	@Column(name = "ID_FONTE")
	private Integer idFonte;
	@Column(name = "STRATO_INDIRIZZO")
	private Integer stratoIndirizzo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_REVISORE")
	private UsersEntity idRevisore;
	@Column(name = "ID_SUPERVISOR")
	private Integer idSupervisor;
	@Column(name = "STATO")
	private Short stato;
	@Column(name = "DATA_INS")
	private Date dataIns;
	@Column(name = "DATA_MOD")
	private Date dataMod;
	@Column(name = "NOTE")
	private String note;
	@Column(name = "FLAG_FITTIZIO")
	private String fittizio;

}
