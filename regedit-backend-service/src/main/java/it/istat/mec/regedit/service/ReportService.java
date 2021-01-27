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
package it.istat.mec.regedit.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.istat.mec.regedit.dao.AddressDao;
import it.istat.mec.regedit.dto.ReportDto;
import it.istat.mec.regedit.dto.ReportPivotDto;

@Service
public class ReportService {
	@Autowired
	AddressDao addressDao;

	public List<ReportDto> getReportAddressState() {

		return addressDao.getReportAddressState();
	}

	public List<ReportDto> getReportAddressStateByUser(Integer user) {

		return addressDao.getReportAddressStateByUser(user);
	}

	public Optional<ReportDto> getReportAddressStateByUserAndState(Integer user, Short state) {

		return addressDao.getReportAddressStateByUserAndState(user, state);
	}

	public List<ReportDto> getReportDailyAddressState() {

		return addressDao.getReportDailyAddressState();
	}

	public List<ReportDto> getReportDailyAddressStateByUser(Integer user) {

		return addressDao.getReportDailyAddressStateByUser(user);
	}

	public List<ReportDto> getReportDailyAddressStateByUserAndState(Integer user, Short state) {

		return addressDao.getReportDailyAddressStateByUserAndState(user, state);
	}

	public List<ReportPivotDto> getReportPivotAddressState(Integer user) {
		if (user == null)
			return addressDao.getReportPivotAddressState();
		else
			return addressDao.getReportPivotAddressStateUser(user);
	}

	public List<ReportPivotDto> getReportDailyPivotAddressStateUser(Integer user, Date dateModInf, Date dateModSup) {
		
		return addressDao.getReportDailyPivotAddressStateUser(user, dateModInf, dateModSup);
	}
	
	public List<ReportPivotDto> getReportTotalDailyPivotAddressStateUser( Date dateModInf, Date dateModSup) {
		
		return addressDao.getReportTotalDailyPivotAddressStateUser(dateModInf, dateModSup);
	}
}
