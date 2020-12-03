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
package it.istat.mec.regedit.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.istat.mec.regedit.domain.Address;
import it.istat.mec.regedit.dto.AddressDto;
import it.istat.mec.regedit.dto.ReportDto;


@Repository
public interface AddressDao extends CrudRepository<Address, Integer> {

	@Override
    List<Address> findAll();
	
	@Override
	Optional<Address> findById(Integer idfunction);
	
	public void save(Optional<Address> address); 
	
	public void delete(Address address);
	
	@Query("SELECT new it.istat.mec.regedit.dto.ReportDto(adr.idRevisore,adr.stato, COUNT(adr.stato)) "
			  + "FROM Address AS adr WHERE adr.stato is not null and adr.idRevisore=:user GROUP BY adr.idRevisore,adr.stato ORDER BY adr.stato")
	List<ReportDto> getAddressStateByUser(@Param("user") Integer user);
	
	@Query("SELECT new it.istat.mec.regedit.dto.ReportDto(adr.idRevisore,adr.stato, COUNT(adr.stato)) "
			  + "FROM Address AS adr WHERE adr.stato is not null and adr.idRevisore=:user and adr.stato=:state GROUP BY adr.idRevisore,adr.stato ORDER BY adr.stato")
	Optional<ReportDto> getAddressStateByUserAndState(Integer user, Short state);


	 /*	@Query("SELECT adr.progressivoIndirizzo, adr.codiceArchivio, adr.proCom, adr.denominazioneComune, "
			+ "adr.localitaOriginale, adr.indirizzoOriginale, adr.localitaNorm, adr.dugNorm, adr.dufNorm, "
			+ "adr.civicoNorm, adr.kmNorm, adr.esponenteNorm, adr.validazione, adr.dugVal, adr.dufVal, "
			+ "adr.civicoVal, adr.kmVal, adr.esponenteVal, adr.localitaVal, adr.cdpstrEgon, adr.cdpcivEgon, "
			+ "adr.idFonte, adr.stratoIndirizzo, adr.idRevisore, adr.stato, adr.dataIns, adr.dataMod, "
			+ "adr.nomeFile "
			  + "FROM Address as adr WHERE adr.stato is not null and adr.idRevisore=:user ORDER BY adr.proCom")
	List<AddressDto> getAddressesByUser(@Param("user") Integer user);*/
	@Query("SELECT adr  "
	  + "FROM Address as adr WHERE adr.stato=:state and adr.idRevisore=:user ORDER BY adr.proCom")
	List<Address> getAddressesByUser(@Param("user") Integer user, @Param("state") Short stato);
	
	
}
