package it.istat.mec.regedit.service;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import it.istat.mec.regedit.dao.LogLinkageProbDao;
import it.istat.mec.regedit.dto.LogLinkageProbDto;
import it.istat.mec.regedit.translators.Translators;

@Service
public class LogLinkageProbService {
	@Autowired
	LogLinkageProbDao logLinkageProbDao;
	
	public List<LogLinkageProbDto> findAllLogLinkageProb() {
		
		return logLinkageProbDao.findAll(Sort.by(Sort.Direction.ASC, "dataInizio")).stream().map(x -> Translators.translate(x)).collect(Collectors.toList());
	}
		
}
