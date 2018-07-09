package gob.osinergmin.sibad.domain.builder;

import java.util.ArrayList;
import java.util.List;

import gob.osinergmin.sibad.domain.PghTrazAlcanceAcred;
import gob.osinergmin.sibad.domain.dto.TrazAlcanceAcredDTO;

public class TrazAlcanceAcredBuilder {
	
	public static List<TrazAlcanceAcredDTO> toListTrazAlcanceAcredDto(List<PghTrazAlcanceAcred> lista) {
		TrazAlcanceAcredDTO registroDTO;
	        List<TrazAlcanceAcredDTO> retorno = new ArrayList<TrazAlcanceAcredDTO>();
	        if (lista != null) {
	            for (PghTrazAlcanceAcred maestro : lista) {
	                registroDTO = toTrazAlcanceAcredDto(maestro);
	                retorno.add(registroDTO);
	            }
	        }
	        return retorno;
	    } 
	
	 public static TrazAlcanceAcredDTO toTrazAlcanceAcredDto(PghTrazAlcanceAcred registro) {
	       
		    TrazAlcanceAcredDTO registroDTO = new TrazAlcanceAcredDTO();
		    
	        registroDTO.setIdAlcanceAcreditacion(registro.getIdAlcanceAcreditacion());
	        registroDTO.setIdTipoMotivo(registro.getIdTipoMotivo());
	        registroDTO.setEstado(registro.getEstado());
	        registroDTO.setEstadoAccion(registro.getEstadoAccion());
	        registroDTO.setFechaUltimoEstado(registro.getFechaUltimoEstado());
	        registroDTO.setIdDocumentoAdjunto(registro.getIdDocumentoAdjunto());
	        registroDTO.setObservacion(registro.getObservacion());
	        
	        return registroDTO;
	    }
	 
	    public static PghTrazAlcanceAcred getTrazAlcanceAcred(TrazAlcanceAcredDTO registroDTO) {
	        PghTrazAlcanceAcred registro = null;
	        if(registroDTO!=null){
	            registro=new PghTrazAlcanceAcred();
	            registro.setIdAlcanceAcreditacion(registroDTO.getIdAlcanceAcreditacion());
		        registro.setIdTipoMotivo(registroDTO.getIdTipoMotivo());
		        registro.setEstado(registroDTO.getEstado());
		        registro.setEstadoAccion(registroDTO.getEstadoAccion());
		        registro.setFechaUltimoEstado(registroDTO.getFechaUltimoEstado());
		        registro.setIdDocumentoAdjunto(registroDTO.getIdDocumentoAdjunto());
		        registro.setObservacion(registroDTO.getObservacion());
	        }
	        return registro;

	    }

}
