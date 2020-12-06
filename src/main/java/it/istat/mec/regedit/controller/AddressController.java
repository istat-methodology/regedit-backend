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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.istat.mec.regedit.domain.Address;
import it.istat.mec.regedit.dto.AddressDto;
import it.istat.mec.regedit.request.CreateAddressRequest;
import it.istat.mec.regedit.request.UpdateAddressRequest;
import it.istat.mec.regedit.service.AddressService;
import it.istat.mec.regedit.translators.Translators;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/regedit")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@GetMapping("/addresses")
	public ResponseEntity<List<AddressDto>> getAllAddresses(@RequestParam(value = "user",required = false) Integer user,
			@RequestParam(value = "stato",required = false) Short stato) {

		return ResponseEntity.ok(addressService.findAllAddressess(user, stato));

	}

	@GetMapping(value = "/addresses/{id}")
	public AddressDto getAddress(@PathVariable("id") Integer id) {

		return addressService.findAddressById(id);

	}

	@GetMapping(value = "/first-address/user/{user}/state/{state}")
	public AddressDto getFirstAddressByUser(@PathVariable("user") Integer user, @PathVariable("state") Short stato) {

		return addressService.getFirstAddressByUser(user, stato);

	}

	@PostMapping("/addresses")
	public AddressDto create(@RequestBody CreateAddressRequest request) {		
			
		return addressService.newAdress(request);
	}

	@PutMapping(value = "/addresses/{addressId}")
	public AddressDto updateAddress(@RequestBody UpdateAddressRequest request) {
		
		
		return addressService.updateAddress(request);
	}	

	@DeleteMapping(value = "/addresses/{id}")
	public AddressDto deleteAddress(@PathVariable("id") Integer id) { 
  
		return addressService.deleteAddress(id);
	}

}
