package it.istat.mec.regedit.dao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.istat.mec.regedit.domain.Provincia;

@Repository
public interface ProvinciaDao extends JpaRepository<Provincia, Integer> {
	@Override
	List<Provincia> findAll();
}
