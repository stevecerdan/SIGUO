package gob.osinergmin.sibad.service.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.sibad.domain.builder.ProductoxCompartimientoBuilder;
import gob.osinergmin.sibad.domain.dto.ProductoxCompartimientoDTO;
import gob.osinergmin.sibad.filter.ProductoxCompartimientoFilter;
import gob.osinergmin.sibad.service.dao.CrudDAO;
import gob.osinergmin.sibad.service.dao.ProductoxCompartimientoDAO;
import gob.osinergmin.sibad.service.exception.ProductoxCompartimientoException;

@Repository("ProductoxCompartimientoDAO")
@Transactional
public class ProductoxCompartimientoDAOImpl implements ProductoxCompartimientoDAO{    private static final Logger LOG = LoggerFactory.getLogger(PersonaNaturalVDAOImpl.class);
	@Inject
	private CrudDAO crud;

	@Override
	public List<ProductoxCompartimientoDTO> find(ProductoxCompartimientoFilter filtro)
			throws ProductoxCompartimientoException {
		List<ProductoxCompartimientoDTO> listado;
	    
	    Query query = getFindQuery(filtro);
	    listado = ProductoxCompartimientoBuilder.toListProductoxCompartimientoDto(query.getResultList());

	    return listado;
	}
	
	private Query getFindQuery(ProductoxCompartimientoFilter filtro) {
        Query query=null;
        try{
            if(filtro.getIdCompartimiento() !=null){
            	LOG.error("Error Buscara por ID RPN: " + filtro.getIdCompartimiento());
                query = crud.getEm().createNamedQuery("PghProductoxCompartimientoV.findById");
            }else{
            	LOG.error("Buscara por Filter");
                query = crud.getEm().createNamedQuery("PghProductoxCompartimientoV.findByFilter");
            }
            
            if(filtro.getIdCompartimiento()==null){
            	
                if(filtro.getIdResultadoRevision()!=null && !filtro.getIdResultadoRevision().equals("")){
                    query.setParameter("idResultadoRevision", filtro.getIdResultadoRevision());
                }else{
                    query.setParameter("idResultadoRevision","");
                }
            }else{
                query.setParameter("idResultadoPersonaNatural",filtro.getIdCompartimiento());
            }
            //query.setParameter("idPersonal",filtro.getIdPersonal());
        }catch(Exception e){
            LOG.error("Error getFindQuery: "+e.getMessage());
        }
        return query;
    }

}
