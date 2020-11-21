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

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ADDRESSES")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "CODICE_ARCHIVIO_OR")
	private String codiceArchivioOr;
	@Column(name = "PROGRESSIVO_INDIRIZZO_OR")
	private String progressivoIndirizzoOr;
	@Column(name = "COMUNE_OR")
	private String comuneOr;
	@Column(name = "LOCALITA_OR")
	private String localitaOr;
	@Column(name = "INDIRIZZO_ORIGINALE")
	private String indirizzoOriginale;
	@Column(name = "LOCALITA_SU")
	private String localitaSu;
	@Column(name = "DUG_SU")
	private String dugSu;
	@Column(name = "DUF_SU")
	private String dufSu;
	@Column(name = "CIVICO_SU")
	private String civicoSu;
	@Column(name = "ESPONENTE_SU")
	private String esponenteSu;
	@Column(name = "VALIDAZIONE")
	private String validazione;
	@Column(name = "DUG")
	private String dug;
	@Column(name = "DUF")
	private String duf;
	@Column(name = "CIVICO")
	private String civico;
	@Column(name = "ESPONENTE")
	private String esponente;
	@Column(name = "LOCALITA")
	private String localita;
	@Column(name = "CHIAVE_STRADA")
	private String chiaveStrada;
	@Column(name = "CHIAVE_CIVICO")
	private String chiaveCivico;
	@Column(name = "FONTE")
	private String fonte;
}
