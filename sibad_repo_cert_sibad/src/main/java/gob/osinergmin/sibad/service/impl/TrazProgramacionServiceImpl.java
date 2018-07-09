package gob.osinergmin.sibad.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import gob.osinergmin.sibad.domain.dto.CompartimientoDTO;
import gob.osinergmin.sibad.domain.dto.TrazProgramacionDTO;
import gob.osinergmin.sibad.filter.TrazProgramacionFilter;
import gob.osinergmin.sibad.service.TrazProgramacionService;
import gob.osinergmin.sibad.service.dao.TrazProgramacionDAO;
import gob.osinergmin.sibad.service.exception.TrazProgramacionException;

@Service("trazprogramacionService")
public class TrazProgramacionServiceImpl implements TrazProgramacionService{

	private static final Logger LOG = LoggerFactory.getLogger(TrazProgramacionServiceImpl.class);
    
    @Inject
    TrazProgramacionDAO trazProgramacionDAO;
	
	@Override
	public TrazProgramacionDTO RegistrarTrazProgramacion(TrazProgramacionDTO trazProgramacionDTO) {
		
		LOG.info("Iniciando envio de datos al DAO");
		
		TrazProgramacionDTO registro=null;
		
		try {
						
			registro = trazProgramacionDAO.create(trazProgramacionDTO) ;
			LOG.info("(Se envio con exito los datos al DAO) registro: "+registro.toString());
			 
		} catch (TrazProgramacionException e) {
			
			LOG.error("error enviar datos al DAO",e);
		}
	
		return registro;
	}

	@Override
	public List<TrazProgramacionDTO> ConsultarTrazProgramacion(TrazProgramacionFilter filtro) {
		
		List<TrazProgramacionDTO> retorno=null;
        try{
            retorno = trazProgramacionDAO.find(filtro);
            LOG.info("cuenta -size: "+retorno.size());
        }catch(Exception ex){
            LOG.error("Error en listar Traz Programacion",ex);
        }
        return retorno;
	}

}
