package gob.osinergmin.sibad.service.dao;

import java.util.List;

import gob.osinergmin.sibad.domain.dto.TrazProgramacionDTO;
import gob.osinergmin.sibad.filter.TrazProgramacionFilter;
import gob.osinergmin.sibad.service.exception.TrazProgramacionException;

public interface TrazProgramacionDAO {
	public TrazProgramacionDTO create(TrazProgramacionDTO trazProgramacionDTO)throws TrazProgramacionException;
	public List<TrazProgramacionDTO> find(TrazProgramacionFilter filtro) throws TrazProgramacionException;
}
