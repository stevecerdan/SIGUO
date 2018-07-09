package gob.osinergmin.sibad.service;

import java.util.List;

import gob.osinergmin.sibad.domain.dto.TrazSolicitudDTO;
import gob.osinergmin.sibad.filter.TrazSolicitudFilter;

public interface TrazSolicitudService {
	
	 public TrazSolicitudDTO RegistrarTrazSolicitud(TrazSolicitudDTO trazSolicitudDTO);
	 public List<TrazSolicitudDTO> listarTrazSolicitud(TrazSolicitudFilter filtro);

}
