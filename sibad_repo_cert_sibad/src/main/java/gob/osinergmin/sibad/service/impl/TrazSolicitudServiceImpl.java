package gob.osinergmin.sibad.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import gob.osinergmin.sibad.domain.dto.CompartimientoDTO;
import gob.osinergmin.sibad.domain.dto.TrazSolicitudDTO;
import gob.osinergmin.sibad.filter.TrazSolicitudFilter;
//import gob.osinergmin.sibad.filter.TrazSolicitudFilter;
import gob.osinergmin.sibad.service.TrazSolicitudService;
import gob.osinergmin.sibad.service.dao.TrazSolicitudDAO;
import gob.osinergmin.sibad.service.exception.TrazSolicitudException;

@Service("trazsolicitudService")
public class TrazSolicitudServiceImpl implements TrazSolicitudService{

	private static final Logger LOG = LoggerFactory.getLogger(TrazSolicitudServiceImpl.class);
    
    @Inject
    TrazSolicitudDAO trazSolicitudDAO;
	
	@Override
	public TrazSolicitudDTO RegistrarTrazSolicitud(TrazSolicitudDTO trazSolicitudDTO) {
		
		LOG.info("Iniciando envio de datos al DAO");
		
		TrazSolicitudDTO registro=null;
		
		try {
						
			registro = trazSolicitudDAO.create(trazSolicitudDTO) ;
			LOG.info("(Se envio con exito los datos al DAO) registro: "+registro.toString());
			 
		} catch (TrazSolicitudException e) {
			
			LOG.error("error enviar datos al DAO",e);
		}
	
		return registro;
	}

	@Override
	public List<TrazSolicitudDTO> listarTrazSolicitud(TrazSolicitudFilter filtro) {
		
		List<TrazSolicitudDTO> retorno=null;
        try{
            retorno = trazSolicitudDAO.find(filtro);
            LOG.info("cuenta -size: "+retorno.size());
        }catch(Exception ex){
            LOG.error("Error en listar Traz Solicitud",ex);
        }
        return retorno;
	}

}
