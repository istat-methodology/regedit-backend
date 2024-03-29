package it.istat.mec.regedit.dao;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import it.istat.mec.regedit.domain.Toponimo;
import it.istat.mec.regedit.domain.UsersEntity;
import it.istat.mec.regedit.dto.ComuneDto;
import it.istat.mec.regedit.dto.ExportToponimiDto;
import it.istat.mec.regedit.dto.ProvinciaDto;
import it.istat.mec.regedit.dto.ReportDto;
import it.istat.mec.regedit.dto.ReportPivotDto;
import it.istat.mec.regedit.dto.UsersDto;

@Repository
public interface ToponimoDao extends JpaRepository<Toponimo, Long> {
	
	
	//@Procedure("export_toponimi")
	//List<ExportToponimiDto> callExportToponimi();
	
	/*
	 * @Override List<Toponimo> findAll();
	 */
	 @Query("SELECT tp FROM Toponimo AS tp " +
	 " where 1=1 AND ((:idRevisore is NULL) OR (tp.idRevisore = :idRevisore)) " +
	 " AND ((:stato is NULL) OR (tp.stato = :stato)) " +
	 " ORDER BY tp.denominazioneComune ASC, tp.proCom ASC ")
	 List<Toponimo>
	 findAllToponimiDRByIdRevisoreAndStatoOrderByDenominazioneComuneAsc(
	 
	 @Param("idRevisore") UsersEntity idRevisore, @Param("stato") Short stato);
	 /* 
	 * @Query("SELECT tp FROM Toponimo AS tp " +
	 * " where 1=1 AND ((:idRevisore is NULL) OR (tp.idRevisore = :idRevisore)) " +
	 * " AND ((:stato is NULL) OR (tp.stato = :stato)) " +
	 * " AND ((:proCom is NULL) OR (tp.proCom = :proCom)) " +
	 * " AND ((:validazione is NULL) OR (tp.validazione = :validazione)) ")
	 * List<Toponimo> findAllWithFilter(@Param("idRevisore")
	 * UsersEntity idRevisore, @Param("stato") Short stato, @Param("proCom") String
	 * proCom, @Param("validazione") String validazione, Sort sort);
	 * 
	 * @Query("SELECT distinct new it.istat.mec.regedit.dto.ComuneDto (tp.denominazioneComune,tp.proCom) FROM Toponimo AS tp "
	 * + " where 1=1 AND ((:idRevisore is NULL) OR (tp.idRevisore = :idRevisore)) "
	 * + " AND ((:stato is NULL) OR (tp.stato = :stato)) " +
	 * " ORDER BY tp.denominazioneComune ASC, tp.proCom ASC ") List<ComuneDto>
	 * findAllComuniByIdRevisoreAndStatoOrderByDenominazioneComuneAsc(
	 * 
	 * @Param("idRevisore") UsersEntity idRevisore, @Param("stato") Short statoCom);
	 * 
	 * Optional<Toponimo> findById(Integer id);
	 * 
	 * @Query("SELECT distinct new it.istat.mec.regedit.dto.UsersDto(tp.idRevisore.id, tp.idRevisore.email, tp.idRevisore.name, tp.idRevisore.surname, tp.idRevisore.role.id) FROM Toponimo AS tp "
	 * + " where tp.stato is not NULL " + " ORDER BY tp.idRevisore.name ASC ")
	 * List<UsersDto> findAllUsersWithToponimiAssigned();
	 * 
	 * public void save(ToponimoBackupEdited toponimoBackupEdited);
	 * 
	 * public void delete(Toponimo toponimo);
	 */
	@Override
	List<Toponimo> findAll();
	@Override
	Optional<Toponimo> findById(Long id);

	public void save(Optional<Toponimo> toponimo);
	public void delete(Toponimo toponimo);

	List<Toponimo> findByIdRevisoreOrderByProComAsc(@Param("idRevisore") UsersEntity idRevisore);

	List<Toponimo> findByStatoOrderByProComAsc(@Param("stato") Short stato);

	List<Toponimo> findByIdRevisoreAndStatoOrderByProComAsc(@Param("idRevisore") UsersEntity idRevisore,
			@Param("stato") Short stato);

	
	  
	  @Query("SELECT toponimo FROM Toponimo AS toponimo "
				+ " where 1=1 AND ((:idRevisore is NULL) OR (toponimo.idRevisore = :idRevisore)) "
				+ " AND ((:stato is NULL) OR (toponimo.stato = :stato)) "
				+ " AND ((:proCom is NULL) OR (toponimo.proCom = :proCom)) "
				+ " AND ((:validazione is NULL) OR (toponimo.validazione = :validazione)) " 
				+ " AND ((:provincia is NULL) OR (UPPER(toponimo.denominazioneProvincia) like (UPPER(:provincia)) ))"
				+ " AND ((:soglia is NULL) OR (toponimo.sogliaW >= :soglia)) "
				+ " AND ((:toponimoOrig is NULL) OR (UPPER(toponimo.toponimoOrig) like CONCAT('%',UPPER(:toponimoOrig),'%') )) ORDER BY toponimo.sogliaW DESC")

List<Toponimo> findAllWithFilter(@Param("idRevisore") UsersEntity
	  idRevisore, @Param("stato") Short stato, @Param("proCom") String proCom, @Param("validazione") String validazione, 
	  @Param("provincia") String provincia, @Param("soglia") Double soglia,
	  @Param("toponimoOrig") String toponimoOrig,  Sort sort);
	 
	 
	  
	  
/*
 * @Query("SELECT adr FROM Address AS adr " +
 * " where 1=1 AND ((:idRevisore is NULL) OR (adr.idRevisore = :idRevisore)) " +
 * " AND ((:stato is NULL) OR (adr.stato = :stato)) " +
 * " AND ((:proCom is NULL) OR (adr.proCom = :proCom)) " +
 * " AND ((:validazione is NULL) OR (adr.validazione = :validazione)) " +
 * " AND ((:indirizzoOriginale is NULL) OR (UPPER(adr.indirizzoOriginale) like CONCAT('%',UPPER(:indirizzoOriginale),'%') )) "
 * ) List<Address> findAllWithFilter(@Param("idRevisore") UsersEntity
 * idRevisore, @Param("stato") Short stato, @Param("proCom") String
 * proCom, @Param("validazione") String
 * validazione, @Param("indirizzoOriginale") String indirizzoOriginale, Sort
 * sort);
 */
	  
	  
	  @Query("SELECT distinct new it.istat.mec.regedit.dto.ComuneDto (adr.denominazioneComune,adr.proCom) FROM Toponimo AS adr "
				+ " where 1=1 AND ((:idRevisore is NULL) OR (adr.idRevisore = :idRevisore)) "
				+ " AND ((:stato is NULL) OR (adr.stato = :stato)) "
				+ " ORDER BY adr.denominazioneComune ASC, adr.proCom ASC ")
		List<ComuneDto> findAllComuniByIdRevisoreAndStatoOrderByDenominazioneComuneAsc(
				@Param("idRevisore") UsersEntity idRevisore, @Param("stato") Short statoCom);
	  
	@Query("SELECT distinct new it.istat.mec.regedit.dto.ComuneDto (adr.denominazioneComune,adr.proCom) FROM Toponimo AS adr "
			+ " where 1=1 AND ((:idRevisore is NULL) OR (adr.idRevisore = :idRevisore)) "
			+ " AND ((:stato is NULL) OR (adr.stato = :stato)) "
			+ " AND (UPPER(adr.denominazioneProvincia) = UPPER(:provincia)) "
			+ " ORDER BY adr.denominazioneComune ASC, adr.proCom ASC ")
	List<ComuneDto> findAllComuniByIdRevisoreStatoAndProvinciaOrderByDenominazioneComuneAsc(
			@Param("idRevisore") UsersEntity idRevisore, @Param("stato") Short statoCom, @Param("provincia") String provincia);
	
	@Query("SELECT distinct new it.istat.mec.regedit.dto.ProvinciaDto (adr.denominazioneProvincia) FROM Toponimo AS adr "
			+ " where 1=1 AND ((:idRevisore is NULL) OR (adr.idRevisore = :idRevisore)) "
			+ " AND ((:stato is NULL) OR (adr.stato = :stato)) "
			+ " ORDER BY adr.denominazioneProvincia ASC")
	List<ProvinciaDto> findAllProvinceByIdRevisoreAndStatoOrderByDenominazioneProvinciaAsc(
			@Param("idRevisore") UsersEntity idRevisore, @Param("stato") Short statoCom);

	@Query("SELECT new it.istat.mec.regedit.dto.ReportDto(adr.idRevisore.email,adr.stato ,adr.validazione, COUNT(*)) "
			+ "FROM Toponimo AS adr  GROUP BY adr.idRevisore.email,adr.stato,adr.validazione ORDER BY adr.stato")
	List<ReportDto> getReportToponimoState();
//questa
	@Query("SELECT new it.istat.mec.regedit.dto.ReportDto(adr.idRevisore.email,adr.stato,adr.validazione,  COUNT(*)) "
			+ "FROM Toponimo AS adr WHERE  adr.idRevisore.id=:user GROUP BY adr.idRevisore.email,adr.stato, adr.validazione  ORDER BY adr.stato")
	List<ReportDto> getReportToponimoStateByUser(@Param("user") Integer user);

	@Query("SELECT new it.istat.mec.regedit.dto.ReportDto(adr.idRevisore.email,adr.stato,adr.validazione, COUNT(*)) "
			+ "FROM Toponimo AS adr WHERE adr.idRevisore.id=:user and adr.stato=:state GROUP BY adr.idRevisore.email,adr.stato,adr.validazione ORDER BY adr.stato")
	Optional<ReportDto> getReportToponimoStateByUserAndState(Integer user, Short state);

	@Query("SELECT new it.istat.mec.regedit.dto.ReportDto(adr.idRevisore.email,adr.stato ,adr.validazione, cast(adr.dataMod as date) , COUNT(*)) "
			+ "FROM Toponimo AS adr  GROUP BY adr.idRevisore.email,adr.stato,adr.validazione, cast(adr.dataMod as date)  ORDER BY adr.stato")
	List<ReportDto> getReportDailyToponimoState();

	@Query("SELECT new it.istat.mec.regedit.dto.ReportDto(adr.idRevisore.email,adr.stato,adr.validazione, cast(adr.dataMod as date) , COUNT(*)) "
			+ "FROM Toponimo AS adr WHERE  adr.idRevisore.id=:user GROUP BY adr.idRevisore.email,adr.stato, adr.validazione, cast(adr.dataMod as date)   ORDER BY adr.stato")
	List<ReportDto> getReportDailyToponimoStateByUser(@Param("user") Integer user);

	@Query("SELECT new it.istat.mec.regedit.dto.ReportDto(adr.idRevisore.email,adr.stato,adr.validazione,cast(adr.dataMod as date) , COUNT(*)) "
			+ "FROM Toponimo AS adr WHERE adr.idRevisore.id=:user and adr.stato=:state GROUP BY adr.idRevisore.email,adr.stato,adr.validazione, cast(adr.dataMod as date) ORDER BY adr.stato")
	List<ReportDto> getReportDailyToponimoStateByUserAndState(Integer user, Short state);

	@Query("SELECT new it.istat.mec.regedit.dto.ReportPivotDto(adr.idRevisore.id,adr.idRevisore.email,adr.idRevisore.name,adr.idRevisore.surname,adr.idRevisore.role.role,SUM(CASE WHEN  adr.stato =  1 THEN 1 ELSE 0 END)   ,"
			+ " SUM(CASE WHEN (adr.stato =  2 and adr.validazione='SI') THEN 1 ELSE 0 END)  , "
			+ " SUM(CASE WHEN (adr.stato =  2 and adr.validazione='NO') THEN 1 ELSE 0 END)  , "
			+ " SUM(CASE WHEN adr.stato =  3 THEN 1 ELSE 0 END)  ) "
			+ " FROM Toponimo AS adr  GROUP BY adr.idRevisore.id,adr.idRevisore.email,adr.idRevisore.name,adr.idRevisore.surname,adr.idRevisore.role.role ")
	List<ReportPivotDto> getReportPivotToponimoState();

	@Query("SELECT new it.istat.mec.regedit.dto.ReportPivotDto(adr.idRevisore.id,adr.idRevisore.email,adr.idRevisore.name,adr.idRevisore.surname,adr.idRevisore.role.role ,SUM(CASE WHEN  adr.stato =  1 THEN 1 ELSE 0 END)   ,"
			+ " SUM(CASE WHEN (adr.stato =  2 and adr.validazione='SI') THEN 1 ELSE 0 END)  , "
			+ " SUM(CASE WHEN (adr.stato =  2 and adr.validazione='NO') THEN 1 ELSE 0 END)  , "
			+ " SUM(CASE WHEN adr.stato =  3 THEN 1 ELSE 0 END)  ) "
			+ " FROM Toponimo AS adr WHERE adr.idRevisore.id=:user  GROUP BY adr.idRevisore.id,adr.idRevisore.email,adr.idRevisore.name,adr.idRevisore.surname,adr.idRevisore.role.role ")
	List<ReportPivotDto> getReportPivotToponimoStateUser(@Param("user") Integer user);

	@Query("SELECT new it.istat.mec.regedit.dto.ReportPivotDto(adr.idRevisore.id,adr.idRevisore.email,adr.idRevisore.name,adr.idRevisore.surname,adr.idRevisore.role.role, cast(adr.dataMod as date), SUM(CASE WHEN  adr.stato =  1 THEN 1 ELSE 0 END)   ,"
			+ " SUM(CASE WHEN (adr.stato =  2 and adr.validazione='SI') THEN 1 ELSE 0 END)  , "
			+ " SUM(CASE WHEN (adr.stato =  2 and adr.validazione='NO') THEN 1 ELSE 0 END)  , "
			+ " SUM(CASE WHEN adr.stato =  3 THEN 1 ELSE 0 END)  ) "
			+ " FROM Toponimo AS adr WHERE adr.dataMod IS NOT NULL AND  ((:user is NULL) OR (adr.idRevisore.id=:user))"
			+ " AND ((:dateModSup is NULL) OR (cast(adr.dataMod as date) <= :dateModSup )) AND  ((:dateModInf is NULL) OR (cast(adr.dataMod as date) >= :dateModInf ))"
			+ " GROUP BY adr.idRevisore.id,adr.idRevisore.email,adr.idRevisore.name,adr.idRevisore.surname,adr.idRevisore.role.role, cast(adr.dataMod as date)"
			+ " ORDER By 1 ASC, 6 ASC ")
	List<ReportPivotDto> getReportDailyPivotToponimoStateUser(@Param("user") Integer user,
			@Param("dateModInf") Date dateModInf, @Param("dateModSup") Date dateModSup);

	@Query("SELECT new it.istat.mec.regedit.dto.ReportPivotDto(cast(adr.dataMod as date), SUM(CASE WHEN  adr.stato =  1 THEN 1 ELSE 0 END)   ,"
			+ " SUM(CASE WHEN (adr.stato =  2 and adr.validazione='SI') THEN 1 ELSE 0 END)  , "
			+ " SUM(CASE WHEN (adr.stato =  2 and adr.validazione='NO') THEN 1 ELSE 0 END)  , "
			+ " SUM(CASE WHEN adr.stato =  3 THEN 1 ELSE 0 END)  ) "
			+ " FROM Toponimo AS adr WHERE adr.dataMod IS NOT NULL "
			+ " AND ((:dateModSup is NULL) OR (cast(adr.dataMod as date) <=  :dateModSup )) AND  ((:dateModInf is NULL) OR (cast(adr.dataMod as date) >=  :dateModInf ))"
			+ " GROUP BY cast(adr.dataMod as date)" + " ORDER By 1 ASC ")
	List<ReportPivotDto> getReportTotalDailyPivotToponimoStateUser(@Param("dateModInf") Date dateModInf,
			@Param("dateModSup") Date dateModSup);
	
	@Query("SELECT distinct new it.istat.mec.regedit.dto.UsersDto(adr.idRevisore.id, adr.idRevisore.email, adr.idRevisore.name, adr.idRevisore.surname, adr.idRevisore.role.id) FROM Toponimo AS adr "			
			+ " where adr.stato is not NULL "
			+ " ORDER BY adr.idRevisore.name ASC ")
	List<UsersDto> findAllUsersWithToponimiAssigned();
	
	/*
	 * @Query("SELECT tp FROM Toponimo AS tp " +
	 * " where 1=1 AND ((:idRevisore is NULL) OR (tp.idRevisore = :idRevisore)) " +
	 * " AND ((:stato is NULL) OR (tp.stato = :stato)) " +
	 * " ORDER BY tp.denominazioneComune ASC, tp.proCom ASC ") List<Toponimo>
	 * findAllToponimiDRByIdRevisoreAndStatoOrderByDenominazioneComuneAsc(
	 * 
	 * @Param("idRevisore") UsersEntity idRevisore, @Param("stato") Short stato);
	 */
}
