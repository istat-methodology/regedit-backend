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
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.istat.mec.regedit.dto.AddressDto;
import it.istat.mec.regedit.request.CreateAddressRequest;
import it.istat.mec.regedit.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import it.istat.mec.regedit.translators.Translators;

@Slf4j
@RestController
@RequestMapping("/regedit")
public class RegEditController {

	@Autowired
	private AddressService addressService;

	@GetMapping("/addresses")
	public ResponseEntity<List<AddressDto>> getAll() {

		return ResponseEntity.ok(addressService.findAllAddressess().stream().map(x -> Translators.translate(x))
				.collect(Collectors.toList()));

	}

	@DeleteMapping(value = "/addresses/{addressId}")
	public AddressDto deleteAddress(@PathVariable("addressId") Long id) {

		return addressService.deleteAddress(id);
	}

	@PostMapping("/addresses")
	public AddressDto create(@RequestBody CreateAddressRequest request) {
		return addressService.newAdress(request.getCodiceArchivioOr(), request.getProgressivoIndirizzoOr(),
				request.getComuneOr(), request.getLocalitaOr(), request.getIndirizzoOriginale(),
				request.getLocalitaSu(), request.getDugSu(), request.getDufSu(), request.getCivicoSu(),
				request.getEsponenteSu(), request.getValidazione(), request.getDug(), request.getDuf(),
				request.getCivico(), request.getEsponente(), request.getLocalita(), request.getChiaveStrada(),
				request.getChiaveCivico(), request.getFonte());
	}

	@GetMapping(value = "/addresses/{id}")
	public AddressDto getAddress(@PathVariable("id") Long id) {

		return addressService.findAddressById(id);

	}
}
