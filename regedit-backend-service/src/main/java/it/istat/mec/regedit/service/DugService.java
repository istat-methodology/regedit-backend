package it.istat.mec.regedit.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.istat.mec.regedit.dao.DugDao;
import it.istat.mec.regedit.dto.DugDto;
import it.istat.mec.regedit.translators.Translators;

@Service
public class DugService {
	@Autowired
	DugDao dugDao;
	
	public List<DugDto> findAllDug() {
		return dugDao.findAll().stream().map(x -> Translators.translate(x)).collect(Collectors.toList());
	}

}
