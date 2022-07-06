package it.istat.mec.regedit.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.istat.mec.regedit.domain.ToponimiDaRevisionare;

@Repository
public interface ToponimiDaRevisionareDao extends JpaRepository<ToponimiDaRevisionare, Long> {
	@Override
	List<ToponimiDaRevisionare> findAll();

	@Override
	Optional<ToponimiDaRevisionare> findById(Long id);

	public void save(Optional<ToponimiDaRevisionare> toponimiDaRevisionare);

	public void delete(ToponimiDaRevisionare toponimiDaRevisionare);
}
