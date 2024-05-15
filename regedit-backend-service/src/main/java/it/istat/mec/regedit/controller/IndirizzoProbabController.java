package it.istat.mec.regedit.controller;   
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public List<IndirizzoProbabDto> getIndirizziProbabList() {

		return indirizzoProbabDaoService.findAllIndirizzoProbab();
	}
	@GetMapping(value = "/indirizzi-probabilistici/{id}")
	public List<IndirizzoProbabDto> getIndirizziProbabListByIdProcess(@PathVariable("id") Long idProcess) {

		return indirizzoProbabDaoService.findAllIndirizzoProbabByIdProcess(idProcess);

	}
}
