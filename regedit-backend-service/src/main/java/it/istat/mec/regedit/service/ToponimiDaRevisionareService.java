package it.istat.mec.regedit.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.istat.mec.regedit.dao.ToponimiDaRevisionareDao;
import it.istat.mec.regedit.domain.ToponimiDaRevisionare;
import it.istat.mec.regedit.dto.ToponimiDaRevisionareDto;
import it.istat.mec.regedit.exceptions.NoDataException;
import it.istat.mec.regedit.request.CreateToponimiDRRequest;
import it.istat.mec.regedit.translators.Translators;

@Service
public class ToponimiDaRevisionareService {

	@Autowired
	ToponimiDaRevisionareDao toponimiDaRevisionareDao;
	
	public List<ToponimiDaRevisionareDto> findAllToponimi() {		
		
		return Translators.translateToponimiDR(toponimiDaRevisionareDao.findAll());
	}
	
	public ToponimiDaRevisionareDto findToponimoDRById(Integer id) {
		if (!toponimiDaRevisionareDao.findById(id).isPresent())
			throw new NoDataException("Toponimo not present");
		return Translators.translate(toponimiDaRevisionareDao.findById(id).get());
	}
	
	public ToponimiDaRevisionareDto newToponimiDaRevisionare(CreateToponimiDRRequest request) {
		ToponimiDaRevisionare toponimiDaRevisionare = new ToponimiDaRevisionare();
		toponimiDaRevisionare = Translators.translate(request);			
		toponimiDaRevisionareDao.save(toponimiDaRevisionare);		    
		return Translators.translate(toponimiDaRevisionare);
	}
	public ToponimiDaRevisionareDto updateToponimiDR(CreateToponimiDRRequest request) {		
		
		if (!toponimiDaRevisionareDao.findById(request.getProgressivoToponimo()).isPresent())
			throw new NoDataException("Toponimo not present");
		
		ToponimiDaRevisionare toponimiDaRevisionare = toponimiDaRevisionareDao.findById(request.getProgressivoToponimo()).get();	
		
		toponimiDaRevisionare = Translators.translateUpdate(request, toponimiDaRevisionare);
		
		toponimiDaRevisionareDao.save(toponimiDaRevisionare);		
		
		return Translators.translate(toponimiDaRevisionare);
	}
	public ToponimiDaRevisionareDto deleteToponimo(Integer id) {
		if (!toponimiDaRevisionareDao.findById(id).isPresent())
			throw new NoDataException("Toponimo not present");
		ToponimiDaRevisionare toponimiDaRevisionare = toponimiDaRevisionareDao.findById(id).get();
		toponimiDaRevisionareDao.delete(toponimiDaRevisionare);
		return Translators.translate(toponimiDaRevisionare);
	}

}

