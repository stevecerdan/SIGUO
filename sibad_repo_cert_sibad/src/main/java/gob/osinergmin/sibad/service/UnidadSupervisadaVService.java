package gob.osinergmin.sibad.service;

import java.util.List;

import gob.osinergmin.sibad.domain.dto.UnidadSupervisadaVDTO;
import gob.osinergmin.sibad.filter.UnidadSupervisadaFilter;

public interface UnidadSupervisadaVService {

	public List<UnidadSupervisadaVDTO> ListarUnidadSupervisada(UnidadSupervisadaFilter filtro);
}
