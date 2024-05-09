package it.istat.mec.regedit.dao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.istat.mec.regedit.domain.LogLinkageProb;

@Repository
public interface LogLinkageProbDao extends JpaRepository<LogLinkageProb, Integer> {
	@Override
	List<LogLinkageProb> findAll();
}
