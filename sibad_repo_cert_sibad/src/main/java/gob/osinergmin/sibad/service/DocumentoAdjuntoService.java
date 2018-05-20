/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service;

import gob.osinergmin.sibad.domain.dto.DocumentoAdjuntoDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.DocumentoAdjuntoFilter;
import gob.osinergmin.sibad.service.exception.DocumentoAdjuntoException;

import java.util.List;

/**
 *
 * @author jpiro
 */
public interface DocumentoAdjuntoService {
    public List<DocumentoAdjuntoDTO> listarDocumentoAdjunto(DocumentoAdjuntoFilter filtro);
    public DocumentoAdjuntoDTO RegistrarDocumentoAdjunto(DocumentoAdjuntoDTO documentoAdjuntoDTO,UsuarioDTO usuarioDTO);
    public DocumentoAdjuntoDTO EditarDocumentoAdjunto(DocumentoAdjuntoDTO documentoAdjuntoDTO,UsuarioDTO usuarioDTO);
}
