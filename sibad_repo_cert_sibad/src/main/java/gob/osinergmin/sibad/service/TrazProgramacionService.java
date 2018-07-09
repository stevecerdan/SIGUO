package gob.osinergmin.sibad.service;

import java.util.List;

import gob.osinergmin.sibad.domain.dto.TrazProgramacionDTO;
import gob.osinergmin.sibad.filter.TrazProgramacionFilter;

public interface TrazProgramacionService {
	
	 public TrazProgramacionDTO RegistrarTrazProgramacion(TrazProgramacionDTO trazProgramacionDTO);
	 public List<TrazProgramacionDTO> ConsultarTrazProgramacion(TrazProgramacionFilter filtro);

}
