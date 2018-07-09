package gob.osinergmin.sibad.service;

import java.util.List;

import gob.osinergmin.sibad.domain.dto.CompartAlmacenamientoDTO;
import gob.osinergmin.sibad.filter.CompartAlmacenamientoFilter;

public interface CompartAlmacenamientoService {

	public List<CompartAlmacenamientoDTO> Listar(CompartAlmacenamientoFilter filtro);

}
