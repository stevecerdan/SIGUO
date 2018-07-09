package gob.osinergmin.sibad.service.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.sibad.domain.PghTrazSolicitud;
import gob.osinergmin.sibad.domain.builder.TrazSolicitudBuilder;
import gob.osinergmin.sibad.domain.dto.TrazSolicitudDTO;
import gob.osinergmin.sibad.filter.TrazSolicitudFilter;
import gob.osinergmin.sibad.service.dao.CrudDAO;
import gob.osinergmin.sibad.service.dao.TrazSolicitudDAO;
import gob.osinergmin.sibad.service.exception.TrazSolicitudException;

@Repository("TrazSolicitudDAO")
@Transactional
public class TrazSolicitudDAOImpl implements TrazSolicitudDAO{
	private static final Logger LOG = LoggerFactory.getLogger(TrazSolicitudDAOImpl.class);
	
	@Inject
    private CrudDAO crud;
	
	@Override
	public TrazSolicitudDTO create(TrazSolicitudDTO trazSolicitudDTO) throws TrazSolicitudException {
		
		 LOG.info("Iniciando registro...");
			
	       TrazSolicitudDTO retorno = null;
			
			try {
				
				PghTrazSolicitud pghTrazSolicitud = new PghTrazSolicitud();
				
				pghTrazSolicitud.setIdTrazSolicitud(trazSolicitudDTO.getIdTrazSolicitud());
				pghTrazSolicitud.setIdSolicitudPruebaReprueba(trazSolicitudDTO.getIdSolicitudPruebaReprueba());
				pghTrazSolicitud.setIdTipoMotivo(trazSolicitudDTO.getIdTipoMotivo());
				pghTrazSolicitud.setObservacion(trazSolicitudDTO.getObservacion());
				pghTrazSolicitud.setFechaUltimoEstado(trazSolicitudDTO.getFechaUltimoEstado());
				pghTrazSolicitud.setEstado(trazSolicitudDTO.getEstado());

				LOG.info(" Datos:"+pghTrazSolicitud.getIdTrazSolicitud()+" - " +pghTrazSolicitud.getIdSolicitudPruebaReprueba()+" - " +pghTrazSolicitud.getFechaUltimoEstado()+" - " +pghTrazSolicitud.getEstado());
				
				crud.create(pghTrazSolicitud);
				
				retorno = TrazSolicitudBuilder.toTrazSolicitudDto(pghTrazSolicitud);
				 
				LOG.info("(Registro exitoso) retorno: "+retorno.toString());
				
				
			}catch(Exception ex){
	            LOG.error("",ex);
	        }
			
			return retorno;
	}

	@Override
    public List<TrazSolicitudDTO> find(TrazSolicitudFilter filtro) throws TrazSolicitudException {
        List<TrazSolicitudDTO> listado;
        
        Query query = getFindQuery(filtro);
        
        LOG.info(query.toString());
        
        listado = TrazSolicitudBuilder.toListTrazSolicitudDto(query.getResultList());

        return listado;
    }
    
    private Query getFindQuery(TrazSolicitudFilter filtro) {
        Query query=null;
        try{
            if(filtro.getIdSolicitudPruebaReprueba()!=null){
            	query = crud.getEm().createNamedQuery("PghTrazSolicitud.findByTrazSol");
            }
            
           if(filtro.getIdSolicitudPruebaReprueba()!=null){
        	   
                query.setParameter("idSolicitudPruebaReprueba",filtro.getIdSolicitudPruebaReprueba());
                
                if(filtro.getEstado()!=null){
                	query.setParameter("estado",filtro.getEstado());
                }
            }
            //query.setParameter("idPersonal",filtro.getIdPersonal());
        }catch(Exception e){
        	
            LOG.error("Error getFindQuery: "+e.getMessage());
            
        }
        return query;
    }

}
