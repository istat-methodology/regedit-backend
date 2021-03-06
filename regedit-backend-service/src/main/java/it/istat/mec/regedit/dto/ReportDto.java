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

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class ReportDto implements Serializable {

	private static final long serialVersionUID = 934918300970207348L;
	private String user;
	private Short stato;
	private Long count;
	private String validazione;
	private Date dataMod;
	
	public ReportDto(String user, Short stato,String validazione, Long count) {
		super();
		this.user = user;
		this.stato = stato;
		this.count = count;
		this.validazione = validazione;
	}
	public ReportDto(String user, Short stato,String validazione, Date dataMod,Long count) {
		super();
		this.user = user;
		this.stato = stato;
		this.count = count;
		this.validazione = validazione;
		this.dataMod=dataMod;
	}
}
