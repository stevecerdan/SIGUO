package gob.osinergmin.sibad.service;

import java.util.List;

import gob.osinergmin.sibad.domain.dto.AlmacenamientoDTO;
import gob.osinergmin.sibad.filter.AlmacenamientoFilter;

public interface AlmacenamientoService {
	
	public List<AlmacenamientoDTO> ListarAlmacenamiento(AlmacenamientoFilter filtro);

}
