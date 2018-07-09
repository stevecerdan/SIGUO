package gob.osinergmin.sibad.service;

import java.util.List;

import gob.osinergmin.sibad.domain.dto.SolicitudXInformeRiesgoDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.SolicitudXInformeRiesgoFilter;

public interface SolicitudXInformeRiesgoService {

	public List<SolicitudXInformeRiesgoDTO> consultarSolicitudXInformeRiesgo(SolicitudXInformeRiesgoFilter filtro);

}
