package it.istat.mec.regedit.service;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import it.istat.mec.regedit.dao.ProvinciaDao;
import it.istat.mec.regedit.dto.ProvinciaDto;
import it.istat.mec.regedit.translators.Translators;

@Service
public class ProvinciaService {
	@Autowired
	ProvinciaDao provinciaDao;
	
public List<ProvinciaDto> findAllProvince() {
		
		return provinciaDao.findAll(Sort.by(Sort.Direction.ASC, "provincia")).stream().map(x -> Translators.translate(x)).collect(Collectors.toList());
	}
}
