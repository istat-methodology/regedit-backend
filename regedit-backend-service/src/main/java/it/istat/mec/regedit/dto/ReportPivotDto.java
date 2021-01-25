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
public class ReportPivotDto implements Serializable {

	private static final long serialVersionUID = 934918300270207348L;
	private Integer userId;
    private String userEmail;
    private String userName; 
    private String userSurname; 
    private String userRole; 
    
	private Long dalavorare;
	private Long validati;
	private Long revisionati;
	private Long sospesi;
	private Date dataMod;
	
	public ReportPivotDto(Integer userId, String userEmail, String userName, String userSurname, String userRole, Long dalavorare, Long validati, Long revisionati, Long sospesi) {
		super();
		this.userId=userId;
		this.userEmail=userEmail;
		this.userName=userName; 
		this.userSurname=userSurname; 
		this.userRole=userRole; 
		this.dalavorare = dalavorare;
		this.validati = validati;
		this.revisionati = revisionati;
		this.sospesi = sospesi;
		this.dataMod=null;
		
	}
	
	public ReportPivotDto(Integer userId, String userEmail, String userName, String userSurname, String userRole, Date dataMod, Long dalavorare, Long validati, Long revisionati, Long sospesi) {
		super();
		this.userId=userId;
		this.userEmail=userEmail;
		this.userName=userName; 
		this.userSurname=userSurname; 
		this.userRole=userRole; 
		this.dalavorare = dalavorare;
		this.validati = validati;
		this.revisionati = revisionati;
		this.sospesi = sospesi;
		this.dataMod=dataMod;
	}
	
}
