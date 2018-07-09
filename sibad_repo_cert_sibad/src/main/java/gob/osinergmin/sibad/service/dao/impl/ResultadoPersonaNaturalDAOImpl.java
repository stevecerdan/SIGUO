package gob.osinergmin.sibad.service.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.sibad.domain.PghResultadoPersonaNatural;
import gob.osinergmin.sibad.domain.PghResultadoPersonaNaturalV;
import gob.osinergmin.sibad.domain.PghSedePersonalAutorizado;
import gob.osinergmin.sibad.domain.builder.ResultadoPersonaNaturalBuilder;
import gob.osinergmin.sibad.domain.builder.SedePersonalAutorizadoBuilder;
import gob.osinergmin.sibad.domain.dto.ResultadoPersonaNaturalDTO;
import gob.osinergmin.sibad.domain.dto.SedePersonalAutorizadoDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.ResultadoPersonaNaturalFilter;
import gob.osinergmin.sibad.service.dao.CrudDAO;
import gob.osinergmin.sibad.service.dao.ResultadoPersonaNaturalDAO;
import gob.osinergmin.sibad.service.exception.ResultadoPersonaNaturalException;

@Repository("ResultadoPersonaNaturalDAO")
@Transactional
public class ResultadoPersonaNaturalDAOImpl implements ResultadoPersonaNaturalDAO{
	 private static final Logger LOG = LoggerFactory.getLogger(ResultadoPersonaNaturalDAOImpl.class);
	 @Inject
	 private CrudDAO crud;
	 
	@Override
	public List<ResultadoPersonaNaturalDTO> find(ResultadoPersonaNaturalFilter filtro) throws ResultadoPersonaNaturalException {
		List<ResultadoPersonaNaturalDTO> listado;
        
        Query query = getFindQuery(filtro);
        listado = ResultadoPersonaNaturalBuilder.toListPersonaNaturalDto(query.getResultList());

        return listado;
	}
	
	@Override
	public ResultadoPersonaNaturalDTO create(ResultadoPersonaNaturalDTO resultadoPersonaNaturalDTO, UsuarioDTO usuarioDTO) {
		
		PghResultadoPersonaNatural pghResultadoPersonaNatural = ResultadoPersonaNaturalBuilder.toPghResultadoPersonaNatural(resultadoPersonaNaturalDTO);
		pghResultadoPersonaNatural.setDatosAuditoria(usuarioDTO);
		
		if (resultadoPersonaNaturalDTO.getIdResultadoPersonaNatural() != null) {
			LOG.error("UPDATE");
			crud.update(pghResultadoPersonaNatural);
		}else {
			LOG.error("CREATE");
			crud.create(pghResultadoPersonaNatural);
		}	
		return resultadoPersonaNaturalDTO;
	}
	
	private Query getFindQuery(ResultadoPersonaNaturalFilter filtro) {
        Query query=null;
        try{
            if(filtro.getIdResultadoPersonaNatural() !=null){
            	LOG.error("Error Buscara por ID RPN: " + filtro.getIdResultadoPersonaNatural());
                query = crud.getEm().createNamedQuery("PghResultadoPersonaNaturalV.findById");
                
            }else if(filtro.getNumeroDocumento()!=null && !filtro.getNumeroDocumento().equals("")){
            	LOG.error("F: " + filtro.getNumeroDocumento());
            	query = crud.getEm().createNamedQuery("PghResultadoPersonaNaturalV.findByDocumento");
            }else{
            	LOG.error("Buscara por Filter: " +  filtro.getIdResultadoRevision() + " - " + filtro.getNumeroDocumento());
                query = crud.getEm().createNamedQuery("PghResultadoPersonaNaturalV.findByFilter");
            }
            
            if(filtro.getIdResultadoPersonaNatural()==null){
            	LOG.error("IDRPN: " + filtro.getIdResultadoRevision() + " - " + filtro.getNumeroDocumento());
            	
                if(filtro.getIdResultadoRevision()!=null && !(filtro.getIdResultadoRevision()+"").equals("") ){
                	LOG.error("Entro idRR" );
                    query.setParameter("idResultadoRevision",filtro.getIdResultadoRevision() );
                }
                
                if(filtro.getNumeroDocumento()!=null && !(filtro.getNumeroDocumento()).equals("") ){
                	LOG.error("Entro nroDoc" );
                    query.setParameter("numeroDocumento", "%" + filtro.getNumeroDocumento() +"%" );
                }else{
                    query.setParameter("numeroDocumento","%");
                }
                
            }else {
                query.setParameter("idResultadoPersonaNatural",filtro.getIdResultadoPersonaNatural());
            }
            //query.setParameter("idPersonal",filtro.getIdPersonal());
        }catch(Exception e){
            LOG.error("Error getFindQuery: "+e.getMessage());
        }
        return query;
    }

	@Override
	public ResultadoPersonaNaturalDTO eliminarPersonal(ResultadoPersonaNaturalDTO resultadoPersonaDTO) {
		LOG.info("eliminarSedePersonal DAO IMPL- ID = "+ resultadoPersonaDTO.getIdResultadoPersonaNatural());
		ResultadoPersonaNaturalDTO retorno = null;
		
		try {
			LOG.info("ingreso al try catch- ID = "+ resultadoPersonaDTO.getIdResultadoPersonaNatural());
			//Map<String, Object> valida= validaEliminarPersonalAutorizado(personalAutorizadoDTO.getIdSedePersonalAutorizado());
			PghResultadoPersonaNatural registroDTO = crud.find(resultadoPersonaDTO.getIdResultadoPersonaNatural(), PghResultadoPersonaNatural.class);
			LOG.info("llena registroDTO= "+ registroDTO.getIdResultadoPersonaNatural());
			crud.delete(registroDTO);
			retorno = ResultadoPersonaNaturalBuilder.toPersonaNaturalDto(registroDTO);
		} catch (Exception ex) {
			 LOG.error("error eliminar = ",ex);
		}
		return retorno;
	}
}
