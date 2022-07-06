package it.istat.mec.regedit.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.istat.mec.regedit.domain.NoLinkedAddress;


@Repository
public interface NoLinkedAddressDao extends JpaRepository<NoLinkedAddress, Long> {
	@Override
	List<NoLinkedAddress> findAll();

	@Override
	Optional<NoLinkedAddress> findById(Long id);

	public void save(Optional<NoLinkedAddress> noLinkedAddress);

	public void delete(NoLinkedAddress noLinkedAddress);
}
