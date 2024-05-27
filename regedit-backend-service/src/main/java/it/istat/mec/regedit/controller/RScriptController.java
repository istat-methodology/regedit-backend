package it.istat.mec.regedit.controller;
import java.util.ArrayList;
import java.util.List;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.REngineException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.istat.mec.regedit.request.ScriptRequest;
import it.istat.mec.regedit.service.RScriptService;


@RestController
@RequestMapping("/regedit")
public class RScriptController {
	@Autowired
	private RScriptService rScriptService;

	@GetMapping(value = "/esegui-rscript/{province}/{codArchivio}/{soglia}")

	//public String eseguiRScript(@RequestBody ScriptRequest scriptParameters) {
        
	public String eseguiRScript(@PathVariable("province") List<String> province,@PathVariable("codArchivio") String codArchivio, @PathVariable("soglia") String soglia) {
        //System.out.println("variabili in input:" + params.province.toString() + "-" + codArchivio +  "-" + soglia.toString());
		String result=null;
		List<String> elencoProvince= new ArrayList<String>();
		for (String provincia: province) {
            elencoProvince.add(provincia.substring(0, 3));
        }
		try {
			ScriptRequest scriptParameters = new ScriptRequest();
			scriptParameters.setProvince(elencoProvince);
			scriptParameters.setCodArchivio(codArchivio);
			scriptParameters.setSoglia(soglia);
			result = rScriptService.eseguiScript(scriptParameters);
		} catch (REXPMismatchException | REngineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result=e.getMessage();
		}
		return result;

	}
	@GetMapping(value = "/checkR")
	public String checkR() {
        
		return rScriptService.checkR();
		

	}
}
