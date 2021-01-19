package it.istat.mec.users.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import it.istat.mec.users.dao.UsersDao;
import it.istat.mec.users.dto.UsersDto;
import it.istat.mec.users.exceptions.NoDataException;
import it.istat.mec.users.repository.UserRespository;
import it.istat.mec.users.translators.Translators;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

	private final UserRespository userRepository;
	@Autowired
	UsersDao usersDao;

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
		return usersDto;
	}
}
