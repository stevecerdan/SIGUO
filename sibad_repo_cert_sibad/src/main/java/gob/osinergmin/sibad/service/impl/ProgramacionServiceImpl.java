package gob.osinergmin.sibad.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.sibad.domain.dto.ProgramacionDTO;
import gob.osinergmin.sibad.domain.dto.UnidadSupervisadaDTO;
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
		public List<ProgramacionDTO> ListarUltimoIdCompartimiento(ProgramacionFilter filtro) {
			
			 List<ProgramacionDTO> retorno=null;
			 
		        try{
		            retorno = programacionDAO.find(filtro);
		            LOG.info("cuenta -size: "+retorno.size());
		        }catch(Exception ex){
		            LOG.error("Error al listar...",ex);
		        }
		        return retorno;
		}
	    
	    

}
