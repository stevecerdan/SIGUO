package gob.osinergmin.sibad.service.dao;

import gob.osinergmin.sibad.domain.dto.TrazAlcanceAcredDTO;
import gob.osinergmin.sibad.service.exception.TrazAlcanceAcredException;

public interface TrazAlcanceAcredDAO {
	
	public TrazAlcanceAcredDTO create(TrazAlcanceAcredDTO trazAlcanceAcredDTO) throws TrazAlcanceAcredException;;

}
