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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.istat.mec.regedit.dto.AddressDto;
import it.istat.mec.regedit.dto.ComuneDto;
import it.istat.mec.regedit.dto.UsersDto;
import it.istat.mec.regedit.request.CreateAddressRequest;
import it.istat.mec.regedit.request.UpdateAddressListRequest;
import it.istat.mec.regedit.request.UpdateAddressRequest;
import it.istat.mec.regedit.security.JwtTokenProvider;
import it.istat.mec.regedit.service.AddressService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/regedit")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@GetMapping("/addresses")
	public ResponseEntity<List<AddressDto>> getAllAddresses(
			@RequestParam(value = "user", required = false) Integer user,
			@RequestParam(value = "stato", required = false) Short stato,
			@RequestParam(value = "proCom", required = false) String proCom,
			@RequestParam(value = "validazione", required = false) String validazione,
			@RequestParam(value = "indirizzoOriginaleContains", required = false) String indirizzoOriginaleContains,
			@RequestParam(value = "orderBy", required = false, defaultValue = "denominazioneComune,indirizzoOriginale") String[] orderBy,
			@RequestParam(value = "sort", required = false, defaultValue = "ASC,ASC") String[] sort) {

		return ResponseEntity.ok(addressService.findAllAddressess(user, stato, proCom, validazione,
				indirizzoOriginaleContains, orderBy, sort));

	};

	@GetMapping("/addresses-comuni")
	public List<ComuneDto> getAllComuni(@RequestParam(value = "user", required = false) Integer user,
			@RequestParam(value = "stato", required = false) Short stato) {

		return addressService.findAllComuniByStatoAndRevisore(user, stato);

	};

	@GetMapping(value = "/addresses/{id}")
	public AddressDto getAddress(@PathVariable("id") Long id) {

		return addressService.findAddressById(id);

	};
	@GetMapping(value = "/users")
	public List<UsersDto> getUsersByAddressesAssigned() {

		return addressService.getUsersByAddresses();

	};

	@GetMapping(value = "/addresses/first-address/user/{user}/state/{stato}")
	public AddressDto getFirstAddressByUser(@PathVariable("user") Integer user, @PathVariable("stato") Short stato,
			@RequestParam(value = "proCom", required = false) String proCom,
			@RequestParam(value = "validazione", required = false) String validazione,
			@RequestParam(value = "indirizzoOriginaleContains", required = false) String indirizzoOriginaleContains,
			@RequestParam(value = "offset", required = false) Integer offset,
			@RequestParam(value = "orderBy", required = false, defaultValue = "denominazioneComune,indirizzoOriginale") String[] orderBy,
			@RequestParam(value = "sort", required = false, defaultValue = "ASC,ASC") String[] sort) {

		return addressService.getFirstAddressByUser(user, stato, proCom, validazione, indirizzoOriginaleContains,
				offset, orderBy, sort);

	};

	@PostMapping("/addresses")
	public AddressDto create(@RequestBody CreateAddressRequest request) {

		return addressService.newAdress(request);
	};

	@PutMapping(value = "/addresses/{id}")
	public AddressDto updateAddress(@RequestBody UpdateAddressRequest request,
			@RequestHeader(name = "Authorization") final String jwt) {

		return addressService.updateAddress(request, JwtTokenProvider.getUserId(jwt));
	};

	@PutMapping(value = "/addresses-list")
	public Integer updateAddressList(@RequestBody UpdateAddressListRequest updateAddressListRequest,
			@RequestHeader(name = "Authorization") final String jwt) {

		return addressService.updateAddressList(updateAddressListRequest,
				JwtTokenProvider.getUserId(jwt));
	};

	@DeleteMapping(value = "/addresses/{id}")
	public AddressDto deleteAddress(@PathVariable("id") Long id) {

		return addressService.deleteAddress(id);
	};

}
