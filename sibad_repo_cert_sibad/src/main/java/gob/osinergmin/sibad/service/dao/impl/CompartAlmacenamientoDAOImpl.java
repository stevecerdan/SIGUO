package gob.osinergmin.sibad.service.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.sibad.domain.builder.CompartAlmacenamientoBuilder;
import gob.osinergmin.sibad.domain.builder.CompartimientoBuilder;
import gob.osinergmin.sibad.domain.dto.CompartAlmacenamientoDTO;
import gob.osinergmin.sibad.domain.dto.CompartimientoDTO;
import gob.osinergmin.sibad.filter.CompartAlmacenamientoFilter;
import gob.osinergmin.sibad.filter.CompartimientoFilter;
import gob.osinergmin.sibad.service.dao.CompartAlmacenamientoDAO;
import gob.osinergmin.sibad.service.dao.CrudDAO;

@Repository("CompartAlmacenamientoDAO")
@Transactional
public class CompartAlmacenamientoDAOImpl implements CompartAlmacenamientoDAO{
	private static final Logger LOG = LoggerFactory.getLogger(CompartAlmacenamientoDAOImpl.class);
    @Inject
    private CrudDAO crud;

	@Override
	public List<CompartAlmacenamientoDTO> find(CompartAlmacenamientoFilter filtro) {
		List<CompartAlmacenamientoDTO> listado;
        
        Query query = getFindQuery(filtro);
        listado = CompartAlmacenamientoBuilder.toListCompartAlmDto(query.getResultList());

        return listado;
	}
	
	private Query getFindQuery(CompartAlmacenamientoFilter filtro) {
        
    	Query query=null;
        try{
            if(filtro.getNumeroSerie()!=null && filtro.getNumero()!=null){
            	LOG.info("Numeroserie: " + filtro.getNumeroSerie() + "numero: "+ filtro.getNumero());
            	query = crud.getEm().createNamedQuery("PghCompartAlmacenamiento.findBySerie");
            	query.setParameter("numeroSerie",filtro.getNumeroSerie());
            	query.setParameter("numero",filtro.getNumero());
            }
            if( filtro.getIdUnidadSupervisada()!=null ){
            	LOG.info("ID UNID SUPERVISADA: " + filtro.getIdUnidadSupervisada() );
            	query = crud.getEm().createNamedQuery("PghCompartAlmacenamiento.findByUnidad");
            	query.setParameter("idUnidadSupervisada",filtro.getIdUnidadSupervisada());
            }
            
        }catch(Exception e){
        	
            LOG.error("Error getFindQuery: "+e.getMessage());
            
        }
        return query;
    }

}
