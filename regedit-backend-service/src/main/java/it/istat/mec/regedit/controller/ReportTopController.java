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
package it.istat.mec.regedit.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.istat.mec.regedit.dto.ReportDto;
import it.istat.mec.regedit.dto.ReportPivotDto;
import it.istat.mec.regedit.exceptions.NoDataException;
import it.istat.mec.regedit.service.ReportTopService;

@RestController
@RequestMapping("/regedit")
public class ReportTopController {

	@Autowired
	private ReportTopService reportTopService;

	@GetMapping(value = "/report-top")
	public List<ReportDto> getToponimoStateByUser() {

		return reportTopService.getReportToponimoState();

	}

	@GetMapping(value = "/report-top/users/{user}")
	public List<ReportDto> getToponimoStateByUser(@PathVariable("user") Integer user) {

		return reportTopService.getReportToponimoStateByUser(user);

	}

	@GetMapping(value = "/report-top/users/{user}/states/{state}")
	public ResponseEntity<ReportDto> getToponimoStateByUser(@PathVariable("user") Integer user,
			@PathVariable("state") Short state) {

		ReportDto reportDto = reportTopService.getReportToponimoStateByUserAndState(user, state)
				.orElseThrow(() -> new NoDataException());
		return ResponseEntity.ok().body(reportDto);

	}

	@GetMapping(value = "/report-top-daily")
	public List<ReportDto> getDailyToponimoStateByUser() {

		return reportTopService.getReportDailyToponimoState();

	}

	@GetMapping(value = "/report-top-daily/users/{user}")
	public List<ReportDto> getDailyToponimoStateByUser(@PathVariable("user") Integer user) {

		return reportTopService.getReportDailyToponimoStateByUser(user);

	}

	@GetMapping(value = "/report-top-daily/users/{user}/states/{state}")
	public List<ReportDto> getDailyToponimoStateByUser(@PathVariable("user") Integer user,
			@PathVariable("state") Short state) {

		return reportTopService.getReportDailyToponimoStateByUser(user, state);

	}

	@GetMapping(value = "/report-top-pivot")
	public List<ReportPivotDto> getReportPivotToponimoState(@RequestParam(value = "user",required = false) Integer user) {

		return reportTopService.getReportPivotToponimoState(user);

	}

	@GetMapping(value = "/report-top-daily-pivot")
	public List<ReportPivotDto> getReportDailyPivotToponimoStateUser(@RequestParam(value = "user",required = false) Integer user,
			                                                        @RequestParam(value = "dateModInf",required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date dateModInf,
			                                                        @RequestParam(value = "dateModSup",required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date dateModSup) {

		return reportTopService.getReportDailyPivotToponimoStateUser(user,dateModInf,dateModSup);

	}

	@GetMapping(value = "/report-top-total-daily-pivot")
	public List<ReportPivotDto> getReportTotalDailyPivotToponimoStateUser(
			                                                        @RequestParam(value = "dateModInf",required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date dateModInf,
			                                                        @RequestParam(value = "dateModSup",required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date dateModSup) {

		return reportTopService.getReportTotalDailyPivotToponimoStateUser(dateModInf,dateModSup);

	}
}
