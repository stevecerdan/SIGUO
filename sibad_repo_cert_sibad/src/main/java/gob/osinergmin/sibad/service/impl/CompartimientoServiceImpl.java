package gob.osinergmin.sibad.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.sibad.domain.dto.CompartimientoDTO;
import gob.osinergmin.sibad.filter.CompartimientoFilter;
import gob.osinergmin.sibad.service.CompartimientoService;
import gob.osinergmin.sibad.service.dao.CompartimientoDAO;

@Service("compartimientoService")
public class CompartimientoServiceImpl implements CompartimientoService{
	 private static final Logger LOG = LoggerFactory.getLogger(CompartimientoServiceImpl.class);

	 @Inject 
	 CompartimientoDAO compartimientoDAO;
	
	 @Override
	 @Transactional(readOnly = true)
	 public List<CompartimientoDTO> ListarCompartimiento(CompartimientoFilter filtro) {
		
		 List<CompartimientoDTO> retorno=null;
	        try{
	            retorno = compartimientoDAO.find(filtro);
	            LOG.info("cuenta -size: "+retorno.size());
	        }catch(Exception ex){
	            LOG.error("Error en listar Compartimiento",ex);
	        }
	        return retorno;
	}

}
