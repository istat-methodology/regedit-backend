package it.istat.mec.users.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import it.istat.mec.users.dao.UserRolesDao;
import it.istat.mec.users.dao.UsersDao;
import it.istat.mec.users.domain.UserRolesEntity;
import it.istat.mec.users.domain.UsersEntity;
import it.istat.mec.users.dto.UsersDto;
import it.istat.mec.users.exceptions.NoDataException;
import it.istat.mec.users.repository.UserRespository;
import it.istat.mec.users.request.CreateUserRequest;
import it.istat.mec.users.translators.Translators;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

	private final UserRespository userRepository;
	@Autowired
	UsersDao usersDao;
	@Autowired
	UserRolesDao userRolesDao;

	public UserService(UserRespository userRepository) {
		this.userRepository = userRepository;
	}
	

	public List<UsersDto> findAllUsers(String role) {
		if (!StringUtils.isEmpty(role))
			return usersDao.findByRole(role).stream().map(x -> Translators.translate(x)).collect(Collectors.toList());
		else
			return usersDao.findAll().stream().map(x -> Translators.translate(x)).collect(Collectors.toList());
	}

	public UsersDto findUserById(Integer id) {

		if (!usersDao.findById(id).isPresent())
			throw new NoDataException("User not present");
		return Translators.translate(usersDao.findById(id).get());
	}

	public UsersDto deleteUser(Integer id) {
		UsersDto usersDto = findUserById(id);
		usersDao.deleteById(id);
		return usersDto;
	}
	public UsersDto newUser(CreateUserRequest request) {
		UsersEntity user = new UsersEntity();
		user = Translators.translate(request);	
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		
		usersDao.save(user);		    
		return Translators.translate(user);
	}
	public UsersDto updateUser(Integer id, CreateUserRequest request) {		
		
		if (!usersDao.findById(id).isPresent())
			throw new NoDataException("User not present");		
		UsersEntity user = usersDao.findById(id).get();
		
		if (!userRolesDao.findById(request.getRole()).isPresent())
			throw new NoDataException("Role not present");	
		UserRolesEntity userRole = userRolesDao.findById(request.getRole()).get();		
		
		
		user = Translators.translateUpdate(request, user);	
		user.setRole(userRole);
		
		
		
		if(request.getPassword()!=null) {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			user.setPassword(passwordEncoder.encode(request.getPassword()));       
		}
        
        usersDao.save(user); 	
		return Translators.translate(user);
	}
	public UsersDto updatePasswordByEmail(CreateUserRequest request) throws Exception {
        
		if (!usersDao.findByEmail(request.getEmail()).isPresent())
			throw new NoDataException("User not present");		
		
		UsersEntity user = usersDao.findByEmail(request.getEmail()).get();
		user = Translators.translateUpdate(request, user);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		user.setPassword(passwordEncoder.encode(request.getPassword()));		
        
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        usersDao.save(user);        
        
        return Translators.translate(user);
    }

    public UsersDto updatePasswordById(Integer id, CreateUserRequest request) throws Exception {
    	if (!usersDao.findById(id).isPresent())
			throw new NoDataException("User not present");		
		
		UsersEntity user = usersDao.findById(id).get();
		user = Translators.translateUpdate(request, user);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		user.setPassword(passwordEncoder.encode(request.getPassword()));		
        
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        usersDao.save(user);        
        
        return Translators.translate(user);
    }
	
}
