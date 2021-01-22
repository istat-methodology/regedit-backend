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
import it.istat.mec.regedit.dto.ReportDto;
import it.istat.mec.regedit.dto.ReportPivotDto;

@Repository
public interface AddressDao extends CrudRepository<Address, Integer> {

	@Override
	List<Address> findAll();

	@Override
	Optional<Address> findById(Integer id);

	public void save(Optional<Address> address);

	public void delete(Address address);
 
	List<Address> findByIdRevisoreOrderByProComAsc(@Param("idRevisore") Integer idRevisore);
	
	List<Address> findByStatoOrderByProComAsc(@Param("stato") Short stato);
	
	List<Address> findByIdRevisoreAndStatoOrderByProComAsc(@Param("idRevisore") Integer idRevisore, @Param("stato") Short stato);
	
	
	@Query("SELECT new it.istat.mec.regedit.dto.ReportDto(adr.idRevisore,adr.stato ,adr.validazione, COUNT(*)) "
			+ "FROM Address AS adr  GROUP BY adr.idRevisore,adr.stato,adr.validazione ORDER BY adr.stato")
	List<ReportDto> getReportAddressState();


	@Query("SELECT new it.istat.mec.regedit.dto.ReportDto(adr.idRevisore,adr.stato,adr.validazione,  COUNT(*)) "
			+ "FROM Address AS adr WHERE  adr.idRevisore=:user GROUP BY adr.idRevisore,adr.stato, adr.validazione  ORDER BY adr.stato")
	List<ReportDto> getReportAddressStateByUser(@Param("user") Integer user);

	@Query("SELECT new it.istat.mec.regedit.dto.ReportDto(adr.idRevisore,adr.stato,adr.validazione, COUNT(*)) "
			+ "FROM Address AS adr WHERE adr.idRevisore=:user and adr.stato=:state GROUP BY adr.idRevisore,adr.stato,adr.validazione ORDER BY adr.stato")
	Optional<ReportDto> getReportAddressStateByUserAndState(Integer user, Short state);
	
	

	@Query("SELECT new it.istat.mec.regedit.dto.ReportDto(adr.idRevisore,adr.stato ,adr.validazione, cast(adr.dataMod as date) , COUNT(*)) "
			+ "FROM Address AS adr  GROUP BY adr.idRevisore,adr.stato,adr.validazione, cast(adr.dataMod as date)  ORDER BY adr.stato")
	List<ReportDto> getReportDailyAddressState();

	@Query("SELECT new it.istat.mec.regedit.dto.ReportDto(adr.idRevisore,adr.stato,adr.validazione, cast(adr.dataMod as date) , COUNT(*)) "
			+ "FROM Address AS adr WHERE  adr.idRevisore=:user GROUP BY adr.idRevisore,adr.stato, adr.validazione, cast(adr.dataMod as date)   ORDER BY adr.stato")
	List<ReportDto> getReportDailyAddressStateByUser(@Param("user") Integer user);

	@Query("SELECT new it.istat.mec.regedit.dto.ReportDto(adr.idRevisore,adr.stato,adr.validazione,cast(adr.dataMod as date) , COUNT(*)) "
			+ "FROM Address AS adr WHERE adr.idRevisore=:user and adr.stato=:state GROUP BY adr.idRevisore,adr.stato,adr.validazione, cast(adr.dataMod as date) ORDER BY adr.stato")
	List<ReportDto> getReportDailyAddressStateByUserAndState(Integer user, Short state);
	
	@Query("SELECT new it.istat.mec.regedit.dto.ReportPivotDto(adr.idRevisore,SUM(CASE WHEN  adr.stato =  1 THEN 1 ELSE 0 END)   ,"
			+ " SUM(CASE WHEN (adr.stato =  2 and adr.validazione='SI') THEN 1 ELSE 0 END)  , "
			+ " SUM(CASE WHEN (adr.stato =  2 and adr.validazione='NO') THEN 1 ELSE 0 END)  , "
			+ " SUM(CASE WHEN adr.stato =  3 THEN 1 ELSE 0 END)  ) "
			+ " FROM Address AS adr  GROUP BY adr.idRevisore ")
	List<ReportPivotDto> getReportPivotAddressState();
	
	@Query("SELECT new it.istat.mec.regedit.dto.ReportPivotDto(adr.idRevisore,SUM(CASE WHEN  adr.stato =  1 THEN 1 ELSE 0 END)   ,"
			+ " SUM(CASE WHEN (adr.stato =  2 and adr.validazione='SI') THEN 1 ELSE 0 END)  , "
			+ " SUM(CASE WHEN (adr.stato =  2 and adr.validazione='NO') THEN 1 ELSE 0 END)  , "
			+ " SUM(CASE WHEN adr.stato =  3 THEN 1 ELSE 0 END)  ) "
			+ " FROM Address AS adr WHERE adr.idRevisore=:user  GROUP BY adr.idRevisore ")
	List<ReportPivotDto> getReportPivotAddressStateUser(@Param("user") Integer user);

}
