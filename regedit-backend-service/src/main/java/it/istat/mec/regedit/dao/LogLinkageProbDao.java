package it.istat.mec.regedit.dao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.istat.mec.regedit.domain.LogLinkageProb;

@Repository
public interface LogLinkageProbDao extends JpaRepository<LogLinkageProb, Integer> {
	@Override
	List<LogLinkageProb> findAll();
	
	@Query("SELECT log FROM LogLinkageProb AS log "
			+ " where 1=1 AND log.stato = :stato "
			+ " ORDER BY log.dataInizio DESC ")
	List<LogLinkageProb> findAllLogLinkageProbByStatoDesc(@Param("stato") Short stato);
}
