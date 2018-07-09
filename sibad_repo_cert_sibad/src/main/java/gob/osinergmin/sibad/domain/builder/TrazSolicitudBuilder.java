package gob.osinergmin.sibad.domain.builder;

import java.util.ArrayList;
import java.util.List;

import gob.osinergmin.sibad.domain.PghTrazAlcanceAcred;
import gob.osinergmin.sibad.domain.PghTrazProgramacion;
import gob.osinergmin.sibad.domain.PghTrazSolicitud;
import gob.osinergmin.sibad.domain.dto.TrazAlcanceAcredDTO;
import gob.osinergmin.sibad.domain.dto.TrazProgramacionDTO;
import gob.osinergmin.sibad.domain.dto.TrazSolicitudDTO;

public class TrazSolicitudBuilder {


	public static List<TrazSolicitudDTO> toListTrazSolicitudDto(List<PghTrazSolicitud> lista) {
		
		TrazSolicitudDTO registroDTO;
	        
		List<TrazSolicitudDTO> retorno = new ArrayList<TrazSolicitudDTO>();
	        if (lista != null) {
	            for (PghTrazSolicitud valor : lista) {
	                registroDTO = toTrazSolicitudDto(valor);
	                retorno.add(registroDTO);
	            }
	        }
	        return retorno;
	} 
	
	public static TrazSolicitudDTO toTrazSolicitudDto(PghTrazSolicitud registro) {
	       
		TrazSolicitudDTO registroDTO = new TrazSolicitudDTO();
        
        registroDTO.setIdTrazSolicitud(registro.getIdTrazSolicitud());
        registroDTO.setIdSolicitudPruebaReprueba(registro.getIdSolicitudPruebaReprueba());
        registroDTO.setFechaUltimoEstado(registro.getFechaUltimoEstado());
        registroDTO.setEstado(registro.getEstado());
        registroDTO.setIdTipoMotivo(registro.getIdTipoMotivo());
        registroDTO.setObservacion(registro.getObservacion());
        
        return registroDTO;
    }
	
	public static PghTrazSolicitud getTrazSolicitud(TrazSolicitudDTO registroDTO) {
        PghTrazSolicitud registro = null;
        if(registroDTO!=null){
            registro=new PghTrazSolicitud();
            registro.setIdTrazSolicitud(registroDTO.getIdTrazSolicitud());
            registro.setIdSolicitudPruebaReprueba(registroDTO.getIdSolicitudPruebaReprueba());
            registro.setFechaUltimoEstado(registroDTO.getFechaUltimoEstado());
            registro.setEstado(registroDTO.getEstado());
	        registro.setIdTipoMotivo(registroDTO.getIdTipoMotivo());
	        registro.setObservacion(registroDTO.getObservacion());
        }
        return registro;

    }
	
}
