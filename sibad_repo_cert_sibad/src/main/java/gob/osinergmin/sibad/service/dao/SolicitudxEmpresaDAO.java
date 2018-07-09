package gob.osinergmin.sibad.service.dao;

import java.util.List;

import gob.osinergmin.sibad.domain.dto.SolicitudPruebaRepruebaDTO;
import gob.osinergmin.sibad.filter.SolicitudPruebaRepruebaFilter;

public interface SolicitudxEmpresaDAO {
	public List<SolicitudPruebaRepruebaDTO> find(SolicitudPruebaRepruebaFilter filtro);
}
