package gob.osinergmin.sibad.service;

import java.util.List;

import gob.osinergmin.sibad.domain.dto.SolicitudPruebaRepruebaDTO;
import gob.osinergmin.sibad.filter.SolicitudPruebaRepruebaFilter;

public interface SolicitudxEmpresaService {

	public List<SolicitudPruebaRepruebaDTO> listarSolicitudes(SolicitudPruebaRepruebaFilter filtro);

}
