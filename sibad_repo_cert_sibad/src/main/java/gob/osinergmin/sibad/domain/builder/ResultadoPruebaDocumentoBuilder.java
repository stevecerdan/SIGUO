package gob.osinergmin.sibad.domain.builder;

import java.util.ArrayList;
import java.util.List;

import gob.osinergmin.sibad.domain.PghResultadoPruebaDocumento;
import gob.osinergmin.sibad.domain.PghResultadoPruebaDocumentoV;
import gob.osinergmin.sibad.domain.dto.ResultadoPruebaDocumentoDTO;
import gob.osinergmin.sibad.domain.dto.ResultadoPruebaDocumentoVDTO;



public class ResultadoPruebaDocumentoBuilder {
	
   public static List<ResultadoPruebaDocumentoVDTO> toListResultadoPruebaDocumentoDto(List<PghResultadoPruebaDocumentoV> lista) {
		
    	ResultadoPruebaDocumentoVDTO registroDTO;
	        
		List<ResultadoPruebaDocumentoVDTO> retorno = new ArrayList<ResultadoPruebaDocumentoVDTO>();
	        if (lista != null) {
	            for (PghResultadoPruebaDocumentoV maestro : lista) {
	                registroDTO = toPghResultadoPruebaDocumentoV(maestro);
	                retorno.add(registroDTO);
	            }
	        }
	        
	   return retorno;
	}
    
  public static ResultadoPruebaDocumentoVDTO toPghResultadoPruebaDocumentoV(PghResultadoPruebaDocumentoV registro) {
		
	    ResultadoPruebaDocumentoVDTO registroDTO = new ResultadoPruebaDocumentoVDTO();

	    registroDTO.setIdResultadoPruebaDocumento(registro.getIdResultadoPruebaDocumento());
	    registroDTO.setIdDocumentoAdjunto(registro.getIdDocumentoAdjunto());
	    registroDTO.setIdResultadoPruebaReprueba(registro.getIdResultadoPruebaReprueba());
	    registroDTO.setNombreDocumento(registro.getNombreDocumento());
	    registroDTO.setDescripcionDocumento(registro.getDescripcionDocumento());
	    registroDTO.setArchivoAdjunto(registro.getArchivoAdjunto());
	    		
		return registroDTO;
	}
  
    public static ResultadoPruebaDocumentoDTO toPghResultadoPruebaDocumento(PghResultadoPruebaDocumento registro) {
		
	    ResultadoPruebaDocumentoDTO registroDTO = new ResultadoPruebaDocumentoDTO();

	    registroDTO.setIdResultadoPruebaDocumento(registro.getIdResultadoPruebaDocumento());
	    registroDTO.setIdDocumentoAdjunto(registro.getIdDocumentoAdjunto());
	    registroDTO.setIdResutadoPruebaReprueba(registro.getIdResutadoPruebaReprueba());
	    		
		return registroDTO;
	}
}
