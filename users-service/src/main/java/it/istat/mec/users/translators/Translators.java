package it.istat.mec.users.translators;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import it.istat.mec.users.domain.UsersEntity;
import it.istat.mec.users.dto.UsersDto;
import it.istat.mec.users.request.CreateUserRequest;

 

@Component
public class Translators {
	
	public static UsersDto translate(UsersEntity x) {

		final ModelMapper modelMapper = new ModelMapper();
		final UsersDto dTO = modelMapper.map(x, UsersDto.class);
		return dTO;
	}

	public static <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
		final ModelMapper modelMapper = new ModelMapper();
	    return source
	      .stream()
	      .map(element -> modelMapper.map(element, targetClass))
	      .collect(Collectors.toList());
	}
	public static UsersEntity translate(CreateUserRequest x) {

		final ModelMapper modelMapper = new ModelMapper();
		final UsersEntity user = modelMapper.map(x, UsersEntity.class);
		return user;
	}
	public static UsersEntity translateUpdate(CreateUserRequest x, UsersEntity user) {  
		final ModelMapper modelMapper = new ModelMapper();
		modelMapper.map(x,user);
		 
		return user;
	}
}
