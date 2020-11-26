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
package it.istat.mec.regedit.request;
import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateAddressRequest implements Serializable {


	private static final long serialVersionUID = 5939182470433987956L;
	private Long id;	
	private String codiceArchivioOr;	
	private String progressivoIndirizzoOr;	
	private String comuneOr;	
	private String localitaOr;	
	private String indirizzoOriginale;	
	private String localitaSu;	
	private String dugSu;	
	private String dufSu;	
	private String civicoSu;	
	private String esponenteSu;	
	private String validazione;	
	private String dug;	
	private String duf;	
	private String civico;	
	private String esponente;	
	private String localita;	
	private String chiaveStrada;	
	private String chiaveCivico;	
	private String fonte;
}

