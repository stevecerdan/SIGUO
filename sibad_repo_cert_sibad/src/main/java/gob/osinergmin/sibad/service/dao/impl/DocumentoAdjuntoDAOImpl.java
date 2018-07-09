/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.dao.impl;

import gob.osinergmin.sibad.domain.PghDocumentoAdjunto;
import gob.osinergmin.sibad.domain.builder.DocumentoAdjuntoBuilder;
import gob.osinergmin.sibad.domain.dto.DocumentoAdjuntoDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.DocumentoAdjuntoFilter;
import gob.osinergmin.sibad.service.dao.CrudDAO;
import gob.osinergmin.sibad.service.dao.DocumentoAdjuntoDAO;
import gob.osinergmin.sibad.service.exception.DocumentoAdjuntoException;

import java.util.List;
import javax.inject.Inject;
import javax.persistence.Query;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("DocumentoAdjuntoDAO")
@Transactional
public class DocumentoAdjuntoDAOImpl implements DocumentoAdjuntoDAO{
    private static final Logger LOG = LoggerFactory.getLogger(DocumentoAdjuntoDAOImpl.class);
    @Inject
    private CrudDAO crud;
    
    @Override
    public List<DocumentoAdjuntoDTO> find(DocumentoAdjuntoFilter filtro) throws DocumentoAdjuntoException {
        List<DocumentoAdjuntoDTO> listado;
        
        Query query = getFindQuery(filtro);
        listado = DocumentoAdjuntoBuilder.toListDocumentoAdjuntoDto(query.getResultList());

        return listado;
    }
    
    private Query getFindQuery(DocumentoAdjuntoFilter filtro) {
        Query query=null;
        try{
            if(filtro.getIdDocumentoAdjunto()!=null){
                query = crud.getEm().createNamedQuery("PghDocumentoAdjunto.findByIdDoc");
            }
            
            if(filtro.getIdDocumentoAdjunto()!=null){
                query.setParameter("idDocumentoAdjunto",filtro.getIdDocumentoAdjunto());
            }
            //query.setParameter("idPersonal",filtro.getIdPersonal());
        }catch(Exception e){
            LOG.error("Error getFindQuery: "+e.getMessage());
        }
        return query;
    }
    
    @Override
	public DocumentoAdjuntoDTO create(DocumentoAdjuntoDTO documentoAdjuntoDTO, UsuarioDTO usuarioDTO)throws DocumentoAdjuntoException {
		
    	 LOG.info("Iniciando registro....");
 		
    	 DocumentoAdjuntoDTO retorno=null;
 		
 		try{
 			
 			PghDocumentoAdjunto  pghDocumentoAdjunto=  new PghDocumentoAdjunto();
 			
 			pghDocumentoAdjunto.setIdDocumentoAdjunto(documentoAdjuntoDTO.getIdDocumentoAdjunto());
 			pghDocumentoAdjunto.setNombreDocumento(documentoAdjuntoDTO.getNombreDocumento());
 			pghDocumentoAdjunto.setDescripcionDocumento(documentoAdjuntoDTO.getDescripcionDocumento());
 			pghDocumentoAdjunto.setArchivoAdjunto(documentoAdjuntoDTO.getArchivoAdjunto());
 			pghDocumentoAdjunto.setEstadoDocumento(documentoAdjuntoDTO.getEstadoDocumento());
 			pghDocumentoAdjunto.setDatosAuditoria(usuarioDTO);
 			
 		    LOG.info(" Datos:"+pghDocumentoAdjunto.getIdDocumentoAdjunto()+" - " +pghDocumentoAdjunto.getNombreDocumento()+" - " +pghDocumentoAdjunto.getArchivoAdjunto()+" - "+pghDocumentoAdjunto.getEstadoDocumento());

 		    crud. create(pghDocumentoAdjunto);

 			retorno = DocumentoAdjuntoBuilder.toDocumentoAdjuntoDto(pghDocumentoAdjunto);
 			 
 			LOG.info("(Registro exitoso) retorno: "+retorno.toString());
 		
 		}catch(Exception ex){
             LOG.error("",ex);
         }
 		
 		return retorno;
	}
    
    @Override
	public DocumentoAdjuntoDTO update(DocumentoAdjuntoDTO documentoAdjuntoDTO, UsuarioDTO usuarioDTO)throws DocumentoAdjuntoException {
		
	LOG.info("Iniciando actualizacion de Documento Adjunto");
		
	DocumentoAdjuntoDTO retorno = null;
		
		try {
			
			PghDocumentoAdjunto PghDocumentoAdjunto = crud.find(documentoAdjuntoDTO.getIdDocumentoAdjunto(), PghDocumentoAdjunto.class);
			
			PghDocumentoAdjunto.setIdDocumentoAdjunto(documentoAdjuntoDTO.getIdDocumentoAdjunto());
			PghDocumentoAdjunto.setEstadoDocumento(documentoAdjuntoDTO.getEstadoDocumento());
			PghDocumentoAdjunto.setDatosAuditoria(usuarioDTO);
			
			
			LOG.info(" Datos:"+PghDocumentoAdjunto.getIdDocumentoAdjunto()+" - " +PghDocumentoAdjunto.getEstadoDocumento());
			
			crud.update(PghDocumentoAdjunto);
			
			retorno = DocumentoAdjuntoBuilder.toDocumentoAdjuntoDTO(PghDocumentoAdjunto);
			 
			LOG.info("(Registro exitoso) retorno: "+retorno.toString());
			
			
		}catch(Exception ex){
            LOG.error("",ex);
        }
		
		return retorno;
	}

	@Override
	public DocumentoAdjuntoDTO delete(DocumentoAdjuntoDTO documentoAdjuntoDTO, UsuarioDTO usuarioDTO)throws DocumentoAdjuntoException {
		
		LOG.info("eliminarDocumentoAdjunto DAO IMPL- ID = "+ documentoAdjuntoDTO.getIdDocumentoAdjunto());
		DocumentoAdjuntoDTO retorno = null;
		
		try {
			LOG.info("ingreso al try catch- ID = "+ documentoAdjuntoDTO.getIdDocumentoAdjunto());
			
			PghDocumentoAdjunto registroDTO = crud.find(documentoAdjuntoDTO.getIdDocumentoAdjunto(), PghDocumentoAdjunto.class);
			
			LOG.info("llena registroDTO= "+ documentoAdjuntoDTO.getIdDocumentoAdjunto());
			
			crud.delete(registroDTO);

			retorno = DocumentoAdjuntoBuilder.toDocumentoAdjuntoDto(registroDTO);
		
		} catch (Exception ex) {
			 LOG.error("error eliminar = ",ex);
		}
		return retorno;
	}
   
    /*String query = null;
    
    public Files find(int id) {
    	
    	query = "select * from Pgh_Documento_Adjunto where idDocumentoAdjunto = ?";
 
        try {
            Files file = (Files) getJdbcTemplate().queryForObject(query, new Object[] {id},
            		
                new RowMapper() {
                    Files fl;
                    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                        fl = new Files();
                        fl.setIdDocumentoAdjunto(rs.getLong(1));
                        fl.setNombreDocumento(rs.getString(2));
                        fl.setArchivoAdjunto(rs.getBytes(3));
 
                        return fl;
                    }
            });
 
            return file;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
 
        return null;
    }*/
    
}
