package it.istat.mec.regedit.service;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;
import it.istat.mec.regedit.dao.ToponimiDaRevisionareDao;
import it.istat.mec.regedit.domain.ToponimiDaRevisionare;
import it.istat.mec.regedit.domain.ToponimoBackupEdited;
import it.istat.mec.regedit.domain.UsersEntity;
import it.istat.mec.regedit.dto.ComuneDto;
import it.istat.mec.regedit.dto.ToponimiDaRevisionareDto;
import it.istat.mec.regedit.dto.UsersDto;
import it.istat.mec.regedit.exceptions.NoDataException;
import it.istat.mec.regedit.request.CreateToponimiDRRequest;
import it.istat.mec.regedit.translators.Translators;

@Service
public class ToponimiDaRevisionareService {
	
	@Value("${app.editing.backup:false}")
	private Boolean editingBackup;

	@Autowired
	ToponimiDaRevisionareDao toponimiDaRevisionareDao;
	
	public List<ToponimiDaRevisionareDto> findAllToponimi() {		
		
		return Translators.translateToponimiDR(toponimiDaRevisionareDao.findAll());
	}
	
	public List<ToponimiDaRevisionareDto> findAllToponimiDRByStatoAndRevisore(Integer revisore, Short stato) {

		return Translators.translateToponimiDR(toponimiDaRevisionareDao.findAllToponimiDRByIdRevisoreAndStatoOrderByDenominazioneComuneAsc(
				(revisore != null) ? new UsersEntity(revisore) : null, stato));

	}
	
	public List<ToponimiDaRevisionareDto> findAllToponimi(Integer revisore, Short stato, String proCom,String validazione,
			String[] orderBy, String[] sort) {

		List<Order> orders = new ArrayList<Order>();
		for (int i = 0; i < orderBy.length; i++) {
			Order order = new Order((i<sort.length &&  Sort.Direction.DESC.name().equalsIgnoreCase(sort[i]))? Sort.Direction.DESC:Sort.Direction.ASC,orderBy[i]);
			orders.add(order);

		}

		Sort sortQuery = Sort.by(orders);
		return Translators.translateToponimiDR(toponimiDaRevisionareDao.findAllWithFilter((revisore != null) ? new UsersEntity(revisore) : null,
				stato, proCom,  validazione, sortQuery));

	}
	
	public List<ComuneDto> findAllComuniByStatoAndRevisore(Integer revisore, Short stato) {

		return toponimiDaRevisionareDao.findAllComuniByIdRevisoreAndStatoOrderByDenominazioneComuneAsc(
				(revisore != null) ? new UsersEntity(revisore) : null, stato);

	}

	
	public ToponimiDaRevisionareDto findToponimoDRById(Long id) {
		if (!toponimiDaRevisionareDao.findById(id).isPresent())
			throw new NoDataException("Toponimo not present");
		return Translators.translate(toponimiDaRevisionareDao.findById(id).get());
	}
	
	public List<UsersDto> getUsersByToponimi() {
		List<UsersDto> users = toponimiDaRevisionareDao.findAllUsersWithToponimiAssigned();
		return users;
	}
	
	public ToponimiDaRevisionareDto getFirstToponimoByUser(Integer user, Short stato, String proCom,String validazione,
			Integer offsetInt, String[] orderBy, String[] sort) {
		
		List<Order> orders = new ArrayList<Order>();
		for (int i = 0; i < orderBy.length; i++) {
			Order order = new Order((i<sort.length &&  Sort.Direction.DESC.name().equalsIgnoreCase(sort[i]))? Sort.Direction.DESC:Sort.Direction.ASC,orderBy[i]);
			orders.add(order);

		}

		Sort sortQuery = Sort.by(orders);
		List<ToponimiDaRevisionare> toponimiDaRevisionare = toponimiDaRevisionareDao.findAllWithFilter(new UsersEntity(user), stato, proCom,  validazione,
				 sortQuery);
		
		int offset = offsetInt != null ? offsetInt.intValue() : 0;
		if (toponimiDaRevisionare.size() == 0 || offset >= toponimiDaRevisionare.size())
			throw new NoDataException("Address no present");
		return Translators.translate(toponimiDaRevisionare.get(offset));

	}
	
	public ToponimiDaRevisionareDto newToponimiDaRevisionare(CreateToponimiDRRequest request) {
		ToponimiDaRevisionare toponimiDaRevisionare = new ToponimiDaRevisionare();
		toponimiDaRevisionare = Translators.translate(request);		
		toponimiDaRevisionare.setDataMod(new Timestamp(System.currentTimeMillis()));
		toponimiDaRevisionareDao.save(toponimiDaRevisionare);		    
		return Translators.translate(toponimiDaRevisionare);
	}
//	public ToponimiDaRevisionareDto updateToponimiDR(CreateToponimiDRRequest request) {		
//		
//		if (!toponimiDaRevisionareDao.findById(request.getProgressivoToponimo()).isPresent())
//			throw new NoDataException("Toponimo not present");
//		
//		ToponimiDaRevisionare toponimiDaRevisionare = toponimiDaRevisionareDao.findById(request.getProgressivoToponimo()).get();	
//		
//		toponimiDaRevisionare = Translators.translateUpdate(request, toponimiDaRevisionare);
//		
//		toponimiDaRevisionareDao.save(toponimiDaRevisionare);		
//		
//		return Translators.translate(toponimiDaRevisionare);
//	}
	
	public ToponimiDaRevisionareDto updateToponimiDR(CreateToponimiDRRequest request, Integer editor) {

		if (!toponimiDaRevisionareDao.findById(request.getProgressivoToponimo()).isPresent())
			throw new NoDataException("Toponimo not present");

		ToponimiDaRevisionare toponimiDaRevisionare = toponimiDaRevisionareDao.findById(request.getProgressivoToponimo()).get();
		toponimiDaRevisionare = Translators.translateUpdate(request, toponimiDaRevisionare);

		toponimiDaRevisionare.setDataMod(new Timestamp(System.currentTimeMillis()));

		toponimiDaRevisionareDao.save(toponimiDaRevisionare);

		if (editingBackup) {
			ToponimoBackupEdited toponimoBackupEdited = new ToponimoBackupEdited();
			toponimoBackupEdited = Translators.translate(toponimiDaRevisionare, toponimoBackupEdited);
			toponimoBackupEdited.setEditor(editor);
			toponimiDaRevisionareDao.save(toponimoBackupEdited);
		}
		return Translators.translate(toponimiDaRevisionare);
	}
	
	public ToponimiDaRevisionareDto deleteToponimo(Long id) {
		if (!toponimiDaRevisionareDao.findById(id).isPresent())
			throw new NoDataException("Toponimo not present");
		ToponimiDaRevisionare toponimiDaRevisionare = toponimiDaRevisionareDao.findById(id).get();
		toponimiDaRevisionareDao.delete(toponimiDaRevisionare);
		return Translators.translate(toponimiDaRevisionare);
	}

}

