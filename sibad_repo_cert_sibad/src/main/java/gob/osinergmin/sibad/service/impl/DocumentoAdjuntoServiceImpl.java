/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.impl;

import gob.osinergmin.sibad.domain.dto.AlcanceAcreditacionDTO;
import gob.osinergmin.sibad.domain.dto.DocumentoAdjuntoDTO;
import gob.osinergmin.sibad.domain.dto.ResultadoPruebaDocumentoDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.DocumentoAdjuntoFilter;
import gob.osinergmin.sibad.service.DocumentoAdjuntoService;
import gob.osinergmin.sibad.service.dao.DocumentoAdjuntoDAO;
import gob.osinergmin.sibad.service.exception.DocumentoAdjuntoException;

import java.util.List;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jpiro
 */
@Service("documentoadjuntoService")
public class DocumentoAdjuntoServiceImpl implements DocumentoAdjuntoService{
    private static final Logger LOG = LoggerFactory.getLogger(DocumentoAdjuntoServiceImpl.class);
    
    @Inject
    DocumentoAdjuntoDAO documentoadjuntoDAO;
    
    @Override
    @Transactional(readOnly = true)
    public List<DocumentoAdjuntoDTO> listarDocumentoAdjunto (DocumentoAdjuntoFilter filtro){
        List<DocumentoAdjuntoDTO> retorno=null;
        try{
            retorno = documentoadjuntoDAO.find(filtro);
            LOG.info("cuenta -size: "+retorno.size());
        }catch(Exception ex){
            LOG.error("Error en listarDocumentoAdjunto",ex);
        }
        return retorno;
    }
    
    @Override
	public DocumentoAdjuntoDTO RegistrarDocumentoAdjunto(DocumentoAdjuntoDTO documentoAdjuntoDTO,UsuarioDTO usuarioDTO) {
		
		LOG.info("Iniciando envio de datos DAO ....");
		
		DocumentoAdjuntoDTO registro=null;
		
		try {
			
			registro = documentoadjuntoDAO.create(documentoAdjuntoDTO, usuarioDTO);
			LOG.info("(Se envio con exito los datos al DAO) registro: "+registro.toString());
			 
		} catch (DocumentoAdjuntoException e) {
			
			LOG.error("error enviar datos de Empresa Acreditada al DAO",e);
		}
	
		return registro;
	}
    
    @Override
	public DocumentoAdjuntoDTO EditarDocumentoAdjunto(DocumentoAdjuntoDTO documentoAdjuntoDTO,UsuarioDTO usuarioDTO) {
		
		 LOG.info("Iniciando envio de datos de Documento Adjunto al DAO");
			
		 DocumentoAdjuntoDTO registro=null;
				
			try {
				
				registro = documentoadjuntoDAO.update(documentoAdjuntoDTO, usuarioDTO);
				LOG.info("(Se envio con exito los datos de Documento Adjunto al DAO) registro: "+registro.toString());
				 
			} catch (Exception e) {
				
				LOG.error("error enviar datos de  Documento Adjunto al DAO",e);
			}
		
			return registro;
	}

	@Override
	public DocumentoAdjuntoDTO EliminarDocumentoAdjunto(DocumentoAdjuntoDTO documentoAdjuntoDTO,UsuarioDTO usuarioDTO) {
		
		 LOG.info("Iniciando envio de datos al DAO");
			
		 DocumentoAdjuntoDTO registro=null;
			
			try {
							
				registro = documentoadjuntoDAO.delete(documentoAdjuntoDTO,usuarioDTO);
				LOG.info("(Se envio con exito los datos al DAO) registro: "+registro.toString());
				 
			} catch (Exception e) {
				
				LOG.error("error enviar datos al DAO",e);
			}
		
			return registro;
	}
}
