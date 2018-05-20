package gob.osinergmin.sibad.service.dao;

import java.util.List;

import gob.osinergmin.sibad.domain.dto.UnidadSupervisadaDTO;
import gob.osinergmin.sibad.filter.UnidadSupervisadaFilter;
import gob.osinergmin.sibad.service.exception.UnidadSupervisadaException;

public interface UnidadSupervisadaDAO {

	public List<UnidadSupervisadaDTO> find(UnidadSupervisadaFilter filtro) throws UnidadSupervisadaException;
}
