package it.istat.mec.regedit.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.istat.mec.regedit.dto.LogLinkageProbDto;
import it.istat.mec.regedit.service.LogLinkageProbService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/regedit")
public class LogLinkageProbController {
	@Autowired
	LogLinkageProbService logLinkageProbService;
	
	@GetMapping (value = "/log-linkage-probabilistico")
	public List<LogLinkageProbDto> getProvinceList() {

		return logLinkageProbService.findAllLogLinkageProb();
	};
	@GetMapping(value = "/log-linkage-probabilistico/{stato}")
	public LogLinkageProbDto getLogLinkageProbByStato(@PathVariable("stato") Short stato) {

		return logLinkageProbService.findAllLogLinkageProbByStato(stato);

	};
}
