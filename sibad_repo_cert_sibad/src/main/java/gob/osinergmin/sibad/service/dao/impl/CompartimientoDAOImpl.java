package gob.osinergmin.sibad.service.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.sibad.domain.PghAlmacenamiento;
import gob.osinergmin.sibad.domain.PghCompartimiento;
import gob.osinergmin.sibad.domain.builder.AlmacenamientoBuilder;
import gob.osinergmin.sibad.domain.builder.CompartimientoBuilder;
import gob.osinergmin.sibad.domain.dto.AlmacenamientoDTO;
import gob.osinergmin.sibad.domain.dto.CompartimientoDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.CompartimientoFilter;
import gob.osinergmin.sibad.service.dao.CompartimientoDAO;
import gob.osinergmin.sibad.service.dao.CrudDAO;
import gob.osinergmin.sibad.service.exception.CompartimientoException;

@Repository("CompartimientoDAO")
@Transactional
public class CompartimientoDAOImpl implements CompartimientoDAO{
	
	private static final Logger LOG = LoggerFactory.getLogger(CompartimientoDAOImpl.class);
    @Inject
    private CrudDAO crud;
	
    
    @Override
	public List<CompartimientoDTO> find(CompartimientoFilter filtro) throws CompartimientoException {
		
    	 List<CompartimientoDTO> listado;
         
         Query query = getFindQuery(filtro);
         listado = CompartimientoBuilder.toListCompartimientoDto(query.getResultList());

         return listado;
	}
    
    private Query getFindQuery(CompartimientoFilter filtro) {
        
    	Query query=null;
        try{
            if(filtro.getIdAlmacenamiento()!=null){
            	LOG.info("Id en findByIdAlmacenamiento....."+filtro.getIdAlmacenamiento());
            	query = crud.getEm().createNamedQuery("PghCompartimiento.findByIdAlmacenamiento");
            }
         
            if(filtro.getIdAlmacenamiento()==null){
                query.setParameter("idAlmacenamiento","");
            }else {
            	LOG.info("Valor Ingresado....."+filtro.getIdAlmacenamiento());
            	query.setParameter("idAlmacenamiento",filtro.getIdAlmacenamiento());
            }
           
        }catch(Exception e){
        	
            LOG.error("Error getFindQuery: "+e.getMessage());
            
        }
        return query;
    }

	@Override
	public List<CompartimientoDTO> findV(CompartimientoFilter filtro) throws CompartimientoException {
		
         List<CompartimientoDTO> listado;
         
         Query query = getFindQueryV(filtro);
         listado = CompartimientoBuilder.toListCompartimientoVDto(query.getResultList());

         return listado;
	}
	
    private Query getFindQueryV(CompartimientoFilter filtro) {
        
    	Query query=null;
        try{
            if(filtro.getIdUnidadSupervisada()!=null){
           
            	query = crud.getEm().createNamedQuery("PghCompartimientoV.findByIdUnidadSupervisada");
            }
         
            if(filtro.getIdUnidadSupervisada()==null){
            	if(filtro.getFechaProxPrueba() != null){
                	LOG.info("BUSCARA POR FECHA: "+filtro.getFechaProxPrueba());
                	query = crud.getEm().createNamedQuery("PghCompartimientoV.findByFechaProxPrueba");
                	query.setParameter("fechaProxPrueba",filtro.getFechaProxPrueba());
            	}else            	
            		query.setParameter("idUnidadSupervisada","");
                
            }else {
            
            	query.setParameter("idUnidadSupervisada",filtro.getIdUnidadSupervisada());
            }
           
        }catch(Exception e){
        	
            LOG.error("Error getFindQuery: "+e.getMessage());
            
        }
        return query;
    }

	@Override
	public List<CompartimientoDTO> findIdCompartimiento(CompartimientoFilter filtro) throws CompartimientoException {
		List<CompartimientoDTO> listado;
        
        Query query = getFindQueryId(filtro);
        listado = CompartimientoBuilder.toListCompartimientoDto(query.getResultList());

        return listado;
	}

    private Query getFindQueryId(CompartimientoFilter filtro) {
        
    	Query query=null;
        try{
            if(filtro.getIdCompartimiento()!=0){
            	
            	query = crud.getEm().createNamedQuery("PghCompartimiento.findByIdCompartimiento");
            }
         
            if(filtro.getIdCompartimiento()!=0){

            	query.setParameter("idCompartimiento",filtro.getIdCompartimiento());
            }
           
        }catch(Exception e){
        	
            LOG.error("Error getFindQuery: "+e.getMessage());
            
        }
        return query;
    }

	@Override
	public CompartimientoDTO create(CompartimientoDTO compartimientoDTO, UsuarioDTO usuarioDTO) {
		LOG.info("Iniciando registro de CompartimientoDTO");
		LOG.info("DAOImpl: "+ compartimientoDTO.getIdCompartimiento() + " - " + compartimientoDTO.getEstado());
		CompartimientoDTO retorno=null;
		
		PghCompartimiento pghCompartimiento =  new PghCompartimiento();
		
		try {
			if(compartimientoDTO.getIdCompartimiento() == null) {
				pghCompartimiento.setEstado(compartimientoDTO.getEstado());
				pghCompartimiento.setIdAlmacenamiento(compartimientoDTO.getIdAlmacenamiento());
				pghCompartimiento.setNumero(compartimientoDTO.getNumero());
								
				LOG.info("CREATE");
				crud.create(pghCompartimiento);
			}else {
				LOG.info("UPDATE");
				LOG.info("DAOIMPL: "+ compartimientoDTO.getIdCompartimiento() + " - " + compartimientoDTO.getEstado());
				
				pghCompartimiento =  crud.find(compartimientoDTO.getIdCompartimiento(), PghCompartimiento.class);

				LOG.info("DAOIMPL: "+ pghCompartimiento.getIdCompartimiento() + " - " + pghCompartimiento.getEstado());
				pghCompartimiento.setEstado(compartimientoDTO.getEstado());
				
				crud.update(pghCompartimiento);
			}
			retorno = CompartimientoBuilder.toCompartimientoDto(pghCompartimiento);
			 
			LOG.info("Registro exitoso retorno DAOIMPL: "+retorno.getIdAlmacenamiento());
			
		} catch (Exception e) {
            LOG.error("A partir de aqui error: ",e);
		}
		
		
		return retorno;
	}
	
	@Override
	public CompartimientoDTO update(CompartimientoDTO compartimientoDTO, UsuarioDTO usuarioDTO)throws CompartimientoException {
		
		CompartimientoDTO retorno=null;
		PghCompartimiento pghCompartimiento = new PghCompartimiento(); 
		
	  try{	
	  
		  LOG.error("UPDATE");
		  pghCompartimiento = crud.find(compartimientoDTO.getIdCompartimiento(),PghCompartimiento.class);
		  
		  pghCompartimiento.setIdCompartimiento(compartimientoDTO.getIdCompartimiento());
		  pghCompartimiento.setFechaProximaPrueba(compartimientoDTO.getFechaProximaPrueba());
		  pghCompartimiento.setDatosAuditoria(usuarioDTO);
		  
		  crud.update(pghCompartimiento);
	    	
		  retorno = CompartimientoBuilder.toCompartimientoDto(pghCompartimiento);
			 
		  LOG.info("(Registro exitoso) retorno: "+retorno.getIdCompartimiento());

	  
	  }catch(Exception e){
      	
          LOG.error("Error getFindQuery: "+e.getMessage());
          
      }
		return retorno;
	}
}
