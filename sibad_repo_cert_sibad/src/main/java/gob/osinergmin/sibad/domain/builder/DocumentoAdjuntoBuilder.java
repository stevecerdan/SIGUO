/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.osinergmin.sibad.domain.builder;

import gob.osinergmin.sibad.domain.dto.DocumentoAdjuntoDTO;
import gob.osinergmin.sibad.domain.PghDocumentoAdjunto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpiro
 */
public class DocumentoAdjuntoBuilder {
	
    public static List<DocumentoAdjuntoDTO> toListDocumentoAdjuntoDto(List<PghDocumentoAdjunto> lista) {
    	DocumentoAdjuntoDTO registroDTO;
        List<DocumentoAdjuntoDTO> retorno = new ArrayList<DocumentoAdjuntoDTO>();
        if (lista != null) {
            for (PghDocumentoAdjunto maestro : lista) {
                registroDTO = toDocumentoAdjuntoDto(maestro);
                retorno.add(registroDTO);
            }
        }
        return retorno;
    } 
    
    public static DocumentoAdjuntoDTO toDocumentoAdjuntoDTO(PghDocumentoAdjunto registro) {
    	DocumentoAdjuntoDTO registroDTO = new DocumentoAdjuntoDTO();
        
        registroDTO.setIdDocumentoAdjunto(registro.getIdDocumentoAdjunto());
        registroDTO.setEstadoDocumento(registro.getEstadoDocumento());
              
        return registroDTO;
    }
    
    
    public static DocumentoAdjuntoDTO toDocumentoAdjuntoDto(PghDocumentoAdjunto registro) {
    	DocumentoAdjuntoDTO registroDTO = new DocumentoAdjuntoDTO();
        
        registroDTO.setIdDocumentoAdjunto(registro.getIdDocumentoAdjunto());
        registroDTO.setNombreDocumento(registro.getNombreDocumento());
        registroDTO.setArchivoAdjunto(registro.getArchivoAdjunto());
        registroDTO.setEstadoDocumento(registro.getEstadoDocumento());
        registroDTO.setDescripcionDocumento(registro.getDescripcionDocumento());
              
        return registroDTO;
    }
    
    public static PghDocumentoAdjunto getDocumentoAdjunto(DocumentoAdjuntoDTO registroDTO) {
        PghDocumentoAdjunto registro = null;
        if(registroDTO!=null){
            registro=new PghDocumentoAdjunto();
            registro.setIdDocumentoAdjunto(registroDTO.getIdDocumentoAdjunto());
            registro.setNombreDocumento(registroDTO.getNombreDocumento());
            registro.setArchivoAdjunto(registroDTO.getArchivoAdjunto());
            registro.setEstadoDocumento(registroDTO.getEstadoDocumento());
            registro.setDescripcionDocumento(registroDTO.getDescripcionDocumento());
        }
        return registro;

    }
}
