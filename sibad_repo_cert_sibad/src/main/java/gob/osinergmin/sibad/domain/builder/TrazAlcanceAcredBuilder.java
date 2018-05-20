package gob.osinergmin.sibad.domain.builder;

import gob.osinergmin.sibad.domain.PghTrazAlcanceAcred;
import gob.osinergmin.sibad.domain.dto.TrazAlcanceAcredDTO;

public class TrazAlcanceAcredBuilder {
	
	 public static TrazAlcanceAcredDTO toTrazAlcanceAcredDto(PghTrazAlcanceAcred registro) {
	       
		    TrazAlcanceAcredDTO registroDTO = new TrazAlcanceAcredDTO();
		    
	        registroDTO.setIdAlcanceAcreditacion(registro.getIdAlcanceAcreditacion());
	        registroDTO.setIdTipoMotivo(registro.getIdTipoMotivo());
	        registroDTO.setEstado(registro.getEstado());
	        registroDTO.setEstadoAccion(registro.getEstadoAccion());
	        registroDTO.setIdDocumentoAdjunto(registro.getIdDocumentoAdjunto());
	        registroDTO.setObservacion(registro.getObservacion());
	        
	        return registroDTO;
	    }

}
