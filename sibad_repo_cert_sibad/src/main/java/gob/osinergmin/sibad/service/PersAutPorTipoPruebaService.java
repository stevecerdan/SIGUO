package gob.osinergmin.sibad.service;

import java.util.List;

import gob.osinergmin.sibad.domain.dto.PersAutPorTipoPruebaDTO;
import gob.osinergmin.sibad.filter.EmpresaAcreditadaFilter;
import gob.osinergmin.sibad.filter.PersAutPorTipoPruebaFilter;

public interface PersAutPorTipoPruebaService {
	
	public List<PersAutPorTipoPruebaDTO> ListarPersonalAutorizado(PersAutPorTipoPruebaFilter filtro);

}
