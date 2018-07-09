package gob.osinergmin.sibad.service.dao;

import java.util.List;

import gob.osinergmin.sibad.domain.dto.TrazSolicitudDTO;
import gob.osinergmin.sibad.filter.TrazSolicitudFilter;
import gob.osinergmin.sibad.service.exception.TrazSolicitudException;

public interface TrazSolicitudDAO {
	
	public TrazSolicitudDTO create(TrazSolicitudDTO trazSolicitudDTO)throws TrazSolicitudException;
	public List<TrazSolicitudDTO> find(TrazSolicitudFilter filtro) throws TrazSolicitudException;
}
