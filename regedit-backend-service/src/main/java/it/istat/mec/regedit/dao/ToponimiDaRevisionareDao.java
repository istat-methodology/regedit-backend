package it.istat.mec.regedit.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.istat.mec.regedit.domain.ToponimiDaRevisionare;
import it.istat.mec.regedit.domain.UsersEntity;

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

	Optional<ToponimiDaRevisionare> findById(Integer id);

	public void save(Optional<ToponimiDaRevisionare> toponimiDaRevisionare);

	public void delete(ToponimiDaRevisionare toponimiDaRevisionare);
}
