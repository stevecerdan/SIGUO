package gob.osinergmin.sibad.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.sibad.domain.dto.ProgramacionDTO;
import gob.osinergmin.sibad.domain.dto.ProgramacionVDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.ProgramacionFilter;
import gob.osinergmin.sibad.service.ProgramacionService;
import gob.osinergmin.sibad.service.dao.ProgramacionDAO;
import gob.osinergmin.sibad.service.exception.ProgramacionException;

@Service("programacionService")
public class ProgramacionServiceImpl implements  ProgramacionService{
	
	 private static final Logger LOG = LoggerFactory.getLogger(ProgramacionServiceImpl.class);
	    
	    @Inject
	    ProgramacionDAO programacionDAO;

		@Override
		public ProgramacionDTO RegistrarProgramacion(ProgramacionDTO programacionDTO, UsuarioDTO usuarioDTO) {
			
			LOG.info("Iniciando envio de datos al DAO");
			
			ProgramacionDTO registro=null;
			
			try {
							
				registro = programacionDAO.create(programacionDTO, usuarioDTO);
				LOG.info("(Se envio con exito los datos al DAO) registro: "+registro.toString());
				 
			} catch (ProgramacionException e) {
				
				LOG.error("error enviar datos al DAO",e);
			}
		
			return registro;
		}

		@Override
		@Transactional(readOnly = true)
		public List<ProgramacionVDTO> ListarProgramacion(ProgramacionFilter filtro) {
			
			List<ProgramacionVDTO> retorno=null;
	        try{
	            retorno = programacionDAO.findV(filtro);
	            LOG.info("cuenta -size: "+retorno.size());
	        }catch(Exception ex){
	            LOG.error("Error en listar...",ex);
	        }
	        return retorno;
		}

		@Override
		public ProgramacionDTO EditarProgramacion(ProgramacionDTO programacionDTO, UsuarioDTO usuarioDTO) {
						
        LOG.info("Iniciando envio de datos al DAO");
			
			ProgramacionDTO registro=null;
			
			try {
							
				registro = programacionDAO.update(programacionDTO, usuarioDTO);
				LOG.info("(Se envio con exito los datos al DAO) registro: "+registro.toString());
				 
			} catch (ProgramacionException e) {
				
				LOG.error("error enviar datos al DAO",e);
			}
		
			return registro;
		}

		@Override
		public ProgramacionDTO EliminarProgramacion(ProgramacionDTO programacionDTO, UsuarioDTO usuarioDTO) {
			
			 LOG.info("Iniciando envio de datos al DAO");
				
				ProgramacionDTO registro=null;
				
				try {
								
					registro = programacionDAO.delete(programacionDTO, usuarioDTO);
					LOG.info("(Se envio con exito los datos al DAO) registro: "+registro.toString());
					 
				} catch (ProgramacionException e) {
					
					LOG.error("error enviar datos al DAO",e);
				}
			
				return registro;
		}

		@Override
		public List<ProgramacionVDTO> ProgramacionesVencidas(ProgramacionFilter filtro) {
			
			List<ProgramacionVDTO> retorno=null;
	        try{
	            retorno = programacionDAO.findProgramacionesVencidas(filtro);
	            LOG.info("cuenta -size: "+retorno.size());
	        }catch(Exception ex){
	            LOG.error("Error en listar...",ex);
	        }
	        return retorno;
		}    

}
