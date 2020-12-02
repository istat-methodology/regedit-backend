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

import java.util.Calendar;
import java.util.Date;
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
import it.istat.mec.regedit.request.UpdateAddressRequest;
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
	public AddressDto deleteAddress(@PathVariable("addressId") Integer id) {

		return addressService.deleteAddress(id);
	}

	@PostMapping("/addresses")
	public AddressDto create(@RequestBody CreateAddressRequest request) {
		return addressService.newAdress(request.getProgressivoIndirizzo(), request.getCodiceArchivio(),
				request.getProCom(), request.getDenominazioneComune(), request.getLocalitaOriginale(), request.getIndirizzoOriginale(),
				request.getLocalitaNorm(), request.getDugNorm(), request.getDufNorm(), request.getCivicoNorm(), request.getKmNorm(),
				request.getEsponenteNorm(), request.getValidazione(), request.getDugVal(), request.getDufVal(),
				request.getCivicoVal(), request.getKmVal(), request.getEsponenteVal(), request.getLocalitaVal(), request.getCdpstrEgon(),
				request.getCdpcivEgon(), request.getIdFonte(), request.getStratoIndirizzo(), request.getIdRevisore(),
				request.getStato(), request.getDataIns(), request.getDataMod(), request.getNomeFile());
	}

	@GetMapping(value = "/addresses/{id}")
	public AddressDto getAddress(@PathVariable("id") Integer id) {

		return addressService.findAddressById(id);

	}
	@GetMapping(value = "/addresses/{user}")
	public List<AddressDto> getAddressesByUser(@PathVariable("user") Integer user) {
		return addressService.getAddressesByUser(user);
	}
	
	@GetMapping(value = "/address/{user}")
	public AddressDto getFirstAddressesByUser(@PathVariable("user") Integer user) {
		return addressService.getAddressesByUser(user).get(0);
	}
	@PostMapping(value = "/addresses/{addressId}")
	public AddressDto updateAddress(@RequestBody UpdateAddressRequest request) {
		AddressDto addressDto = addressService.findAddressById(request.getProgressivoIndirizzo());
		addressDto.setValidazione(request.getValidazione());
		addressDto.setDugVal(request.getDugVal());
		addressDto.setDufVal(request.getDufVal());
		addressDto.setCivicoVal(request.getCivicoVal());
		addressDto.setKmVal(request.getKmVal());
		addressDto.setEsponenteVal(request.getEsponenteVal());
		addressDto.setLocalitaVal(request.getLocalitaVal());
		addressDto.setCdpstrEgon(request.getCdpstrEgon());
		addressDto.setCdpcivEgon(request.getCdpcivEgon());
		addressDto.setIdFonte(request.getIdFonte());
		addressDto.setStato(request.getStato());
		Calendar calendar = Calendar.getInstance();
		Date now = calendar.getTime();
		addressDto.setDataMod(now);
		
		return addressDto;	
	}
	@PostMapping(value = "/addresses/{validate}")
	public AddressDto validateAddress(@RequestBody UpdateAddressRequest request) {
		AddressDto addressDto = addressService.findAddressById(request.getProgressivoIndirizzo());
		
		addressDto.setStato(request.getStato());
		Calendar calendar = Calendar.getInstance();
		Date now = calendar.getTime();
		addressDto.setDataMod(now);
		
		return addressDto;	
	}
	
	
	
	
}
