package gob.osinergmin.sibad.service.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.sibad.domain.MdiPersonaJuridica1;
import gob.osinergmin.sibad.domain.PghTrazAlcanceAcred;
import gob.osinergmin.sibad.domain.builder.EmpresaAcreditadaBuilder;
import gob.osinergmin.sibad.domain.builder.PersonaJuridicaBuilder;
import gob.osinergmin.sibad.domain.builder.TrazAlcanceAcredBuilder;
import gob.osinergmin.sibad.domain.dto.EmpresaAcreditadaDTO;
import gob.osinergmin.sibad.domain.dto.PersonaJuridicaDTO;
import gob.osinergmin.sibad.domain.dto.TrazAlcanceAcredDTO;
import gob.osinergmin.sibad.filter.EmpresaAcreditadaFilter;
import gob.osinergmin.sibad.filter.TrazAlcanceAcredFilter;
import gob.osinergmin.sibad.service.dao.CrudDAO;
import gob.osinergmin.sibad.service.dao.TrazAlcanceAcredDAO;
import gob.osinergmin.sibad.service.exception.EmpresaAcreditadaException;
import gob.osinergmin.sibad.service.exception.TrazAlcanceAcredException;

@Repository("TrazAlcanceAcredDAO")
@Transactional
public class TrazAlcanceAcredDAOImpl implements TrazAlcanceAcredDAO{
	 private static final Logger LOG = LoggerFactory.getLogger(TrazAlcanceAcredDAOImpl.class);
	    @Inject
	    private CrudDAO crud;
	
	    @Override
	    public List<TrazAlcanceAcredDTO> find(TrazAlcanceAcredFilter filtro) throws TrazAlcanceAcredException {
	        List<TrazAlcanceAcredDTO> listado;
	        
	        Query query = getFindQuery(filtro);
	        
	        LOG.info(query.toString());
	        
	        listado = TrazAlcanceAcredBuilder.toListTrazAlcanceAcredDto(query.getResultList());

	        return listado;
	    }
	    
	    private Query getFindQuery(TrazAlcanceAcredFilter filtro) {
	        Query query=null;
	        try{
	            if(filtro.getIdAlcanceAcreditacion()!=null){
	            	query = crud.getEm().createNamedQuery("PghTrazAlcanceAcred.findByTraz");
	            }
	            
	           if(filtro.getIdAlcanceAcreditacion()!=null){
	        	   
	                query.setParameter("idAlcanceAcreditacion",filtro.getIdAlcanceAcreditacion());
	                
	                if(filtro.getEstadoAccion()!=null){
	                	query.setParameter("estadoAccion",filtro.getEstadoAccion());
	                }
	            }
	            //query.setParameter("idPersonal",filtro.getIdPersonal());
	        }catch(Exception e){
	        	
	            LOG.error("Error getFindQuery: "+e.getMessage());
	            
	        }
	        return query;
	    }
	    
	@Override
	public TrazAlcanceAcredDTO create(TrazAlcanceAcredDTO trazAlcanceAcredDTO) throws TrazAlcanceAcredException {
		
		LOG.info("Iniciando registro de Traz Alcance Acred");
		
		TrazAlcanceAcredDTO retorno = null;
		
		
		try {
			
			PghTrazAlcanceAcred pghTrazAlcanceAcred = new PghTrazAlcanceAcred();
			
			pghTrazAlcanceAcred.setIdAlcanceAcreditacion(trazAlcanceAcredDTO.getIdAlcanceAcreditacion());
			pghTrazAlcanceAcred.setIdTipoMotivo(trazAlcanceAcredDTO.getIdTipoMotivo());
			pghTrazAlcanceAcred.setEstado(trazAlcanceAcredDTO.getEstado());
			pghTrazAlcanceAcred.setEstadoAccion(trazAlcanceAcredDTO.getEstadoAccion());
			pghTrazAlcanceAcred.setIdDocumentoAdjunto(trazAlcanceAcredDTO.getIdDocumentoAdjunto());
			pghTrazAlcanceAcred.setObservacion(trazAlcanceAcredDTO.getObservacion());
			
			
			
			
			LOG.info(" Datos:"+pghTrazAlcanceAcred.getIdAlcanceAcreditacion()+" - " +pghTrazAlcanceAcred.getIdTipoMotivo()+" - " +pghTrazAlcanceAcred.getEstado()+" - " +pghTrazAlcanceAcred.getEstadoAccion()+" - " +pghTrazAlcanceAcred.getIdDocumentoAdjunto()+" - " +pghTrazAlcanceAcred.getObservacion());
			
			crud.create(pghTrazAlcanceAcred);
			
			retorno = TrazAlcanceAcredBuilder.toTrazAlcanceAcredDto(pghTrazAlcanceAcred);
			 
			LOG.info("(Registro exitoso) retorno: "+retorno.toString());
			
			
		}catch(Exception ex){
            LOG.error("",ex);
        }
		
		return retorno;
	}

}
