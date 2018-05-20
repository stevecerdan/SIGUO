package gob.osinergmin.sibad.domain.builder;

import java.util.ArrayList;
import java.util.List;

import gob.osinergmin.sibad.domain.MdiUnidadSupervisada;
import gob.osinergmin.sibad.domain.dto.UnidadSupervisadaDTO;

public class UnidadSupervisadaBuilder {
	
	public static List<UnidadSupervisadaDTO> toListUnidadSupervisadaDto(List<MdiUnidadSupervisada> lista) {
		UnidadSupervisadaDTO registroDTO;
	        List<UnidadSupervisadaDTO> retorno = new ArrayList<UnidadSupervisadaDTO>();
	        if (lista != null) {
	            for (MdiUnidadSupervisada valor : lista) {
	                registroDTO = toUnidadSupervisadaDto(valor);
	                retorno.add(registroDTO);
	            }
	        }
	        return retorno;
	} 
	
	public static UnidadSupervisadaDTO toUnidadSupervisadaDto(MdiUnidadSupervisada registro) {
	    	
		UnidadSupervisadaDTO registroDTO = new UnidadSupervisadaDTO();
	        
		    registroDTO.setIdUnidadSupervisada(registro.getIdUnidadSupervisada());
		    registroDTO.setEstadoUnidadSupervisada(registro.getEstado());
		   
	        return registroDTO;
	}

}
