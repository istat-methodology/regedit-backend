package it.istat.mec.regedit.service;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import it.istat.mec.regedit.dao.LogLinkageProbDao;
import it.istat.mec.regedit.domain.LogLinkageProb;
import it.istat.mec.regedit.dto.LogLinkageProbDto;
import it.istat.mec.regedit.translators.Translators;

@Service
public class LogLinkageProbService {
	@Autowired
	LogLinkageProbDao logLinkageProbDao;
	
	public List<LogLinkageProbDto> findAllLogLinkageProb() {
		
		return logLinkageProbDao.findAll(Sort.by(Sort.Direction.DESC, "dataInizio")).stream().map(x -> Translators.translate(x)).collect(Collectors.toList());
	}
	
	public LogLinkageProbDto findAllLogLinkageProbByStato(Short stato) {

		List<LogLinkageProb> lista = logLinkageProbDao.findAllLogLinkageProbByStatoDesc(stato);
		LogLinkageProb log =  lista.get(0);		
		
		return Translators.translate(log);

	}
		
}
