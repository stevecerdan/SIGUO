package gob.osinergmin.sibad.service.dao;

import java.util.List;

import gob.osinergmin.sibad.domain.dto.CompartAlmacenamientoDTO;
import gob.osinergmin.sibad.filter.CompartAlmacenamientoFilter;

public interface CompartAlmacenamientoDAO {

	public List<CompartAlmacenamientoDTO> find(CompartAlmacenamientoFilter filtro);

}
