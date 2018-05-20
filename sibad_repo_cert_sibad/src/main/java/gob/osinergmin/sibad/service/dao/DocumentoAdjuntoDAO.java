/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.service.dao;

import gob.osinergmin.sibad.domain.dto.DocumentoAdjuntoDTO;
import gob.osinergmin.sibad.domain.dto.UsuarioDTO;
import gob.osinergmin.sibad.filter.DocumentoAdjuntoFilter;
import gob.osinergmin.sibad.service.exception.DocumentoAdjuntoException;

import java.util.List;

/**
 *
 * @author jpiro
 */
public interface DocumentoAdjuntoDAO {
    public List<DocumentoAdjuntoDTO> find(DocumentoAdjuntoFilter filtro) throws DocumentoAdjuntoException;
    public DocumentoAdjuntoDTO create(DocumentoAdjuntoDTO documentoAdjuntoDTO,UsuarioDTO usuarioDTO) throws DocumentoAdjuntoException;
    public DocumentoAdjuntoDTO update(DocumentoAdjuntoDTO documentoAdjuntoDTO,UsuarioDTO usuarioDTO) throws DocumentoAdjuntoException;
    
}
