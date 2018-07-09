package gob.osinergmin.sibad.service;

import java.util.List;

import gob.osinergmin.sibad.domain.dto.InformeSolicitudPruebaDTO;
import gob.osinergmin.sibad.filter.InformeSolicitudPruebaFilter;

public interface InformeSolicitudPruebaService {

	public InformeSolicitudPruebaDTO RegistrarInformeSolicitudPrueba(InformeSolicitudPruebaDTO informeSolicitudPruebaDTO);
	public List<InformeSolicitudPruebaDTO> ListarInformeSolicitudPrueba(InformeSolicitudPruebaFilter filtro);

}
