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
import it.istat.mec.regedit.dto.ToponimoDto;
import it.istat.mec.regedit.dto.UsersDto;
import it.istat.mec.regedit.request.CreateToponimoRequest;
import it.istat.mec.regedit.request.UpdateToponimoListRequest;
import it.istat.mec.regedit.security.JwtTokenProvider;
import it.istat.mec.regedit.service.ToponimoService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/regedit")
public class ToponimoController {
	@Autowired
	private ToponimoService toponimoService;
	
	
	@GetMapping("/toponimi-user")
	public List<ToponimoDto> getAllToponimi(@RequestParam(value = "user", required = false) Integer user,
			@RequestParam(value = "stato", required = false) Short stato) {

		return toponimoService.findAllToponimiDRByStatoAndRevisore(user, stato);

	}
	@GetMapping("/toponimi")
	public ResponseEntity<List<ToponimoDto>> getAllToponimi(
			@RequestParam(value = "user", required = false) Integer user,
			@RequestParam(value = "stato", required = false) Short stato,
			@RequestParam(value = "proCom", required = false) String proCom,
			@RequestParam(value = "validazione", required = false) String validazione,
			@RequestParam(value = "toponimoOriginaleContains", required = false) String toponimoOriginaleContains,
			@RequestParam(value = "orderBy", required = false, defaultValue = "denominazioneComune") String[] orderBy,
			@RequestParam(value = "sort", required = false, defaultValue = "ASC") String[] sort) {

		return ResponseEntity.ok(toponimoService.findAllToponimi(user, stato, proCom, validazione,
				toponimoOriginaleContains, orderBy, sort));

	}
	@GetMapping("/toponimi-comuni")
	public List<ComuneDto> getAllComuni(@RequestParam(value = "user", required = false) Integer user,
			@RequestParam(value = "stato", required = false) Short stato) {

		return toponimoService.findAllComuniByStatoAndRevisore(user, stato);

	}
	@GetMapping (value = "/toponimi/{progressivo}")
	public ToponimoDto getToponimoByProgressivo(@PathVariable("progressivo") Long id) { 

		return toponimoService.findToponimoDRById(id);
	}
	
	@GetMapping(value = "/users-toponimi")
	public List<UsersDto> getUsersByToponimiAssigned() {

		return toponimoService.getUsersByToponimi();

	}
	
	@GetMapping(value = "/toponimi/first-toponimo/user/{user}/state/{stato}")
	public ToponimoDto getFirstToponimoByUser(@PathVariable("user") Integer user, @PathVariable("stato") Short stato,
			@RequestParam(value = "proCom", required = false) String proCom,
			@RequestParam(value = "validazione", required = false) String validazione,			
			@RequestParam(value = "offset", required = false) Integer offset,
			@RequestParam(value = "orderBy", required = false, defaultValue = "denominazioneComune") String[] orderBy,
			@RequestParam(value = "sort", required = false, defaultValue = "ASC") String[] sort) {

		return toponimoService.getFirstToponimoByUser(user, stato, proCom, validazione,
				offset, orderBy, sort);

	}
	@PutMapping(value = "/toponimi-list")
	public Integer updateToponimoList(@RequestBody UpdateToponimoListRequest updateToponimoListRequest,
			@RequestHeader(name = "Authorization") final String jwt) {

		return toponimoService.updateToponimoList(updateToponimoListRequest,
				JwtTokenProvider.getUserId(jwt));
	};
	
	@PostMapping("/toponimi")
	public ToponimoDto createToponimo(@RequestBody CreateToponimoRequest request) {		
			
		return toponimoService.newToponimo(request);
	}

	@PutMapping(value = "/toponimi/{progressivo}")
	public ToponimoDto updateToponimo(@RequestBody CreateToponimoRequest request,
			@RequestHeader(name = "Authorization") final String jwt) {

		return toponimoService.updateToponimiDR(request, JwtTokenProvider.getUserId(jwt));
	}
	@DeleteMapping(value = "/toponimi/{id}")
	public ToponimoDto deleteToponimoDR(@PathVariable("id") Long id) { 
  
		return toponimoService.deleteToponimo(id);
	}

}
