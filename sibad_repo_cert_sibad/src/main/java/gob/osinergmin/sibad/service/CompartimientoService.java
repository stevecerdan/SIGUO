package gob.osinergmin.sibad.service;

import java.util.List;

import gob.osinergmin.sibad.domain.dto.CompartimientoDTO;
import gob.osinergmin.sibad.filter.CompartimientoFilter;


public interface CompartimientoService {

	public List<CompartimientoDTO> ListarCompartimiento(CompartimientoFilter filtro);

}
