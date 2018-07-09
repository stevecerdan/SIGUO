package gob.osinergmin.sibad.service.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import gob.osinergmin.sibad.domain.PghResultadoRevision;
import gob.osinergmin.sibad.domain.builder.ResultadoRevisionBuilder;
import gob.osinergmin.sibad.domain.dto.ResultadoRevisionDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.ResultadoRevisionFilter;
import gob.osinergmin.sibad.service.dao.CrudDAO;
import gob.osinergmin.sibad.service.dao.ResultadoRevisionDAO;


@Repository("ResultadoRevisionDAO")
@Transactional
public class ResultadoRevisionDAOImpl implements ResultadoRevisionDAO{
	 private static final Logger LOG = LoggerFactory.getLogger(ResultadoRevisionDAOImpl.class);
	 
	 @Inject
	 private CrudDAO crud;

	@Override
	public ResultadoRevisionDTO create(ResultadoRevisionDTO resultadoRevDTO, UsuarioDTO usuarioDTO) {
		
		
		 LOG.info("Iniciando registro de  Resultado Revision");
			
		   ResultadoRevisionDTO retorno=null;
			
			try{
				
				PghResultadoRevision  pghResultadoRevision=  new PghResultadoRevision();
				
				pghResultadoRevision.setIdResultadoRevision(resultadoRevDTO.getIdResultadoRevision());
				pghResultadoRevision.setEstadoResultado(resultadoRevDTO.getEstadoResultado());
				pghResultadoRevision.setFechaFin(resultadoRevDTO.getFechaFin());
				pghResultadoRevision.setFechaInicio(resultadoRevDTO.getFechaInicio());
				pghResultadoRevision.setFlagPersona(resultadoRevDTO.getFlagPersona());
				pghResultadoRevision.setHoraFin(resultadoRevDTO.getHoraFin());
				pghResultadoRevision.setHoraInicio(resultadoRevDTO.getHoraInicio());
				pghResultadoRevision.setIdPersonaJuridica(resultadoRevDTO.getIdPersonaJuridica());
				pghResultadoRevision.setIdProgramacion(resultadoRevDTO.getIdProgramacion());
				pghResultadoRevision.setObservacion(resultadoRevDTO.getObservacion());
				pghResultadoRevision.setResultadoRevision(resultadoRevDTO.getResultadoRevision());
				pghResultadoRevision.setTipoPersonal(resultadoRevDTO.getTipoPersonal());
				pghResultadoRevision.setDatosAuditoria(usuarioDTO);
				
			    //LOG.info(" Datos:"+pghEmpresaAcreditada.getEstado()+" - " +pghEmpresaAcreditada.getIdPersonaJuridica());

			    if(resultadoRevDTO.getIdResultadoRevision()!= null) {
			    	
			    	pghResultadoRevision = crud.find(resultadoRevDTO.getIdResultadoRevision(), PghResultadoRevision.class);
			    	pghResultadoRevision.setIdResultadoRevision(resultadoRevDTO.getIdResultadoRevision());
					pghResultadoRevision.setEstadoResultado(resultadoRevDTO.getEstadoResultado());
					pghResultadoRevision.setFechaFin(resultadoRevDTO.getFechaFin());
					pghResultadoRevision.setFechaInicio(resultadoRevDTO.getFechaInicio());
					pghResultadoRevision.setFlagPersona(resultadoRevDTO.getFlagPersona());
					pghResultadoRevision.setHoraFin(resultadoRevDTO.getHoraFin());
					pghResultadoRevision.setHoraInicio(resultadoRevDTO.getHoraInicio());
					pghResultadoRevision.setIdPersonaJuridica(resultadoRevDTO.getIdPersonaJuridica());
					pghResultadoRevision.setIdProgramacion(resultadoRevDTO.getIdProgramacion());
					pghResultadoRevision.setObservacion(resultadoRevDTO.getObservacion());
					pghResultadoRevision.setResultadoRevision(resultadoRevDTO.getResultadoRevision());
					pghResultadoRevision.setTipoPersonal(resultadoRevDTO.getTipoPersonal());
					pghResultadoRevision.setDatosAuditoria(usuarioDTO);
			    	
			    	
					crud.update(pghResultadoRevision);
			    	
			    } else  {	    	

					crud. create(pghResultadoRevision);
			    	
			    }
			    
				retorno = ResultadoRevisionBuilder.toPghResultadoRevision(pghResultadoRevision);
				 
				LOG.info("(Registro exitoso) retorno: "+retorno.toString());
			
			}catch(Exception ex){
	            LOG.error("",ex);
	        }
			
			return retorno;
		/*PghResultadoRevision pghResultadoRevision = ResultadoRevisionBuilder.toPghResultadoRevision(resultadoRevDTO);
		pghResultadoRevision.setDatosAuditoria(usuarioDTO);
		
		if (resultadoRevDTO.getIdResultadoRevision() != null) {
			LOG.error("UPDATE");
			crud.update(pghResultadoRevision);
		}else {
			LOG.error("CREATE");
			crud.create(pghResultadoRevision);
		}	
		return resultadoRevDTO;*/
	}

	@Override
	public List<ResultadoRevisionDTO> find(ResultadoRevisionFilter filtro) {
       
		List<ResultadoRevisionDTO> listado;
        
        Query query = getFindQuery(filtro);
        listado = ResultadoRevisionBuilder.toListResultadoRevisionDto(query.getResultList());

        return listado;
	}
	
	private Query getFindQuery(ResultadoRevisionFilter filtro) {
        Query query=null;
        
        try{
            if(filtro.getIdResultadoRevision() !=null && !(filtro.getIdResultadoRevision()+"").equals("")){
            	LOG.info("1 and.."+filtro.getIdResultadoRevision());
            	query = crud.getEm().createNamedQuery("PghResultadoRevision.findByIdResultado");
                
            }

            if(filtro.getIdResultadoRevision()!=null && !(filtro.getIdResultadoRevision()+"").equals("") ){
            	LOG.info("2 and.."+filtro.getIdResultadoRevision());
                	query.setParameter("idResultadoRevision",filtro.getIdResultadoRevision() );
                	                    
              }
            
        }catch(Exception e){
            LOG.error("Error getFindQuery: "+e.getMessage());
        }
        return query;
    }

}
