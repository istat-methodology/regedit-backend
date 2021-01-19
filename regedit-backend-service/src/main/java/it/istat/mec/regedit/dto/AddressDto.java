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
package it.istat.mec.regedit.dto;

import java.util.Date;

import javax.persistence.Column;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class AddressDto {
	
	private Integer progressivoIndirizzo;	
	private Integer codiceArchivio;		
	private String proCom;	
	private String denominazioneComune;	
	private String localitaOriginale;	
	private String indirizzoOriginale;	
	private String localitaNorm;	
	private String dugNorm;	
	private String dufNorm;	
	private Integer civicoNorm;	
	private String kmNorm;	
	private String esponenteNorm;	
	private String validazione;		
	private String dugVal;	
	private String dufVal;	
	private Integer civicoVal;	
	private String kmVal;	
	private String esponenteVal;	
	private String localitaVal;		
	private Integer cdpstrEgon;		
	private Integer cdpcivEgon;		
	private Integer idFonte;	
	private Integer stratoIndirizzo;	
	private Integer idRevisore;	
	private Integer idSupervisor;	
	private Short stato;	
	private Date dataIns;	
	private Date dataMod;	
	private String note;
	private String fittizio;
	
	
}
