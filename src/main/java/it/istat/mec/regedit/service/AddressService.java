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

import java.util.List;

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
	
	public List<Address>  findAllAddressess() {
        return addressDao.findAll();
    }	
	public Address updateAddress(Address address) {
   	 
    	return addressDao.save(address);
    }
	public AddressDto deleteAddress(long id) {   
		AddressDto addressDto = findAddressById(id);		
    	return addressDto;
    }
	public AddressDto newAdress(String codiceArchivioOr, String progressivoIndirizzoOr, 
			String comuneOr, String localitaOr, String indirizzoOriginale, String localitaSu, String dugSu, 
			String dufSu, String civicoSu, String esponenteSu, String validazione, String dug,
			String duf, String civico, String esponente, String localita, String chiaveStrada,
			String chiaveCivico, String fonte) {
		final Address addrs = new Address();		
		addrs.setCodiceArchivioOr(codiceArchivioOr);
		addrs.setProgressivoIndirizzoOr(progressivoIndirizzoOr);
		addrs.setComuneOr(comuneOr);
		addrs.setLocalitaOr(localitaOr);
		addrs.setIndirizzoOriginale(indirizzoOriginale);
		addrs.setLocalitaSu(localitaSu);
		addrs.setDugSu(dugSu);
		addrs.setDufSu(dufSu);
		addrs.setCivicoSu(civicoSu);
		addrs.setEsponenteSu(esponenteSu);
		addrs.setValidazione(validazione);
		addrs.setDug(dug);
		addrs.setDuf(duf);
		addrs.setCivico(civico);
		addrs.setEsponente(esponente);
		addrs.setLocalita(localita);
		addrs.setChiaveStrada(chiaveStrada);
		addrs.setChiaveCivico(chiaveCivico);
		addrs.setFonte(fonte);
		
		return findAddressById(addressDao.save(addrs).getId());	
	}
	public AddressDto findAddressById(long id) {

		if (!addressDao.findById(id).isPresent())
			throw new NoDataException("Business Function no present");
		return Translators.translate(addressDao.findById(id).get());
	}
}
