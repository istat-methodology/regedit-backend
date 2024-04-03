package it.istat.mec.regedit.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.istat.mec.regedit.dto.ProvinciaDto;
import it.istat.mec.regedit.service.ProvinciaService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/regedit")
public class ProvinciaController {
	@Autowired
	private ProvinciaService provinciaService;
	
	@GetMapping (value = "/province")
	public List<ProvinciaDto> getProvinceList() {

		return provinciaService.findAllProvince();
	};
}
