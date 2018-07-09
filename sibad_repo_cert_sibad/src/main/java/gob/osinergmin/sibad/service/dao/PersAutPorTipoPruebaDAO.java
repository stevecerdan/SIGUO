package gob.osinergmin.sibad.service.dao;

import java.util.List;

import gob.osinergmin.sibad.domain.dto.PersAutPorTipoPruebaDTO;
import gob.osinergmin.sibad.filter.EmpresaAcreditadaFilter;
import gob.osinergmin.sibad.filter.PersAutPorTipoPruebaFilter;
import gob.osinergmin.sibad.service.exception.PersAutPorTipoPruebaException;

public interface PersAutPorTipoPruebaDAO {
	public List<PersAutPorTipoPruebaDTO> find(PersAutPorTipoPruebaFilter filtro) throws PersAutPorTipoPruebaException;

}
