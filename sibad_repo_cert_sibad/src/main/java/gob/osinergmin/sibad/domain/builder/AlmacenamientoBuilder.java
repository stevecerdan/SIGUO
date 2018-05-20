package gob.osinergmin.sibad.domain.builder;

import java.util.ArrayList;
import java.util.List;


import gob.osinergmin.sibad.domain.PghAlmacenamiento;
import gob.osinergmin.sibad.domain.dto.AlmacenamientoDTO;


public class AlmacenamientoBuilder {

	public static List<AlmacenamientoDTO> toListAlmacenamientoDto(List<PghAlmacenamiento> lista) {
		AlmacenamientoDTO registroDTO;
	        List<AlmacenamientoDTO> retorno = new ArrayList<AlmacenamientoDTO>();
	        if (lista != null) {
	            for (PghAlmacenamiento valor : lista) {
	                registroDTO = toAlmacenamientoDto(valor);
	                retorno.add(registroDTO);
	            }
	        }
	        return retorno;
	} 
	
	public static AlmacenamientoDTO toAlmacenamientoDto(PghAlmacenamiento registro) {
	    	
		    AlmacenamientoDTO registroDTO = new AlmacenamientoDTO();
	        
		    registroDTO.setIdAlmacenamiento(registro.getIdAlmacenamiento());
		    registroDTO.setNumero(registro.getNumero());
		    registroDTO.setNumeroserie(registro.getNumeroSerie());
		    registroDTO.setEstado(registro.getEstado());
	        
	        return registroDTO;
	    }
}
