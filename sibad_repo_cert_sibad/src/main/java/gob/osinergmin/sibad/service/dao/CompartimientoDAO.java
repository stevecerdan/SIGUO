package gob.osinergmin.sibad.service.dao;

import java.util.List;

import gob.osinergmin.sibad.domain.dto.CompartimientoDTO;
import gob.osinergmin.sibad.filter.CompartimientoFilter;
import gob.osinergmin.sibad.service.exception.CompartimientoException;

public interface CompartimientoDAO {

	public List<CompartimientoDTO> find(CompartimientoFilter filtro) throws CompartimientoException;
}
