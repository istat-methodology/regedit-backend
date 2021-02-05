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
package it.istat.mec.regedit.service;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import it.istat.mec.regedit.dao.AddressBackupDao;
import it.istat.mec.regedit.dao.AddressDao;
import it.istat.mec.regedit.domain.Address;
import it.istat.mec.regedit.domain.AddressBackupEdited;
import it.istat.mec.regedit.domain.UsersEntity;
import it.istat.mec.regedit.dto.AddressDto;
import it.istat.mec.regedit.dto.ComuneDto;
import it.istat.mec.regedit.exceptions.NoDataException;
import it.istat.mec.regedit.request.CreateAddressRequest;
import it.istat.mec.regedit.request.UpdateAddressRequest;
import it.istat.mec.regedit.translators.Translators;

@Service
public class AddressService {

	@Value("${app.editing.backup:false}")
	private Boolean editingBackup;

	@Autowired
	AddressDao addressDao;

	@Autowired
	AddressBackupDao addressBackupDao;

	public List<AddressDto> findAllAddressess(Integer revisore, Short stato, String proCom,
			String indirizzoOriginaleStartWith) {

		return Translators.translate(
				addressDao.findAllWithFilter(new UsersEntity(revisore), stato, proCom, indirizzoOriginaleStartWith));

	}
	
	public List<ComuneDto> findAllComuniByStatoAndRevisore(Integer revisore, Short stato) {

		return addressDao.findAllComuniByIdRevisoreAndStatoOrderByDenominazioneComuneAsc(new UsersEntity(revisore), stato);

	}

	public AddressDto updateAddress(UpdateAddressRequest request, Integer editor) {

		if (!addressDao.findById(request.getProgressivoIndirizzo()).isPresent())
			throw new NoDataException("Address no present");

		Address address = addressDao.findById(request.getProgressivoIndirizzo()).get();
		address = Translators.translateUpdate(request, address);

		address.setDataMod(new Timestamp(System.currentTimeMillis()));

		addressDao.save(address);

		if (editingBackup) {
			AddressBackupEdited addressBackupEdited = new AddressBackupEdited();
			addressBackupEdited = Translators.translate(address, addressBackupEdited);
			addressBackupEdited.setEditor(editor);
			addressBackupDao.save(addressBackupEdited);
		}
		return Translators.translate(address);
	}

	public AddressDto deleteAddress(Integer id) {
		AddressDto addressDto = findAddressById(id);
		return addressDto;
	}

	public AddressDto newAdress(CreateAddressRequest request) {
		Address address = new Address();
		address = Translators.translate(request);
		address.setDataMod(new Timestamp(System.currentTimeMillis()));
		addressDao.save(address);
		return Translators.translate(address);
	}

	public AddressDto findAddressById(Integer id) {

		if (!addressDao.findById(id).isPresent())
			throw new NoDataException("Address no present");
		return Translators.translate(addressDao.findById(id).get());
	}

	public List<AddressDto> getAddressesByUser(Integer user, Short stato) {
		List<AddressDto> addresses = addressDao.findByIdRevisoreAndStatoOrderByProComAsc(new UsersEntity(user), stato)
				.stream().map(x -> Translators.translate(x)).collect(Collectors.toList());

		return addresses;

	}

	public AddressDto getFirstAddressByUser(Integer user, Short stato, String proCom,
			String indirizzoOriginaleStartWith) {
		List<Address> addresses = addressDao.findAllWithFilter(new UsersEntity(user), stato, proCom,
				indirizzoOriginaleStartWith);
		if (addresses.size() == 0)
			throw new NoDataException("Address no present");
		return Translators.translate(addresses.get(0));

	}

	public Integer updateAddressList(final List<Integer> addressList, final String dugVal, final String dufVal,
			final Short stato, final String note, final Integer editor) {
		if (addressList.size() == 0)
			throw new NoDataException("Address List empty");

		Integer countUpdate = 0;
		for (Iterator<Integer> iterator = addressList.iterator(); iterator.hasNext();) {
			Integer progressivoIndirizzo = (Integer) iterator.next();

			final Optional<Address> optAddress = addressDao.findById(progressivoIndirizzo);
			if (!optAddress.isPresent())
				throw new NoDataException("Address no present");

			final Address address = optAddress.get();
			if (dugVal != null)
				address.setDugVal(dugVal);
			if (dufVal != null)
				address.setDufVal(dufVal);
			if (note != null)
				address.setNote(note);
			if (stato != null)
				address.setStato(stato);

			address.setDataMod(new Timestamp(System.currentTimeMillis()));

			addressDao.save(address);
			countUpdate++;
			if (editingBackup) {
				AddressBackupEdited addressBackupEdited = new AddressBackupEdited();
				addressBackupEdited = Translators.translate(address, addressBackupEdited);
				addressBackupEdited.setEditor(editor);
				addressBackupDao.save(addressBackupEdited);
			}

		}
		return countUpdate;
	}
}
