package gob.osinergmin.sibad.domain.builder;

import java.util.ArrayList;
import java.util.List;

import gob.osinergmin.sibad.domain.PghTrazProgramacion;
import gob.osinergmin.sibad.domain.dto.TrazProgramacionDTO;

public class TrazProgramacionBuilder {


	public static List<TrazProgramacionDTO> toListTrazProgramacionDto(List<PghTrazProgramacion> lista) {
		
		TrazProgramacionDTO registroDTO;
	        
		List<TrazProgramacionDTO> retorno = new ArrayList<TrazProgramacionDTO>();
	        if (lista != null) {
	            for (PghTrazProgramacion valor : lista) {
	                registroDTO = toTrazProgramacionDto(valor);
	                retorno.add(registroDTO);
	            }
	        }
	        return retorno;
	} 
	
	public static TrazProgramacionDTO toTrazProgramacionDto(PghTrazProgramacion registro) {
	       
		TrazProgramacionDTO registroDTO = new TrazProgramacionDTO();
        
        registroDTO.setIdTrazProgramacion(registro.getIdTrazProgramacion());
        registroDTO.setIdProgramacion(registro.getIdProgramacion());
        registroDTO.setFechaUltimoEstado(registro.getFechaUltimoEstado());
        registroDTO.setObservacion(registro.getObservacion());
        registroDTO.setEstado(registro.getEstado());
        registroDTO.setIdTipoMotivo(registro.getIdTipoMotivo());
        
        return registroDTO;
    }
	
	
}
