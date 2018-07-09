package gob.osinergmin.sibad.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.sibad.domain.dto.PersAutPorTipoPruebaDTO;
import gob.osinergmin.sibad.domain.dto.UnidadSupervisadaVDTO;
import gob.osinergmin.sibad.filter.EmpresaAcreditadaFilter;
import gob.osinergmin.sibad.filter.PersAutPorTipoPruebaFilter;
import gob.osinergmin.sibad.service.PersAutPorTipoPruebaService;
import gob.osinergmin.sibad.service.dao.PersAutPorTipoPruebaDAO;


@Service("persAutPorTipoPruebaService")
public class PersAutPorTipoPruebaServiceImpl implements PersAutPorTipoPruebaService{
	private static final Logger LOG = LoggerFactory.getLogger(PersAutPorTipoPruebaServiceImpl.class);

	@Inject 
	PersAutPorTipoPruebaDAO persAutPorTipoPruebaDAO;

	@Override
	@Transactional(readOnly = true)
	public List<PersAutPorTipoPruebaDTO> ListarPersonalAutorizado(PersAutPorTipoPruebaFilter filtro) {
		
		 List<PersAutPorTipoPruebaDTO> retorno=null;
	        
		 try{
            retorno = persAutPorTipoPruebaDAO.find(filtro);
            LOG.info("cuenta -size: "+retorno.size());
        }catch(Exception ex){
            LOG.error("Error en listar PersAutPorTipo",ex);
        }
		 
	        return retorno;
	}
}
