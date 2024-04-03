package it.istat.mec.regedit.dao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import it.istat.mec.regedit.domain.Provincia;


public interface ProvinciaDao extends JpaRepository<Provincia, Integer> {
	@Override
	List<Provincia> findAll();
}
