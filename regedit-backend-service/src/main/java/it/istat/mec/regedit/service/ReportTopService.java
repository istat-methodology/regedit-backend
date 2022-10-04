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
import it.istat.mec.regedit.dao.ToponimiDaRevisionareDao;
import it.istat.mec.regedit.dto.ReportDto;
import it.istat.mec.regedit.dto.ReportPivotDto;

@Service
public class ReportTopService {
	@Autowired
	ToponimiDaRevisionareDao toponimoDao;

	public List<ReportDto> getReportToponimoState() {

		return toponimoDao.getReportToponimoState();
	}

	public List<ReportDto> getReportToponimoStateByUser(Integer user) {

		return toponimoDao.getReportToponimoStateByUser(user);
	}

	public Optional<ReportDto> getReportToponimoStateByUserAndState(Integer user, Short state) {

		return toponimoDao.getReportToponimoStateByUserAndState(user, state);
	}

	public List<ReportDto> getReportDailyToponimoState() {

		return toponimoDao.getReportDailyToponimoState();
	}

	public List<ReportDto> getReportDailyAddressStateByUser(Integer user) {

		return toponimoDao.getReportDailyToponimoStateByUser(user);
	}

	public List<ReportDto> getReportDailyToponimoStateByUserAndState(Integer user, Short state) {

		return toponimoDao.getReportDailyToponimoStateByUserAndState(user, state);
	}

	public List<ReportPivotDto> getReportPivotToponimoState(Integer user) {
		if (user == null)
			return toponimoDao.getReportPivotToponimoState();
		else
			return toponimoDao.getReportPivotToponimoStateUser(user);
	}

	public List<ReportPivotDto> getReportDailyPivotToponimoStateUser(Integer user, Date dateModInf, Date dateModSup) {
		
		return toponimoDao.getReportDailyPivotToponimoStateUser(user, dateModInf, dateModSup);
	}
	
	public List<ReportPivotDto> getReportTotalDailyPivotToponimoStateUser( Date dateModInf, Date dateModSup) {
		
		return toponimoDao.getReportTotalDailyPivotToponimoStateUser(dateModInf, dateModSup);
	}
}
