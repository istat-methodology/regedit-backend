package it.istat.mec.regedit.dao;  
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import it.istat.mec.regedit.domain.IndirizzoProbab;


public interface IndirizzoProbabDao extends JpaRepository<IndirizzoProbab, Long> {

	@Override
	List<IndirizzoProbab> findAll();

	@Override
	Optional<IndirizzoProbab> findById(Long id);
	
	List<IndirizzoProbab> findByIdProcesso(Long id);
}
