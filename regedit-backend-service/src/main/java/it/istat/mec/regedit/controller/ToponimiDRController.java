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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import it.istat.mec.regedit.dto.ToponimiDaRevisionareDto;
import it.istat.mec.regedit.request.CreateToponimiDRRequest;
import it.istat.mec.regedit.service.ToponimiDaRevisionareService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/regedit")
public class ToponimiDRController {
	@Autowired
	private ToponimiDaRevisionareService toponimiDaRevisionareService;
	
	@GetMapping (value = "/toponimi")
	public List<ToponimiDaRevisionareDto> getToponimiDRList() {

		return toponimiDaRevisionareService.findAllToponimi();
	}	
	@GetMapping("/toponimi-user")
	public List<ToponimiDaRevisionareDto> getAllToponimi(@RequestParam(value = "user", required = false) Integer user,
			@RequestParam(value = "stato", required = false) Short stato) {

		return toponimiDaRevisionareService.findAllToponimiDRByStatoAndRevisore(user, stato);

	}
	@GetMapping (value = "/toponimi/{progressivo}")
	public ToponimiDaRevisionareDto getToponimiDRByProgressivo(@PathVariable("progressivo") Integer id) { 

		return toponimiDaRevisionareService.findToponimoDRById(id);
	}
	
	@PostMapping("/toponimi")
	public ToponimiDaRevisionareDto createToponimiDR(@RequestBody CreateToponimiDRRequest request) {		
			
		return toponimiDaRevisionareService.newToponimiDaRevisionare(request);
	}
	@PutMapping(value = "/toponimi/{id}")
	public ToponimiDaRevisionareDto updateToponimiDR(@RequestBody CreateToponimiDRRequest request) {		
		
		return toponimiDaRevisionareService.updateToponimiDR(request);
	}	
	@DeleteMapping(value = "/toponimi/{id}")
	public ToponimiDaRevisionareDto deleteToponimoDR(@PathVariable("id") Integer id) { 
  
		return toponimiDaRevisionareService.deleteToponimo(id);
	}

}
