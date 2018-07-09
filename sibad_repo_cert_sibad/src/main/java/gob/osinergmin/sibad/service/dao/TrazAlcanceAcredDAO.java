package gob.osinergmin.sibad.service.dao;

import java.util.List;

import gob.osinergmin.sibad.domain.dto.TrazAlcanceAcredDTO;
import gob.osinergmin.sibad.filter.TrazAlcanceAcredFilter;
import gob.osinergmin.sibad.service.exception.TrazAlcanceAcredException;

public interface TrazAlcanceAcredDAO {
	
	public List<TrazAlcanceAcredDTO> find(TrazAlcanceAcredFilter filtro) throws TrazAlcanceAcredException;
	public TrazAlcanceAcredDTO create(TrazAlcanceAcredDTO trazAlcanceAcredDTO) throws TrazAlcanceAcredException;;

}
