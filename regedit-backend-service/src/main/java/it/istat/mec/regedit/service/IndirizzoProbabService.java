package it.istat.mec.regedit.service;  
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import it.istat.mec.regedit.dao.IndirizzoProbabDao;
import it.istat.mec.regedit.dto.IndirizzoProbabDto;
import it.istat.mec.regedit.translators.Translators;

@Service
public class IndirizzoProbabService {
	@Autowired
	IndirizzoProbabDao indirizzoProbabDao;
	
	
	
public List<IndirizzoProbabDto> findAllIndirizzoProbab() {
		
		return indirizzoProbabDao.findAll(Sort.by(Sort.Direction.ASC, "comune")).stream().map(x -> Translators.translate(x)).collect(Collectors.toList());
	}
}
