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
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	@Column(name = "PROGRESSIVO_INDIRIZZO_OR")
	private String progressivoIndirizzo;
	@Column(name = "CODICE_ARCHIVIO_OR")
	private String codiceArchivioOr;	
	@Column(name = "PRO_COM_OR")
	private String proComOr;
	@Column(name = "DENOMINAZIONE_COM")
	private String denominazioneComune;
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
	@Column(name = "KM_SUGGERITO")
	private String kmSuggerito;
	@Column(name = "ESPONENTE_SU")
	private String esponenteSu;
	@Column(name = "VALIDAZIONE")
	private String validazione;
	@Column(name = "LOCALITA_REV")
	private String localitaRev;
	@Column(name = "DUG_REV")
	private String dugRev;
	@Column(name = "DUF_REV")
	private String dufRev;
	@Column(name = "CIVICO_REV")
	private String civicoRev;
	@Column(name = "ESPONENTE_REV")
	private String esponenteRev;	
	@Column(name = "CHIAVE_STRADA")
	private String chiaveStrada;
	@Column(name = "CHIAVE_CIVICO")
	private String chiaveCivico;
	@Column(name = "ID_FONTE")
	private String idFonte;
	@Column(name = "ID_REVISORE")
	private Integer idRevisore;
	@Column(name = "STATO")
	private Short stato;

}
