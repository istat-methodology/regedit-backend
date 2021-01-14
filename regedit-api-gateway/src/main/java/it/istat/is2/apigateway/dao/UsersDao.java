package it.istat.is2.apigateway.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.istat.is2.apigateway.domain.UsersEntity; 

@Repository
public interface UsersDao extends CrudRepository<UsersEntity, Integer> {

	@Override
	List<UsersEntity> findAll();
	
	@Override
	Optional<UsersEntity> findById(Integer id);
	
	public void save(Optional<UsersEntity> address);

	public void delete(UsersEntity address);
}
