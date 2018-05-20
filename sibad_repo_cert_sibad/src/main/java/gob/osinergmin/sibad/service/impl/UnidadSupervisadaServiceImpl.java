package gob.osinergmin.sibad.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.sibad.domain.dto.UnidadSupervisadaDTO;
import gob.osinergmin.sibad.filter.UnidadSupervisadaFilter;
import gob.osinergmin.sibad.service.UnidadSupervisadaService;
import gob.osinergmin.sibad.service.dao.UnidadSupervisadaDAO;

@Service("unidadSupervisadaService")
public class UnidadSupervisadaServiceImpl implements UnidadSupervisadaService{
	private static final Logger LOG = LoggerFactory.getLogger(UnidadSupervisadaServiceImpl.class);

	@Inject 
	UnidadSupervisadaDAO unidadSupervisadaDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<UnidadSupervisadaDTO> ListarUnidadSupervisada(UnidadSupervisadaFilter filtro) {
		
		 List<UnidadSupervisadaDTO> retorno=null;
	        try{
	            retorno = unidadSupervisadaDAO.find(filtro);
	            LOG.info("cuenta -size: "+retorno.size());
	        }catch(Exception ex){
	            LOG.error("Error en listar Almacenamiento",ex);
	        }
	        return retorno;
	}

}
