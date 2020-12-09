/**
 * Copyright 2020 ISTAT
 *
 * Licensed under the EUPL, Version 1.1 or – as soon they will be approved by
 * the European Commission - subsequent versions of the EUPL (the "Licence");
 * You may not use this work except in compliance with the Licence. You may
 * obtain a copy of the Licence at:
 *
 * http://ec.europa.eu/idabc/eupl5
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the Licence is distributed on an "AS IS" basis, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * Licence for the specific language governing permissions and limitations under
 * the Licence.
 *
 * @author Francesco Amato <framato @ istat.it>
 * @author Mauro Bruno <mbruno @ istat.it>
 * @author Renzo Iannacone <iannacone @ istat.it>
 * @author Stefano Macone <macone @ istat.it>
 * @version 1.0
 */
package it.istat.mec.regedit.translators;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import it.istat.mec.regedit.domain.Address;
import it.istat.mec.regedit.dto.AddressDto;
import it.istat.mec.regedit.request.CreateAddressRequest;
import it.istat.mec.regedit.request.UpdateAddressRequest;


@Component
public class Translators { 
	

	public static AddressDto translate(Address x) {

		final ModelMapper modelMapper = new ModelMapper();
		final AddressDto dTO = modelMapper.map(x, AddressDto.class);
		return dTO;
	}
	public static AddressDto translate(Optional<Address> address) {

		final ModelMapper modelMapper = new ModelMapper();
		final AddressDto dTO = modelMapper.map(address, AddressDto.class);
		return dTO;
	}
	public static Address translate(CreateAddressRequest x) {

		final ModelMapper modelMapper = new ModelMapper();
		final Address adr = modelMapper.map(x, Address.class);
		return adr;
	}
	
	public static Optional <Address> translateUpdate(UpdateAddressRequest x, Optional<Address> address) {  
		final ModelMapper modelMapper = new ModelMapper();
		modelMapper.map(x,address);
		return address;
	}
	
	public static <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
		final ModelMapper modelMapper = new ModelMapper();
	    return source
	      .stream()
	      .map(element -> modelMapper.map(element, targetClass))
	      .collect(Collectors.toList());
	}
}
