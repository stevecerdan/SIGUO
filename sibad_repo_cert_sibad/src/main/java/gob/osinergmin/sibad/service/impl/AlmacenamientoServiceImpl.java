package gob.osinergmin.sibad.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.sibad.domain.dto.AlmacenamientoDTO;
import gob.osinergmin.sibad.filter.AlmacenamientoFilter;
import gob.osinergmin.sibad.service.AlmacenamientoService;
import gob.osinergmin.sibad.service.dao.AlmacenamientoDAO;

@Service("almacenamientoService")
public class AlmacenamientoServiceImpl implements AlmacenamientoService{
	 private static final Logger LOG = LoggerFactory.getLogger(AlmacenamientoServiceImpl.class);
	
	 @Inject 
	 AlmacenamientoDAO almacenamientoDAO;
	
	 @Override
	 @Transactional(readOnly = true)
	 public List<AlmacenamientoDTO> ListarAlmacenamiento(AlmacenamientoFilter filtro) {
		
		 List<AlmacenamientoDTO> retorno=null;
	        try{
	            retorno = almacenamientoDAO.find(filtro);
	            LOG.info("cuenta -size: "+retorno.size());
	        }catch(Exception ex){
	            LOG.error("Error en listar Almacenamiento",ex);
	        }
	        return retorno;
	} 

}
