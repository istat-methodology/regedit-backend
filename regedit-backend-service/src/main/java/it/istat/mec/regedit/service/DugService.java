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
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.istat.mec.regedit.dao.DugDao;
import it.istat.mec.regedit.domain.Dug;
import it.istat.mec.regedit.dto.DugDto;
import it.istat.mec.regedit.exceptions.NoDataException;
import it.istat.mec.regedit.request.CreateDugRequest;
import it.istat.mec.regedit.translators.Translators;

@Service
public class DugService {
	@Autowired
	DugDao dugDao;
	
	public List<DugDto> findAllDug() {
		return dugDao.findAll().stream().map(x -> Translators.translate(x)).collect(Collectors.toList());
	}
	
	public DugDto findDugById(Integer id) {
		if (!dugDao.findById(id).isPresent())
			throw new NoDataException("Dug not present");
		return Translators.translate(dugDao.findById(id).get());
	}
	
	public DugDto newDug(CreateDugRequest request) {
		Dug dug = new Dug();
		dug = Translators.translate(request);			
		dugDao.save(dug);		    
		return Translators.translate(dug);
	}
	public DugDto updateDug(CreateDugRequest request) {		
		
		if (!dugDao.findById(request.getId()).isPresent())
			throw new NoDataException("Dug not present");
		
		Dug dug = dugDao.findById(request.getId()).get();	
		
		dug = Translators.translateUpdate(request, dug);
		
		dugDao.save(dug);		
		
		return Translators.translate(dug);
	}
	public DugDto deleteDug(Integer id) {
		if (!dugDao.findById(id).isPresent())
			throw new NoDataException("Dug not present");
		Dug dug = dugDao.findById(id).get();
		dugDao.delete(dug);
		return Translators.translate(dug);
	}

}
