package it.istat.mec.regedit.controller;


import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.REngineException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.istat.mec.regedit.service.RScriptService;


@RestController
@RequestMapping("/regedit")
public class RScriptController {
	@Autowired
	private RScriptService rScriptService;

	@GetMapping(value = "/esegui-rscript")
	public void eseguiRScript() throws REXPMismatchException, REngineException {

		rScriptService.eseguiScript();

	}
}
