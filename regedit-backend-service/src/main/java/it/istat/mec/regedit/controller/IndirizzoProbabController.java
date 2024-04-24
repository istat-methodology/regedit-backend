package it.istat.mec.regedit.controller;   
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.istat.mec.regedit.dto.IndirizzoProbabDto;
import it.istat.mec.regedit.service.IndirizzoProbabService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/regedit")
public class IndirizzoProbabController {
	@Autowired
	private IndirizzoProbabService indirizzoProbabDaoService;
	
	@GetMapping (value = "/indirizzi-probabilistici")
	public List<IndirizzoProbabDto> getProvinceList() {

		return indirizzoProbabDaoService.findAllIndirizzoProbab();
	};
}
