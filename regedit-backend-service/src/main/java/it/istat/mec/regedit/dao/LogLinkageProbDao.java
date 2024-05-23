package it.istat.mec.regedit.dao;
import java.lang.annotation.Native;
import java.util.List;

import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.istat.mec.regedit.domain.LogLinkageProb;

@Repository
public interface LogLinkageProbDao extends JpaRepository<LogLinkageProb, Integer> {
	@Override
	List<LogLinkageProb> findAll();
	
	/*
	 * @Query("SELECT log FROM LogLinkageProb AS log " +
	 * " where 1=1 AND log.stato = :stato " + " ORDER BY log.dataInizio DESC ")
	 */
	@Query( value = "SELECT * FROM (SELECT * FROM LOG_LINKAGE_PROBABILISTICO ORDER BY DATA_INIZIO DESC) WHERE ROWNUM = 1", nativeQuery = true)
	LogLinkageProb findLogLinkageProbLastProc();
}
