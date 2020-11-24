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
	@GetMapping("/hello")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("I'm fine !");
    }	
	@GetMapping("/addresses")
	public ResponseEntity<List<AddressDto>> getAll() {

		return ResponseEntity.ok(addressService.findAllAddressess().stream()
				.map(x -> Translators.translate(x)).collect(Collectors.toList()));

	}
	@DeleteMapping(value = "/{addressId}")
    public ResponseEntity<Void> deleteAddress(@PathVariable("addressId") Long id) {
        
		return ResponseEntity.ok().build();
    }
	@PostMapping
	public ResponseEntity<Long> create(@RequestBody CreateAddressRequest request) {
		Long addressId = addressService.newAdress(request.getId(), request.getChiaveCivico(),
				request.getChiaveStrada(), request.getCivico());
		return ResponseEntity.ok(addressId);
	}
}
