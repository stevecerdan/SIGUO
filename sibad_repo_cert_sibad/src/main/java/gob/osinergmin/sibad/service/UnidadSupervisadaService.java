package gob.osinergmin.sibad.service;

import java.util.List;

import gob.osinergmin.sibad.domain.dto.UnidadSupervisadaDTO;
import gob.osinergmin.sibad.filter.UnidadSupervisadaFilter;

public interface UnidadSupervisadaService {

	public List<UnidadSupervisadaDTO> ListarUnidadSupervisada(UnidadSupervisadaFilter filtro);
}
