package gob.osinergmin.sibad.service.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.sibad.domain.PghTrazProgramacion;
import gob.osinergmin.sibad.domain.builder.TrazProgramacionBuilder;
import gob.osinergmin.sibad.domain.dto.TrazProgramacionDTO;
import gob.osinergmin.sibad.filter.TrazProgramacionFilter;
import gob.osinergmin.sibad.service.dao.CrudDAO;
import gob.osinergmin.sibad.service.dao.TrazProgramacionDAO;
import gob.osinergmin.sibad.service.exception.TrazProgramacionException;

@Repository("TrazProgramacionDAO")
@Transactional
public class TrazProgramacionDAOImpl implements TrazProgramacionDAO{
	private static final Logger LOG = LoggerFactory.getLogger(TrazProgramacionDAOImpl.class);
	
	@Inject
    private CrudDAO crud;
	
	@Override
	public TrazProgramacionDTO create(TrazProgramacionDTO trazProgramacionDTO) throws TrazProgramacionException {
		
		 LOG.info("Iniciando registro...");
			
	       TrazProgramacionDTO retorno = null;
			
			try {
				
				PghTrazProgramacion pghTrazProgramacion = new PghTrazProgramacion();
				
				pghTrazProgramacion.setIdTrazProgramacion(trazProgramacionDTO.getIdTrazProgramacion());
				pghTrazProgramacion.setIdProgramacion(trazProgramacionDTO.getIdProgramacion());
				pghTrazProgramacion.setFechaUltimoEstado(trazProgramacionDTO.getFechaUltimoEstado());
				pghTrazProgramacion.setObservacion(trazProgramacionDTO.getObservacion());
				pghTrazProgramacion.setIdTipoMotivo(trazProgramacionDTO.getIdTipoMotivo());
				pghTrazProgramacion.setEstado(trazProgramacionDTO.getEstado());

				LOG.info(" Datos:"+pghTrazProgramacion.getIdTrazProgramacion()+" - " +pghTrazProgramacion.getIdProgramacion()+" - " +pghTrazProgramacion.getFechaUltimoEstado()+" - " +pghTrazProgramacion.getEstado());
				
				crud.create(pghTrazProgramacion);
				
				retorno = TrazProgramacionBuilder.toTrazProgramacionDto(pghTrazProgramacion);
				 
				LOG.info("(Registro exitoso) retorno: "+retorno.toString());
				
				
			}catch(Exception ex){
	            LOG.error("",ex);
	        }
			
			return retorno;
	}

	@Override
	public List<TrazProgramacionDTO> find(TrazProgramacionFilter filtro) throws TrazProgramacionException {
		
		List<TrazProgramacionDTO> listado;
        
        Query query = getFindQuery(filtro);
        listado = TrazProgramacionBuilder.toListTrazProgramacionDto(query.getResultList());

        return listado;
	}
	
    private Query getFindQuery(TrazProgramacionFilter filtro) {
        
    	Query query=null;
        try{
            if(filtro.getIdProgramacion()!=null && (filtro.getEstado()).equals("")){
            	
            	LOG.info("Id en findByIdProgramacion....."+filtro.getIdProgramacion());
            	query = crud.getEm().createNamedQuery("PghTrazProgramacion.findByIdProgramacion");
            
            } else if(filtro.getIdProgramacion()!=null && !(filtro.getEstado()).equals("")) {
            	
            	query = crud.getEm().createNamedQuery("PghTrazProgramacion.findByEstado");

            }
         
            if(filtro.getIdProgramacion()!=null && (filtro.getEstado()).equals("")){
            
            	LOG.info("Valor Ingresado....."+filtro.getIdProgramacion());
            	query.setParameter("idProgramacion",filtro.getIdProgramacion());
            	
            }else if(filtro.getIdProgramacion()!=null && !(filtro.getEstado()).equals("")) {
            	
            	LOG.info("Valores Ingresados....."+filtro.getIdProgramacion());
            	query.setParameter("idProgramacion",filtro.getIdProgramacion());
            	query.setParameter("estado",filtro.getEstado());
            }
           
        }catch(Exception e){
        	
            LOG.error("Error getFindQuery: "+e.getMessage());
            
        }
        return query;
    }

}
