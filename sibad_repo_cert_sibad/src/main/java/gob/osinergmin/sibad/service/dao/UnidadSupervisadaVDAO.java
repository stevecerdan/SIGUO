package gob.osinergmin.sibad.service.dao;

import java.util.List;

import gob.osinergmin.sibad.domain.dto.UnidadSupervisadaVDTO;
import gob.osinergmin.sibad.filter.UnidadSupervisadaFilter;
import gob.osinergmin.sibad.service.exception.UnidadSupervisadaException;

public interface UnidadSupervisadaVDAO {
	public List<UnidadSupervisadaVDTO> find(UnidadSupervisadaFilter filtro) throws UnidadSupervisadaException;

}
