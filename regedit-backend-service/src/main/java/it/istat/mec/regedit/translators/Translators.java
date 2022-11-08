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
import it.istat.mec.regedit.domain.AddressBackupEdited;
import it.istat.mec.regedit.domain.Dug;
import it.istat.mec.regedit.domain.Toponimo;
import it.istat.mec.regedit.domain.ToponimoBackupEdited;
import it.istat.mec.regedit.dto.AddressDto;
import it.istat.mec.regedit.dto.DugDto;
import it.istat.mec.regedit.dto.ToponimoDto;
import it.istat.mec.regedit.request.CreateAddressRequest;
import it.istat.mec.regedit.request.CreateDugRequest;
import it.istat.mec.regedit.request.CreateToponimoRequest;
import it.istat.mec.regedit.request.UpdateAddressRequest;

@Component
public class Translators {

	public static AddressDto translate(Address x) {

		final ModelMapper modelMapper = new ModelMapper();
		final AddressDto dTO = modelMapper.map(x, AddressDto.class);
		return dTO;
	}
	
	public static ToponimoDto translate(Toponimo x) {

		final ModelMapper modelMapper = new ModelMapper();
		final ToponimoDto dTO = modelMapper.map(x, ToponimoDto.class);
		return dTO;
	}
	
	public static List<ToponimoDto> translateToponimiDR(List<Toponimo> list) {
		return mapList(list, ToponimoDto.class);
	}

	public static List<AddressDto> translate(List<Address> list) {
		return mapList(list, AddressDto.class);
	}

	public static DugDto translate(Dug x) {

		final ModelMapper modelMapper = new ModelMapper();
		final DugDto dTO = modelMapper.map(x, DugDto.class);
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

	public static Dug translate(CreateDugRequest x) {

		final ModelMapper modelMapper = new ModelMapper();
		final Dug dug = modelMapper.map(x, Dug.class);
		return dug;
	}
	
	public static Toponimo translate(CreateToponimoRequest x) {

		final ModelMapper modelMapper = new ModelMapper();
		final Toponimo toponimo = modelMapper.map(x, Toponimo.class);
		return toponimo;
	}

	public static Address translateUpdate(UpdateAddressRequest x, Address address) {
		final ModelMapper modelMapper = new ModelMapper();
		modelMapper.map(x, address);

		return address;
	}

	public static AddressBackupEdited translate(Address address, AddressBackupEdited addressBackupEdited) {
	
		final ModelMapper modelMapper = new ModelMapper();
		modelMapper.map(address, addressBackupEdited);

		return addressBackupEdited;
	}
	
	public static ToponimoBackupEdited translate(Toponimo toponimo, ToponimoBackupEdited toponimoBackupEdited) {
		
		final ModelMapper modelMapper = new ModelMapper();
		modelMapper.map(toponimo, toponimoBackupEdited);

		return toponimoBackupEdited;
	}

	public static Dug translateUpdate(CreateDugRequest x, Dug dug) {
		final ModelMapper modelMapper = new ModelMapper();
		modelMapper.map(x, dug);
		return dug;
	}
	
	public static Toponimo translateUpdate(CreateToponimoRequest x, Toponimo toponimo) {
		final ModelMapper modelMapper = new ModelMapper();
		modelMapper.map(x, toponimo);
		return toponimo;
	}

	public static <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
		final ModelMapper modelMapper = new ModelMapper();
		return source.stream().map(element -> modelMapper.map(element, targetClass)).collect(Collectors.toList());
	}
}
