package gob.osinergmin.sibad.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.sibad.domain.dto.UnidadSupervisadaDTO;
import gob.osinergmin.sibad.domain.dto.UnidadSupervisadaVDTO;
import gob.osinergmin.sibad.filter.UnidadSupervisadaFilter;
import gob.osinergmin.sibad.service.UnidadSupervisadaVService;
import gob.osinergmin.sibad.service.dao.UnidadSupervisadaVDAO;

@Service("unidadSupervisadaServiceV")
public class UnidadSupervisadaVServiceImpl implements UnidadSupervisadaVService{

	private static final Logger LOG = LoggerFactory.getLogger(UnidadSupervisadaServiceImpl.class);

	@Inject 
	UnidadSupervisadaVDAO unidadSupervisadaVDAO;

	@Override
	@Transactional(readOnly = true)
	public List<UnidadSupervisadaVDTO> ListarUnidadSupervisada(UnidadSupervisadaFilter filtro) {
		
		 List<UnidadSupervisadaVDTO> retorno=null;
	        try{
	            retorno = unidadSupervisadaVDAO.find(filtro);
	            LOG.info("cuenta -size: "+retorno.size());
	        }catch(Exception ex){
	            LOG.error("Error en listar UnidadSupervisadaV",ex);
	        }
	        return retorno;
	}
	
}
