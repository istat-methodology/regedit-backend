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

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.istat.mec.regedit.dao.AddressDao;
import it.istat.mec.regedit.domain.Address;
import it.istat.mec.regedit.dto.AddressDto;
import it.istat.mec.regedit.exceptions.NoDataException;
import it.istat.mec.regedit.translators.Translators;

@Service
public class AddressService {
	@Autowired
	AddressDao addressDao;

	public List<AddressDto> findAllAddressess(Integer revisore, Short stato) {
		if (revisore == null && stato == null)
			return addressDao.findAll().stream().map(x -> Translators.translate(x)).collect(Collectors.toList());
		else if (stato == null)
			return addressDao.findByIdRevisoreOrderByProComAsc(revisore).stream().map(x -> Translators.translate(x))
					.collect(Collectors.toList());
		if (revisore == null && stato != null)
			return addressDao.findByStatoOrderByProComAsc(stato).stream().map(x -> Translators.translate(x))
					.collect(Collectors.toList());
		else
			return addressDao.findByIdRevisoreAndStatoOrderByProComAsc(revisore, stato).stream()
					.map(x -> Translators.translate(x)).collect(Collectors.toList());

	}

	public Address updateAddress(Address address) {

		return addressDao.save(address);
	}

	public AddressDto deleteAddress(Integer id) {
		AddressDto addressDto = findAddressById(id);
		return addressDto;
	}

	public AddressDto newAdress(Integer progressivoIndirizzo, Integer codiceArchivio, String proCom,
			String denominazioneComune, String localitaOriginale, String indirizzoOriginale, String localitaNorm,
			String dugNorm, String dufNorm, Integer civicoNorm, String kmNorm, String esponenteNorm, String validazione,
			String dugVal, String dufVal, Integer civicoVal, String kmVal, String esponenteVal, String localitaVal,
			Integer cdpstrEgon, Integer cdpcivEgon, Integer idFonte, Integer stratoIndirizzo, Integer idRevisore,
			Short stato, Date dataIns, Date dataMod, String nomeFile) {
		final Address addrs = new Address();
		addrs.setProgressivoIndirizzo(progressivoIndirizzo);
		addrs.setCodiceArchivio(codiceArchivio);
		addrs.setProCom(proCom);
		addrs.setDenominazioneComune(denominazioneComune);
		addrs.setLocalitaOriginale(localitaOriginale);
		addrs.setIndirizzoOriginale(indirizzoOriginale);
		addrs.setLocalitaOriginale(localitaOriginale);
		addrs.setDugNorm(dugNorm);
		addrs.setDufNorm(dufNorm);
		addrs.setCivicoNorm(civicoNorm);
		addrs.setKmNorm(kmNorm);
		addrs.setEsponenteNorm(esponenteNorm);
		addrs.setValidazione(validazione);
		addrs.setDugVal(dugVal);
		addrs.setDufVal(dufVal);
		addrs.setCivicoVal(civicoVal);
		addrs.setKmVal(kmVal);
		addrs.setEsponenteVal(esponenteVal);
		addrs.setLocalitaVal(localitaVal);
		addrs.setCdpstrEgon(cdpstrEgon);
		addrs.setCdpcivEgon(cdpcivEgon);
		addrs.setIdFonte(idFonte);
		addrs.setStratoIndirizzo(stratoIndirizzo);
		addrs.setIdRevisore(idRevisore);
		addrs.setStato(stato);
		addrs.setDataIns(dataIns);
		addrs.setDataMod(dataMod);
		addrs.setNomeFile(nomeFile);
		return findAddressById(addressDao.save(addrs).getProgressivoIndirizzo());
	}

	public AddressDto findAddressById(Integer id) {

		if (!addressDao.findById(id).isPresent())
			throw new NoDataException("Address no present");
		return Translators.translate(addressDao.findById(id).get());
	}

	public List<AddressDto> getAddressesByUser(Integer user, Short stato) {
		List<AddressDto> addresses = addressDao.findByIdRevisoreAndStatoOrderByProComAsc(user, stato).stream()
				.map(x -> Translators.translate(x)).collect(Collectors.toList());

		return addresses;

	}

	public AddressDto getFirstAddressByUser(Integer user, Short stato) {
		List<Address> addresses = addressDao.findByIdRevisoreAndStatoOrderByProComAsc(user, stato);
		if (addresses.size() == 0)
			throw new NoDataException("Address no present");
		return Translators.translate(addresses.get(0));

	}
}
