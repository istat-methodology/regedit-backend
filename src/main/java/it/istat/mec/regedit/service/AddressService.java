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

@Service
public class AddressService {
	@Autowired
    AddressDao addressDao;
	
	public List<Address>  findAllAddressess() {
        return addressDao.findAll();
    }
	public Address findAddressById(long id) {
        return addressDao.findById(id).orElse(null);
    }
	public Address updateAddress(Address address) {
   	 
    	return addressDao.save(address);
    }
	public Address deleteAddress(long id) {   
		Address address = findAddressById(id);
		addressDao.delete(address);    	
    	return address;
    }
	public Long newAdress(Long addressId, String param1, String param2, String param3) {
		final Address addrs = new Address();		
		addrs.setChiaveCivico(param1);
		addrs.setChiaveStrada(param2);
		addrs.setCivico(param3);
		// ... completare
	 
		return addressDao.save(addrs).getId();
	}
}
