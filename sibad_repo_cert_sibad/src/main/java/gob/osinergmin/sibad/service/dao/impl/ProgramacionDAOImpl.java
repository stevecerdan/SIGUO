package gob.osinergmin.sibad.service.dao.impl;



import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.sibad.domain.PghProgramacion;
import gob.osinergmin.sibad.domain.builder.ProgramacionBuilder;
import gob.osinergmin.sibad.domain.builder.UnidadSupervisadaBuilder;
import gob.osinergmin.sibad.domain.dto.ProgramacionDTO;
import gob.osinergmin.sibad.domain.dto.UnidadSupervisadaDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.ProgramacionFilter;
import gob.osinergmin.sibad.filter.UnidadSupervisadaFilter;
import gob.osinergmin.sibad.service.dao.CrudDAO;
import gob.osinergmin.sibad.service.dao.ProgramacionDAO;
import gob.osinergmin.sibad.service.exception.ProgramacionException;

@Repository("ProgramacionDAO")
@Transactional
public class ProgramacionDAOImpl implements ProgramacionDAO {
	private static final Logger LOG = LoggerFactory.getLogger(TrazAlcanceAcredDAOImpl.class);
   
	@Inject
    private CrudDAO crud;

	@Override
	public ProgramacionDTO create(ProgramacionDTO programacionDTO, UsuarioDTO usuarioDTO) throws ProgramacionException {
		
	 LOG.info("Iniciando registro...");
			
	       ProgramacionDTO retorno = null;
			
			try {
				
				PghProgramacion pghProgramacion = new PghProgramacion();
				
				pghProgramacion.setIdProgramacion(programacionDTO.getIdProgramacion());
				pghProgramacion.setIdCompartimiento(programacionDTO.getIdCompartimiento());
				pghProgramacion.setNumeroProgramacion(programacionDTO.getNumeroProgramacion());
				pghProgramacion.setTipoProgramacion(programacionDTO.getTipoProgramacion());
				pghProgramacion.setTipoRevision(programacionDTO.getTipoRevision());
				pghProgramacion.setFechaProgramacion(programacionDTO.getFechaProgramacion());
				pghProgramacion.setEstado(programacionDTO.getEstado());
				pghProgramacion.setDatosAuditoria(usuarioDTO);

				LOG.info(" Datos:"+pghProgramacion.getIdProgramacion()+" - " +pghProgramacion.getIdCompartimiento()+" - " +pghProgramacion.getNumeroProgramacion()+" - " +pghProgramacion.getTipoProgramacion()+" - " +pghProgramacion.getTipoRevision()+" - " +pghProgramacion.getFechaProgramacion()+" - " +pghProgramacion.getEstado());
				
				crud.create(pghProgramacion);
				
				retorno = ProgramacionBuilder.toProgramacionDto(pghProgramacion);
				 
				LOG.info("(Registro exitoso) retorno: "+retorno.toString());
				
				
			}catch(Exception ex){
	            LOG.error("",ex);
	        }
			
			return retorno;
	}

	@Override
	public List<ProgramacionDTO> find(ProgramacionFilter filtro) throws ProgramacionException {
		
		
        List<ProgramacionDTO> listado;
        
        Query query = getFindQuery(filtro);
       // listado = ProgramacionBuilder.toProgramacionaDto(query.getResultList());

        //return listado;
        return null;
	}
	
	private Query getFindQuery(ProgramacionFilter filtro) {
		
        Query query=null;
        try{
            if(filtro.getIdCompartimiento()!=null){
            	query = crud.getEm().createNamedQuery("PghProgramacion.findByIdCompartimiento");
            }
         
            if(filtro.getIdCompartimiento()==null){
                query.setParameter("idCompartimiento","");
            }else {
            	query.setParameter("idCompartimiento",filtro.getIdCompartimiento());
            }
           
        }catch(Exception e){
        	
            LOG.error("Error getFindQuery: "+e.getMessage());
            
        }
        return query;
    }
	
}
