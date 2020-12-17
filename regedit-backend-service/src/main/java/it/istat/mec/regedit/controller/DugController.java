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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.istat.mec.regedit.dto.DugDto;
import it.istat.mec.regedit.request.CreateDugRequest;
import it.istat.mec.regedit.service.DugService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/regedit")
public class DugController {
	@Autowired
	private DugService dugService;
	
	@GetMapping (value = "/dug")
	public List<DugDto> getDugList() {

		return dugService.findAllDug();
	}
	
	@PostMapping("/dug")
	public DugDto create(@RequestBody CreateDugRequest request) {		
			
		return dugService.newDug(request);
	}
	@PutMapping(value = "/dug/{dugId}")
	public DugDto updateDug(@RequestBody CreateDugRequest request) {		
		
		return dugService.updateDug(request);
	}	
	@DeleteMapping(value = "/dug/{id}")
	public DugDto deleteDug(@PathVariable("id") Integer id) { 
  
		return dugService.deleteDug(id);
	}

}
