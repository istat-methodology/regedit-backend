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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.istat.mec.regedit.dto.ReportDto;
import it.istat.mec.regedit.exceptions.NoDataException;
import it.istat.mec.regedit.service.ReportService;

@RestController
@RequestMapping("/api/report")
public class ReportController {

	@Autowired
	private ReportService reportService;

	@GetMapping
	public List<ReportDto> getAddressStateByUser() {

		return reportService.getReportAddressState();

	}

	@GetMapping(value = "/users/{user}")
	public List<ReportDto> getAddressStateByUser(@PathVariable("user") Integer user) {

		return reportService.getReportAddressStateByUser(user);

	}

	@GetMapping(value = "/users/{user}/states/{state}")
	public ResponseEntity<ReportDto> getAddressStateByUser(@PathVariable("user") Integer user,
			@PathVariable("state") Short state) {

		ReportDto reportDto = reportService.getReportAddressStateByUserAndState(user, state)
				.orElseThrow(() -> new NoDataException());
		return ResponseEntity.ok().body(reportDto);

	}
}
