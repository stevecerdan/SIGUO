package gob.osinergmin.sibad.service.dao;

import java.util.List;

import gob.osinergmin.sibad.domain.dto.SolicitudXInformeRiesgoDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.SolicitudXInformeRiesgoFilter;

public interface SolicitudXInformeRiesgoDAO {
	
	public List<SolicitudXInformeRiesgoDTO> find(SolicitudXInformeRiesgoFilter filtro);

}
