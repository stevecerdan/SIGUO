package gob.osinergmin.sibad.service.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.osinergmin.sibad.domain.PghResultadoDocumento;
import gob.osinergmin.sibad.domain.PghResultadoPersonaNatural;
import gob.osinergmin.sibad.domain.builder.ResultadoDocumentoBuilder;
import gob.osinergmin.sibad.domain.builder.ResultadoPersonaNaturalBuilder;
import gob.osinergmin.sibad.domain.dto.ResultadoDocumentoDTO;
import gob.osinergmin.sibad.domain.dto.ResultadoPersonaNaturalDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.ResultadoDocumentoFilter;
import gob.osinergmin.sibad.service.dao.CrudDAO;
import gob.osinergmin.sibad.service.dao.ResultadoDocumentoDAO;
import gob.osinergmin.sibad.service.exception.ResultadoDocumentoException;

@Repository("ResultadoDocumentoDAO")
@Transactional
public class ResultadoDocumentoDAOImpl implements ResultadoDocumentoDAO{
	private static final Logger LOG = LoggerFactory.getLogger(ResultadoDocumentoDAOImpl.class);
	 @Inject
	 private CrudDAO crud;
	 
	@Override
	public List<ResultadoDocumentoDTO> find(ResultadoDocumentoFilter filtro) throws ResultadoDocumentoException {
	   List<ResultadoDocumentoDTO> listado;
       
       Query query = getFindQuery(filtro);
       listado = ResultadoDocumentoBuilder.toListDocumentoDto(query.getResultList());

       return listado;
	}
	
	private Query getFindQuery(ResultadoDocumentoFilter filtro) {
        Query query=null;
        try{
            if(filtro.getIdResultadoDocumento() !=null){
            	LOG.error("Error Buscara por ID RD: " + filtro.getIdResultadoDocumento());
                query = crud.getEm().createNamedQuery("PghResultadoDocumentoV.findById");
            }else if(filtro.getIdResultadoRevision() !=0){
            	LOG.error("Buscara por Filter: " +  filtro.getIdResultadoRevision() );
                query = crud.getEm().createNamedQuery("PghResultadoDocumentoV.findByFilter");
            }
            
            if(filtro.getIdResultadoRevision()!=null){
            	//LOG.error("IDRPN null: " + filtro.getIdResultadoRevision() + " - " + filtro.getIdResultadoDocumento());            	
                if(filtro.getIdResultadoRevision()!=null && !(filtro.getIdResultadoRevision()+"").equals("") ){
                	LOG.error("Entro idRR" );
                    query.setParameter("idResultadoRevision", filtro.getIdResultadoRevision());
                }
                
            }else if(filtro.getIdResultadoDocumento()!=null){
                query.setParameter("idResultadoDocumento",filtro.getIdResultadoDocumento());
            }
            //query.setParameter("idPersonal",filtro.getIdPersonal());
        }catch(Exception e){
            LOG.error("Error getFindQuery: "+e.getMessage());
        }
        return query;
    }

	@Override
	public ResultadoDocumentoDTO eliminarDocumento(ResultadoDocumentoDTO resultadoDocumentoDTO) {
		LOG.info("eliminarDocumento DAO IMPL- ID = "+ resultadoDocumentoDTO.getIdResultadoDocumento());
		ResultadoDocumentoDTO retorno = null;
		
		try {
			LOG.info("ingreso al try catch- ID = "+ resultadoDocumentoDTO.getIdResultadoDocumento());
			//Map<String, Object> valida= validaEliminarPersonalAutorizado(personalAutorizadoDTO.getIdSedePersonalAutorizado());
			PghResultadoDocumento registro = crud.find(resultadoDocumentoDTO.getIdResultadoDocumento(), PghResultadoDocumento.class);
			LOG.info("llena registroDTO= "+ registro.getIdResultadoDocumento());
			crud.delete(registro);
			retorno = ResultadoDocumentoBuilder.toResultadoDocDto(registro);
		} catch (Exception ex) {
			 LOG.error("error eliminar = ",ex);
		}
		return retorno;
	}

	@Override
	public ResultadoDocumentoDTO create(ResultadoDocumentoDTO resultadoDocDTO, UsuarioDTO usuarioDTO) {
		PghResultadoDocumento pghResultadodocumento = ResultadoDocumentoBuilder.toPghResultadoDocumento(resultadoDocDTO);
		pghResultadodocumento.setDatosAuditoria(usuarioDTO);
		
		if (resultadoDocDTO.getIdResultadoDocumento() != null) {
			LOG.error("UPDATE");
			crud.update(pghResultadodocumento);
		}else {
			LOG.error("CREATE");
			crud.create(pghResultadodocumento);
		}
		
		
		
		return resultadoDocDTO;
	}

}
