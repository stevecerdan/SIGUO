package gob.osinergmin.sibad.service.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.sibad.domain.PghAlmacenamiento;
import gob.osinergmin.sibad.domain.PghCilindroGnv;
import gob.osinergmin.sibad.domain.builder.AlmacenamientoBuilder;
import gob.osinergmin.sibad.domain.builder.CilindroBuilder;
import gob.osinergmin.sibad.domain.dto.AlmacenamientoDTO;
import gob.osinergmin.sibad.domain.dto.CilindroGNVDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.AlmacenamientoFilter;
import gob.osinergmin.sibad.service.dao.AlmacenamientoDAO;
import gob.osinergmin.sibad.service.dao.CrudDAO;
import gob.osinergmin.sibad.service.exception.AlmacenamientoException;

@Repository("AlmacenamientoDAO")
@Transactional
public class AlmacenamientoDAOImpl implements AlmacenamientoDAO {
	
	 private static final Logger LOG = LoggerFactory.getLogger(AlmacenamientoDAOImpl.class);
	    @Inject
	    private CrudDAO crud;
	
	@Override
	public List<AlmacenamientoDTO> find(AlmacenamientoFilter filtro) throws AlmacenamientoException {
		
    List<AlmacenamientoDTO> listado;
        
        Query query = getFindQuery(filtro);
        listado = AlmacenamientoBuilder.toListAlmacenamientoDto(query.getResultList());

        return listado;
	}
	
	private Query getFindQuery(AlmacenamientoFilter filtro) {
        Query query=null;
        try{
            if(filtro.getIdUnidadSupervisada()!=null){
            	
            	query = crud.getEm().createNamedQuery("PghAlmacenamiento.findByIdUnidadSupervisada");
            	
            }else if(filtro.getIdAlmacenamiento()!=null){
            	
            	query = crud.getEm().createNamedQuery("PghAlmacenamiento.findByIdAlmacenamiento");
            }
         
            if(filtro.getIdUnidadSupervisada()!=null){
            	
            	query.setParameter("idUnidadSupervisada",filtro.getIdUnidadSupervisada());
            	
            }else if(filtro.getIdAlmacenamiento()!=null){
               
            	query.setParameter("idAlmacenamiento",filtro.getIdAlmacenamiento());
            }
           
        }catch(Exception e){
        	
            LOG.error("Error getFindQuery: "+e.getMessage());
            
        }
        return query;
    }

	@Override
	public AlmacenamientoDTO create(AlmacenamientoDTO almacenamientoDTO, UsuarioDTO usuarioDTO) {
		LOG.info("Iniciando registro de Almacenamiento");
		LOG.info("ServiceDAOImpl: "+ almacenamientoDTO.getIdAlmacenamiento() + " - " + almacenamientoDTO.getEstado());
		AlmacenamientoDTO retorno=null;
		
		PghAlmacenamiento pghAlmacenamiento =  new PghAlmacenamiento();
		
		try {
			if(almacenamientoDTO.getIdAlmacenamiento() == null) {
				pghAlmacenamiento.setEstado(almacenamientoDTO.getEstado());
				pghAlmacenamiento.setIdAlmacenamiento(almacenamientoDTO.getIdAlmacenamiento());
				pghAlmacenamiento.setNumero(almacenamientoDTO.getNumero());
				pghAlmacenamiento.setNumeroSerie(almacenamientoDTO.getNumeroserie());
								
				LOG.info("CREATE");
				crud.create(pghAlmacenamiento);
			}else {
				LOG.info("UPDATE");
				LOG.info("DAOIMPL: "+ almacenamientoDTO.getIdAlmacenamiento() + " - " + almacenamientoDTO.getEstado());
				
				pghAlmacenamiento =  crud.find(almacenamientoDTO.getIdAlmacenamiento(), PghAlmacenamiento.class);

				LOG.info("DAOIMPL: "+ pghAlmacenamiento.getIdAlmacenamiento() + " - " + pghAlmacenamiento.getEstado());
				pghAlmacenamiento.setEstado(almacenamientoDTO.getEstado());
				
				crud.update(pghAlmacenamiento);
			}
			retorno = AlmacenamientoBuilder.toAlmacenamientoDto(pghAlmacenamiento);
			 
			LOG.info("Registro exitoso retorno DAOIMPL: "+retorno.getIdAlmacenamiento());
			
		} catch (Exception e) {
            LOG.error("A partir de aqui error: ",e);
		}
		
		
		return retorno;
	}

}
