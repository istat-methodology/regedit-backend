package it.istat.mec.regedit.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import it.istat.mec.regedit.domain.ToponimiDaRevisionare;
import it.istat.mec.regedit.domain.UsersEntity;
import it.istat.mec.regedit.dto.ComuneDto;
import it.istat.mec.regedit.dto.UsersDto;

@Repository
public interface ToponimiDaRevisionareDao extends JpaRepository<ToponimiDaRevisionare, Integer> {
	@Override
	List<ToponimiDaRevisionare> findAll();
	
	@Query("SELECT tp FROM ToponimiDaRevisionare AS tp "
			+ " where 1=1 AND ((:idRevisore is NULL) OR (tp.idRevisore = :idRevisore)) "
			+ " AND ((:stato is NULL) OR (tp.stato = :stato)) "
			+ " ORDER BY tp.denominazioneComune ASC, tp.proCom ASC ")
	List<ToponimiDaRevisionare> findAllToponimiDRByIdRevisoreAndStatoOrderByDenominazioneComuneAsc(
			@Param("idRevisore") UsersEntity idRevisore, @Param("stato") Short stato);
	
	@Query("SELECT tp FROM ToponimiDaRevisionare AS tp "
			+ " where 1=1 AND ((:idRevisore is NULL) OR (tp.idRevisore = :idRevisore)) "
			+ " AND ((:stato is NULL) OR (tp.stato = :stato)) "
			+ " AND ((:proCom is NULL) OR (tp.proCom = :proCom)) "
			+ " AND ((:validazione is NULL) OR (tp.validazione = :validazione)) ")				
		List<ToponimiDaRevisionare> findAllWithFilter(@Param("idRevisore") UsersEntity idRevisore, @Param("stato") Short stato, @Param("proCom") String proCom, @Param("validazione") String validazione, Sort sort);

	@Query("SELECT distinct new it.istat.mec.regedit.dto.ComuneDto (tp.denominazioneComune,tp.proCom) FROM ToponimiDaRevisionare AS tp "
			+ " where 1=1 AND ((:idRevisore is NULL) OR (tp.idRevisore = :idRevisore)) "
			+ " AND ((:stato is NULL) OR (tp.stato = :stato)) "
			+ " ORDER BY tp.denominazioneComune ASC, tp.proCom ASC ")
	List<ComuneDto> findAllComuniByIdRevisoreAndStatoOrderByDenominazioneComuneAsc(
			@Param("idRevisore") UsersEntity idRevisore, @Param("stato") Short statoCom);
	
	Optional<ToponimiDaRevisionare> findById(Integer id);
	
	@Query("SELECT distinct new it.istat.mec.regedit.dto.UsersDto(adr.idRevisore.id, adr.idRevisore.email, adr.idRevisore.name, adr.idRevisore.surname, adr.idRevisore.role.id) FROM ToponimiDaRevisionare AS tp "			
			+ " where tp.stato is not NULL "
			+ " ORDER BY tp.idRevisore.name ASC ")
	List<UsersDto> findAllUsersWithToponimiAssigned();

	public void save(Optional<ToponimiDaRevisionare> toponimiDaRevisionare);

	public void delete(ToponimiDaRevisionare toponimiDaRevisionare);
}
