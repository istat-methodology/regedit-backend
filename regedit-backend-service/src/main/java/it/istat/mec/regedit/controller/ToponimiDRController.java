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
import it.istat.mec.regedit.dto.ComuneDto;
import it.istat.mec.regedit.dto.ToponimiDaRevisionareDto;
import it.istat.mec.regedit.dto.UsersDto;
import it.istat.mec.regedit.request.CreateToponimiDRRequest;
import it.istat.mec.regedit.security.JwtTokenProvider;
import it.istat.mec.regedit.service.ToponimiDaRevisionareService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/regedit")
public class ToponimiDRController {
	@Autowired
	private ToponimiDaRevisionareService toponimiDaRevisionareService;
	
//	@GetMapping (value = "/toponimi")
//	public List<ToponimiDaRevisionareDto> getToponimiDRList() {
//
//		return toponimiDaRevisionareService.findAllToponimi();
//	}	
	@GetMapping("/toponimi-user")
	public List<ToponimiDaRevisionareDto> getAllToponimi(@RequestParam(value = "user", required = false) Integer user,
			@RequestParam(value = "stato", required = false) Short stato) {

		return toponimiDaRevisionareService.findAllToponimiDRByStatoAndRevisore(user, stato);

	}
	@GetMapping("/toponimi")
	public ResponseEntity<List<ToponimiDaRevisionareDto>> getAllToponimi(
			@RequestParam(value = "user", required = false) Integer user,
			@RequestParam(value = "stato", required = false) Short stato,
			@RequestParam(value = "proCom", required = false) String proCom,
			@RequestParam(value = "validazione", required = false) String validazione,			
			@RequestParam(value = "orderBy", required = false, defaultValue = "denominazioneComune") String[] orderBy,
			@RequestParam(value = "sort", required = false, defaultValue = "ASC") String[] sort) {

		return ResponseEntity.ok(toponimiDaRevisionareService.findAllToponimi(user, stato, proCom, validazione,
				orderBy, sort));

	}
	@GetMapping("/toponimi-comuni")
	public List<ComuneDto> getAllComuni(@RequestParam(value = "user", required = false) Integer user,
			@RequestParam(value = "stato", required = false) Short stato) {

		return toponimiDaRevisionareService.findAllComuniByStatoAndRevisore(user, stato);

	}
	@GetMapping (value = "/toponimi/{progressivo}")
	public ToponimiDaRevisionareDto getToponimiDRByProgressivo(@PathVariable("progressivo") Long id) { 

		return toponimiDaRevisionareService.findToponimoDRById(id);
	}
	
	@GetMapping(value = "/users-toponimi")
	public List<UsersDto> getUsersByToponimiAssigned() {

		return toponimiDaRevisionareService.getUsersByToponimi();

	}
	
	@GetMapping(value = "/toponimi/first-toponimo/user/{user}/state/{stato}")
	public ToponimiDaRevisionareDto getFirstToponimoByUser(@PathVariable("user") Integer user, @PathVariable("stato") Short stato,
			@RequestParam(value = "proCom", required = false) String proCom,
			@RequestParam(value = "validazione", required = false) String validazione,			
			@RequestParam(value = "offset", required = false) Integer offset,
			@RequestParam(value = "orderBy", required = false, defaultValue = "denominazioneComune") String[] orderBy,
			@RequestParam(value = "sort", required = false, defaultValue = "ASC") String[] sort) {

		return toponimiDaRevisionareService.getFirstToponimoByUser(user, stato, proCom, validazione,
				offset, orderBy, sort);

	}
	
	@PostMapping("/toponimi")
	public ToponimiDaRevisionareDto createToponimiDR(@RequestBody CreateToponimiDRRequest request) {		
			
		return toponimiDaRevisionareService.newToponimiDaRevisionare(request);
	}
//	@PutMapping(value = "/toponimi/{id}")
//	public ToponimiDaRevisionareDto updateToponimiDR(@RequestBody CreateToponimiDRRequest request) {		
//		
//		return toponimiDaRevisionareService.updateToponimiDR(request);
//	}	
	@PutMapping(value = "/toponimi/{progressivo}")
	public ToponimiDaRevisionareDto updateToponimiDR(@RequestBody CreateToponimiDRRequest request,
			@RequestHeader(name = "Authorization") final String jwt) {

		return toponimiDaRevisionareService.updateToponimiDR(request, JwtTokenProvider.getUserId(jwt));
	}
	@DeleteMapping(value = "/toponimi/{id}")
	public ToponimiDaRevisionareDto deleteToponimoDR(@PathVariable("id") Long id) { 
  
		return toponimiDaRevisionareService.deleteToponimo(id);
	}

}
