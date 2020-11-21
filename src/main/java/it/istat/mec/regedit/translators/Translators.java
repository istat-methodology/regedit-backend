package it.istat.mec.regedit.translators;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import it.istat.mec.regedit.domain.Address;
import it.istat.mec.regedit.dto.AddressDto;


@Component
public class Translators {
	

	public static AddressDto translate(Address x) {

		final ModelMapper modelMapper = new ModelMapper();
		final AddressDto dTO = modelMapper.map(x, AddressDto.class);
		return dTO;
	}
	
	public static <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
		final ModelMapper modelMapper = new ModelMapper();
	    return source
	      .stream()
	      .map(element -> modelMapper.map(element, targetClass))
	      .collect(Collectors.toList());
	}
}
