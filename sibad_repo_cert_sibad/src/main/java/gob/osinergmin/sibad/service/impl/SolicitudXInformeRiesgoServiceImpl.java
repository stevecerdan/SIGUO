package gob.osinergmin.sibad.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import gob.osinergmin.sibad.domain.dto.SolicitudXInformeRiesgoDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.SolicitudXInformeRiesgoFilter;
import gob.osinergmin.sibad.service.SolicitudXInformeRiesgoService;
import gob.osinergmin.sibad.service.dao.SolicitudXInformeRiesgoDAO;

@Service("SolicitudXInformeRiesgoService")
public class SolicitudXInformeRiesgoServiceImpl implements SolicitudXInformeRiesgoService{
	private static final Logger LOG = LoggerFactory.getLogger(SolicitudXInformeRiesgoServiceImpl.class);

	@Inject
	SolicitudXInformeRiesgoDAO solicitudxInformeRiesgoDao;

	@Override
	public List<SolicitudXInformeRiesgoDTO> consultarSolicitudXInformeRiesgo(SolicitudXInformeRiesgoFilter filtro) {
		
        List<SolicitudXInformeRiesgoDTO> retorno=null;
		
        try{
        	
            retorno = solicitudxInformeRiesgoDao.find(filtro);
            LOG.info("cuenta -size: "+retorno.size());
            
        }catch(Exception ex){
        	
            LOG.error("Error en Solicitud X Informe Riesgo",ex);
            
        }
        return retorno;
	}
	
}
