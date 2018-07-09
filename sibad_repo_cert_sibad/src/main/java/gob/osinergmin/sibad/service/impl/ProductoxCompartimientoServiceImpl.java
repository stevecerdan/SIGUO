package gob.osinergmin.sibad.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.sibad.domain.dto.ProductoxCompartimientoDTO;
import gob.osinergmin.sibad.filter.ProductoxCompartimientoFilter;
import gob.osinergmin.sibad.service.ProductoxCompartimientoService;
import gob.osinergmin.sibad.service.dao.ProductoxCompartimientoDAO;

@Service("ProductoxCompartimientoService")
public class ProductoxCompartimientoServiceImpl implements ProductoxCompartimientoService{
    private static final Logger LOG = LoggerFactory.getLogger(ProductoxCompartimientoServiceImpl.class);
    
    @Inject
    ProductoxCompartimientoDAO productoxCDAO;

	@Override
    @Transactional(readOnly = true)
	
	public List<ProductoxCompartimientoDTO> ListarProductoCompartimiento(ProductoxCompartimientoFilter filtro) {
		 
		List<ProductoxCompartimientoDTO> retorno=null;
	        try{
	            retorno = productoxCDAO.find(filtro);
	            LOG.info("cuenta -size: "+retorno.size());
	        }catch(Exception ex){
	            LOG.error("Error en listarPersonaNatural",ex);
	        }
	        return retorno;
	}

}
