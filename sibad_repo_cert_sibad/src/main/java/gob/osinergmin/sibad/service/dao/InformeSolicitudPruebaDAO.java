package gob.osinergmin.sibad.service.dao;

import java.util.List;

import gob.osinergmin.sibad.domain.dto.InformeSolicitudPruebaDTO;
import gob.osinergmin.sibad.filter.InformeSolicitudPruebaFilter;

public interface InformeSolicitudPruebaDAO {
	public InformeSolicitudPruebaDTO create(InformeSolicitudPruebaDTO informeSolicitudPruebaDTO);
	public List<InformeSolicitudPruebaDTO> find(InformeSolicitudPruebaFilter filtro);

}
