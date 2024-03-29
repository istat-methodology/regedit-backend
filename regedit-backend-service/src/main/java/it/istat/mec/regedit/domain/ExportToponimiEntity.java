package it.istat.mec.regedit.domain;

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
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@Entity
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
public class ExportToponimiEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Long progressivo;
	@Nullable
	private String codice_archivio;
	@Nullable
	private String localita;
	@Nullable
	private String pro_com;	
	@Nullable
	private String indirizzo;	
	@Nullable
	private String civico;	
	@Nullable
	private String indirizzo_dett;	
	@Nullable
	private Integer sottofase;	
}
