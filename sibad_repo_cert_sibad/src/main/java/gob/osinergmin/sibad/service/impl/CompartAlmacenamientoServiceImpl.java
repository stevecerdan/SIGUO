package gob.osinergmin.sibad.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import gob.osinergmin.sibad.domain.dto.CompartAlmacenamientoDTO;
import gob.osinergmin.sibad.filter.CompartAlmacenamientoFilter;
import gob.osinergmin.sibad.service.CompartAlmacenamientoService;
import gob.osinergmin.sibad.service.dao.CompartAlmacenamientoDAO;

@Service("CompartAlmacenamientoService")
public class CompartAlmacenamientoServiceImpl implements CompartAlmacenamientoService{
	private static final Logger LOG = LoggerFactory.getLogger(CompartAlmacenamientoServiceImpl.class);

	 @Inject 
	 CompartAlmacenamientoDAO compartimientoDAO;
	 
	@Override
	public List<CompartAlmacenamientoDTO> Listar(CompartAlmacenamientoFilter filtro) {
		 List<CompartAlmacenamientoDTO> retorno=null;
	        try{
	            retorno = compartimientoDAO.find(filtro);
	            LOG.info("cuenta -size: "+retorno.size());
	        }catch(Exception ex){
	            LOG.error("Error en listar Compartimiento",ex);
	        }
	        return retorno;
	}
	
}
