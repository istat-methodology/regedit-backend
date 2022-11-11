package it.istat.mec.regedit.service;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;
import it.istat.mec.regedit.dao.ToponimoDao;
import it.istat.mec.regedit.dao.ToponimoBackupDao;
import it.istat.mec.regedit.domain.Toponimo;
import it.istat.mec.regedit.domain.ToponimoBackupEdited;

import it.istat.mec.regedit.domain.UsersEntity;
import it.istat.mec.regedit.dto.ToponimoDto;
import it.istat.mec.regedit.dto.ComuneDto;
import it.istat.mec.regedit.dto.ProvinciaDto;
import it.istat.mec.regedit.dto.UsersDto;
import it.istat.mec.regedit.exceptions.NoDataException;
import it.istat.mec.regedit.request.CreateToponimoRequest;

import it.istat.mec.regedit.request.UpdateToponimoListRequest;
import it.istat.mec.regedit.translators.Translators;

@Service
public class ToponimoService {
	
	@Value("${app.editing.backup:false}")
	private Boolean editingBackup;

	@Autowired
	ToponimoDao toponimoDao;
	
	@Autowired
	ToponimoBackupDao toponimoBackupDao;
	
	/*
	 * public List<ToponimoDto> findAllToponimi() {
	 * 
	 * return Translators.translateToponimiDR(toponimoDao.findAll()); }
	 */
	
	
	public List<ToponimoDto> findAllToponimiDRByStatoAndRevisore(Integer
			 revisore, Short stato) {
	 
		return Translators.translateToponimiDR(toponimoDao.
				findAllToponimiDRByIdRevisoreAndStatoOrderByDenominazioneComuneAsc( (revisore
						!= null) ? new UsersEntity(revisore) : null, stato));	 
	}
	
	
	public List<ToponimoDto> findAllToponimi(Integer revisore, Short stato, String proCom,String validazione,
			String toponimoOriginaleContains,String[] orderBy, String[] sort) {

		List<Order> orders = new ArrayList<Order>();
		for (int i = 0; i < orderBy.length; i++) {
			Order order = new Order((i<sort.length &&  Sort.Direction.DESC.name().equalsIgnoreCase(sort[i]))? Sort.Direction.DESC:Sort.Direction.ASC,orderBy[i]);
			orders.add(order);

		}

		Sort sortQuery = Sort.by(orders);
		return Translators.translateToponimiDR(toponimoDao.findAllWithFilter((revisore != null) ? new UsersEntity(revisore) : null,
				stato, proCom,  validazione, toponimoOriginaleContains, sortQuery));

		
	}
	
	
	public List<ComuneDto> findAllComuniByStatoAndRevisore(Integer revisore, Short stato) {

		return toponimoDao.findAllComuniByIdRevisoreAndStatoOrderByDenominazioneComuneAsc(
				(revisore != null) ? new UsersEntity(revisore) : null, stato);

	}

	
	public List<ProvinciaDto> findAllProvinceByStatoAndRevisore(Integer revisore, Short stato) {

		return toponimoDao.findAllProvinceByIdRevisoreAndStatoOrderByDenominazioneProvinciaAsc(
				(revisore != null) ? new UsersEntity(revisore) : null, stato);

	}

	 public ToponimoDto findToponimoDRById(Long id) { if
	 (!toponimoDao.findById(id).isPresent()) throw new
	 NoDataException("Toponimo not present"); return
	 Translators.translate(toponimoDao.findById(id).get()); }
	 
	
	public List<UsersDto> getUsersByToponimi() {
		List<UsersDto> users = toponimoDao.findAllUsersWithToponimiAssigned();
		return users;
	}
	
	public ToponimoDto getFirstToponimoByUser(Integer user, Short stato, String proCom,String validazione,
			Integer offsetInt, String[] orderBy, String[] sort) {
		
		List<Order> orders = new ArrayList<Order>();
		for (int i = 0; i < orderBy.length; i++) {
			Order order = new Order((i<sort.length &&  Sort.Direction.DESC.name().equalsIgnoreCase(sort[i]))? Sort.Direction.DESC:Sort.Direction.ASC,orderBy[i]);
			orders.add(order);

		}

		Sort sortQuery = Sort.by(orders);
		List<Toponimo> toponimiDaRevisionare = toponimoDao.findAllWithFilter(new UsersEntity(user), stato, proCom,  validazione,
				 validazione, sortQuery);
		
		int offset = offsetInt != null ? offsetInt.intValue() : 0;
		if (toponimiDaRevisionare.size() == 0 || offset >= toponimiDaRevisionare.size())
			throw new NoDataException("toponimo no present");
		return Translators.translate(toponimiDaRevisionare.get(offset));

	}
	
	/*
	 * public ToponimoDto newToponimiDaRevisionare(CreateToponimoRequest request) {
	 * Toponimo toponimiDaRevisionare = new Toponimo(); toponimiDaRevisionare =
	 * Translators.translate(request); toponimiDaRevisionare.setDataMod(new
	 * Timestamp(System.currentTimeMillis()));
	 * toponimoDao.save(toponimiDaRevisionare); return
	 * Translators.translate(toponimiDaRevisionare); }
	 */
	/*
	 * public ToponimoDto updateToponimiDR(CreateToponimoRequest request) {
	 * 
	 * if (!toponimoDao.findById(request.getProgressivoToponimo()).isPresent())
	 * throw new NoDataException("Toponimo not present");
	 * 
	 * Toponimo toponimiDaRevisionare =
	 * toponimoDao.findById(request.getProgressivoToponimo()).get();
	 * 
	 * toponimiDaRevisionare = Translators.translateUpdate(request,
	 * toponimiDaRevisionare);
	 * 
	 * toponimoDao.save(toponimiDaRevisionare);
	 * 
	 * return Translators.translate(toponimiDaRevisionare); }
	 */
	
	
	  public ToponimoDto updateToponimiDR(CreateToponimoRequest request, Integer
	  editor) {
	  
	  if (!toponimoDao.findById(request.getProgressivoToponimo()).isPresent())
	  throw new NoDataException("Toponimo not present");
	  
	  Toponimo toponimiDaRevisionare =
	  toponimoDao.findById(request.getProgressivoToponimo()).get();
	  toponimiDaRevisionare = Translators.translateUpdate(request,
	  toponimiDaRevisionare);
	  
	  toponimiDaRevisionare.setDataMod(new Timestamp(System.currentTimeMillis()));
	  
	  toponimoDao.save(toponimiDaRevisionare);
	  
	  if (editingBackup) { ToponimoBackupEdited toponimoBackupEdited = new
	  ToponimoBackupEdited(); toponimoBackupEdited =
	  Translators.translate(toponimiDaRevisionare, toponimoBackupEdited);
	  toponimoBackupEdited.setEditor(editor);
	  toponimoBackupDao.save(toponimoBackupEdited); } return
	  Translators.translate(toponimiDaRevisionare); }
	 
	
	public ToponimoDto deleteToponimo(Long id) {
		if (!toponimoDao.findById(id).isPresent())
			throw new NoDataException("Toponimo not present");
		Toponimo toponimiDaRevisionare = toponimoDao.findById(id).get();
		toponimoDao.delete(toponimiDaRevisionare);
		return Translators.translate(toponimiDaRevisionare);
	}
	
	
	public ToponimoDto newToponimo(CreateToponimoRequest request) {
		Toponimo toponimo = new Toponimo();
		toponimo = Translators.translate(request);
		toponimo.setDataMod(new Timestamp(System.currentTimeMillis()));
		toponimoDao.save(toponimo);
		return Translators.translate(toponimo);
	}

	public ToponimoDto findToponimoById(Long id) {

		if (!toponimoDao.findById(id).isPresent())
			throw new NoDataException("Toponimo no present");
		return Translators.translate(toponimoDao.findById(id).get());
	}

	public List<ToponimoDto> getToponimiByUser(Integer user, Short stato) {
		List<ToponimoDto> toponimoes = toponimoDao.findByIdRevisoreAndStatoOrderByProComAsc(new UsersEntity(user), stato)
				.stream().map(x -> Translators.translate(x)).collect(Collectors.toList());

		return toponimoes;

	}
	
	/*
	 * public List<UsersDto> getUsersByToponimi() { List<UsersDto> users =
	 * toponimoDao.findAllUsersWithToponimiAssigned(); return users; }
	 */
	

	/*
	 * public ToponimoDto getFirstToponimoByUser(Integer user, Short stato, String
	 * proCom,String validazione, String indirizzoOriginaleContains, Integer
	 * offsetInt, String[] orderBy, String[] sort) {
	 * 
	 * List<Order> orders = new ArrayList<Order>(); for (int i = 0; i <
	 * orderBy.length; i++) { Order order = new Order((i<sort.length &&
	 * Sort.Direction.DESC.name().equalsIgnoreCase(sort[i]))?
	 * Sort.Direction.DESC:Sort.Direction.ASC,orderBy[i]); orders.add(order);
	 * 
	 * }
	 * 
	 * Sort sortQuery = Sort.by(orders);
	 * 
	 * List<Toponimo> toponimoes = toponimoDao.findAllWithFilter(new
	 * UsersEntity(user), stato, proCom, validazione, indirizzoOriginaleContains,
	 * sortQuery);
	 * 
	 * List<Toponimo> toponimoes = toponimoDao.findAllWithFilter(new
	 * UsersEntity(user), stato, proCom, validazione, indirizzoOriginaleContains,
	 * sortQuery); int offset = offsetInt != null ? offsetInt.intValue() : 0; if
	 * (toponimoes.size() == 0 || offset >= toponimoes.size()) throw new
	 * NoDataException("Toponimo no present"); return
	 * Translators.translate(toponimoes.get(offset));
	 * 
	 * }
	 */

	public Integer updateToponimoList(final UpdateToponimoListRequest updateToponimoListRequest, final Integer editor) {
		if ( updateToponimoListRequest.getToponimoList()==null||updateToponimoListRequest.getToponimoList().size() == 0)
			throw new NoDataException("Toponimo List empty");

		Integer countUpdate = 0;
		for (Iterator<Long> iterator = updateToponimoListRequest.getToponimoList().iterator(); iterator.hasNext();) {
			Long progressivoToponimo = (Long) iterator.next();

			final Optional<Toponimo> optToponimo = toponimoDao.findById(progressivoToponimo);
			if (!optToponimo.isPresent())
				throw new NoDataException("Toponimo no present");

			final Toponimo toponimo = optToponimo.get();
			if (updateToponimoListRequest.getValidazione() != null)
				toponimo.setValidazione(updateToponimoListRequest.getValidazione());
			if (updateToponimoListRequest.getDugVal() != null)
				toponimo.setDugVal(updateToponimoListRequest.getDugVal());
			if (updateToponimoListRequest.getDufVal() != null)
				toponimo.setDufVal(updateToponimoListRequest.getDufVal());
			if (updateToponimoListRequest.getLocalitaVal() != null)
				toponimo.setLocalitaVal(updateToponimoListRequest.getLocalitaVal());
			if (updateToponimoListRequest.getCdpstr() != null)
				toponimo.setCdpstrVal(updateToponimoListRequest.getCdpstr());
			/*
			 * if (updateToponimoListRequest.getIdFonte() != null)
			 * toponimo.setIdFonte(updateToponimoListRequest.getIdFonte());
			 */
			
			if (updateToponimoListRequest.getNote() != null)
				toponimo.setNote(updateToponimoListRequest.getNote());
			if (updateToponimoListRequest.getState() != null)
				toponimo.setStato(updateToponimoListRequest.getState());

			toponimo.setDataMod(new Timestamp(System.currentTimeMillis()));

			toponimoDao.save(toponimo);
			countUpdate++;
			if (editingBackup) {
				ToponimoBackupEdited toponimoBackupEdited = new ToponimoBackupEdited();
				toponimoBackupEdited = Translators.translate(toponimo, toponimoBackupEdited);
				toponimoBackupEdited.setEditor(editor);
				toponimoBackupDao.save(toponimoBackupEdited);
			}

		}
		return countUpdate;
	}
	
	
	
	

}

